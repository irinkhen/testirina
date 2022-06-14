package com.irinatest.test.common.models;

public enum UserApplicationStatus {
    IN_PROGRESS("На рассмотрении."),
    ACCEPTED("Подтверждена."),
    REJECTED("Отклонена.");

    private final String status;

    UserApplicationStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }
}
