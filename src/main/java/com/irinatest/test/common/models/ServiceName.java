package com.irinatest.test.common.models;


public enum ServiceName {
    DEATH("Регистрация смерти"),
    BIRTH("Регистрация рождения"),
    MARRIAGE("Регистрация брака");

    private final String service;

    ServiceName(String service) {
        this.service = service;
    }

    public String getService() {
        return service;
    }
}
