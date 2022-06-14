package com.irinatest.test.common.models;

public enum ApplicationStatusFromBD {
    CONSIDERATION("under consideration"),
    APPROVED("approved"),
    DECLINE("rejected");

    private final String status;

    ApplicationStatusFromBD(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }
}
