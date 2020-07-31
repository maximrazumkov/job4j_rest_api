package ru.job4j.restapi.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.util.CollectionUtils;
import org.springframework.web.client.RestTemplate;
import ru.job4j.restapi.services.RestClient;
import ru.job4j.restapi.services.impl.SimpleRestClient;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Configuration
public class RestClientConfig {

    @Value("${extservice.url}")
    private String url;
    @Value("${extservice.login}")
    private String login;
    @Value("${extservice.password}")
    private String password;

    @Bean
    public RestClient restTemplate() {
        RestTemplate restTemplate = new RestTemplate();
        Map<String, Object> param = new HashMap<>();
        param.put("login", login);
        param.put("password", password);
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<Map<String, Object>> entity = new HttpEntity<>(param, headers);
        ResponseEntity<String> response = restTemplate.postForEntity(url, entity, String.class);
        HttpHeaders headersResponse = response.getHeaders();
        int status = response.getStatusCodeValue();
        List<String> authorizations = headersResponse.get("Authorization");
        RestClient restClient = new SimpleRestClient(null, false);
        if (status == 200 && !authorizations.isEmpty()) {
            List<ClientHttpRequestInterceptor> interceptors
                    = restTemplate.getInterceptors();
            if (CollectionUtils.isEmpty(interceptors)) {
                interceptors = new ArrayList<>();
            }
            interceptors.add(new RestTemplateHeaderModifierInterceptor(authorizations.get(0)));
            restTemplate.setInterceptors(interceptors);
            restClient = new SimpleRestClient(restTemplate, true);
        }
        return restClient;
    }
}
