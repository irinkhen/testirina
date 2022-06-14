package com.irinatest.test.common.requests;

import com.irinatest.test.common.models.requests.ApplicationProcessRequest;
import com.irinatest.test.common.models.requests.CreateAdminRequest;
import io.qameta.allure.Step;
import io.restassured.response.ValidatableResponse;

import static com.irinatest.test.common.models.Endpoints.CREATE_ADMIN;
import static com.irinatest.test.common.models.Endpoints.REQUEST_PROCESS;
import static com.irinatest.test.common.models.Endpoints.buildUrl;
import static io.restassured.RestAssured.given;

public class AdminRequests {

    @Step("Create admin request")
    public ValidatableResponse createAdmin(CreateAdminRequest requestBody) {
        return given()
                .auth().preemptive().basic("user", "senlatest")
                .body(requestBody)
                .post(buildUrl(CREATE_ADMIN))
                .then();
    }

    @Step("Applications processing")
    public ValidatableResponse requestProcessing(ApplicationProcessRequest requestBody) {
        return given()
                .auth().preemptive().basic("user", "senlatest")
                .body(requestBody)
                .post(buildUrl(REQUEST_PROCESS))
                .then();
    }
}
