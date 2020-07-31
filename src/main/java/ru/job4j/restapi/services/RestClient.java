package ru.job4j.restapi.services;

import java.util.Map;

public interface RestClient {
    Map<String, Object> getStatistic();
    boolean isAuthorization();
}
