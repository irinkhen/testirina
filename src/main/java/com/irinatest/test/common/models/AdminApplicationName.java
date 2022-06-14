package com.irinatest.test.common.models;

public enum AdminApplicationName {
    DEATH("Получение свидетельства о смерти"),
    BIRTH("Получение свидетельства о рождении"),
    MARRIAGE("Получение свидетельства о браке");

    private final String service;

    AdminApplicationName(String service) {
        this.service = service;
    }

    public String getService() {
        return service;
    }
}
