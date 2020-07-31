package ru.job4j.restapi.services.impl;

import org.springframework.web.client.RestTemplate;
import ru.job4j.restapi.exceptions.UnauthorizedException;
import ru.job4j.restapi.services.RestClient;

import java.util.Map;

public class SimpleRestClient implements RestClient {

    private final RestTemplate rest;
    private final boolean isAuthorization;

    public SimpleRestClient(RestTemplate rest, boolean isAuthorization) {
        this.rest = rest;
        this.isAuthorization = isAuthorization;
    }

    @Override
    public Map<String, Object> getStatistic() {
        if (!isAuthorization) {
            throw new UnauthorizedException("Пользователь не авторизован!");
        }
        return rest.getForObject("http://localhost:8081/statistic", Map.class);
    }

    public boolean isAuthorization() {
        return isAuthorization;
    }
}
