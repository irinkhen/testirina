package com.irinatest.test.common.requests;

import com.irinatest.test.common.models.response.ApplicationProcessResponse;
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
                .pathParam("{applicationId}", applicationId)
                .get(buildUrl(APPLICATION_STATUS))
                .then();
    }

    @Step("Get all applications list")
    public ApplicationProcessResponse[] getAllApplications() {
        return given()
                .auth().preemptive().basic("user", "senlatest")
                .get(buildUrl(APPLICATION))
                .then()
                .statusCode(200)
                .extract().body()
                .as(ApplicationProcessResponse[].class);
    }
}
