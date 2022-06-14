package com.irinatest.test.common.models;

public enum Endpoints {
    CREATE_USER("/sendUserRequest"),
    APPLICATION_STATUS("/getApplStatus/"),
    APPLICATION("/getApplications"),
    CREATE_ADMIN("/sendAdminRequest"),
    REQUEST_PROCESS("/requestProcess");

    private final String url;

    Endpoints(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }

    public static String buildUrl(Endpoints route) {
        return new StringBuilder().append("https://regoffice.senla.eu").append(route.getUrl()).toString();
    }
}
