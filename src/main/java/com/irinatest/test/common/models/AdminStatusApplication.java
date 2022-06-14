package com.irinatest.test.common.models;

public enum AdminStatusApplication {
    ACCEPT("Одобрена"),
    PROGRESS("На рассмотрении"),
    REJECT("Отклонена");

    private final String status;

    AdminStatusApplication(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }
}
