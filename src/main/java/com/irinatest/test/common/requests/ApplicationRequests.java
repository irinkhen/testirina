package com.irinatest.test.common.requests;

import io.qameta.allure.Step;
import io.restassured.response.ValidatableResponse;

import static com.irinatest.test.common.models.Endpoints.APPLICATION;
import static com.irinatest.test.common.models.Endpoints.APPLICATION_STATUS;
import static com.irinatest.test.common.models.Endpoints.buildUrl;
import static io.restassured.RestAssured.given;

public class ApplicationRequests {

    @Step("Get application status")
    public ValidatableResponse getApplicationStatus(String applicationId) {
        return given()
                .auth().preemptive().basic("user", "senlatest")
                .get(buildUrl(APPLICATION_STATUS) + applicationId)
                .then();
    }

    @Step("Get all applications list")
    public ValidatableResponse getAllApplications() {
        return given()
                .auth().preemptive().basic("user", "senlatest")
                .get(buildUrl(APPLICATION))
                .then();
    }
}
