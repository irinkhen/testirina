package com.irinatest.test.common.models;

public enum RequestType {
    DEATH("death"),
    BIRTH("birth"),
    MARRIAGE("wedding");

    private final String type;

    RequestType(String service) {
        this.type = service;
    }

    public String getType() {
        return type;
    }
}
