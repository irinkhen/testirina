package com.irinatest.test.common.models;

public enum RequestStatus {
    IN_PROGRESS("На рассмотрении."),
    ACCEPTED("Подтверждена."),
    REJECTED("Отклонена.");

    private final String status;

    RequestStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }
}
