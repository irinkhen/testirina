package com.irinatest.test.common.requests;

import com.irinatest.test.common.models.ApplicationStatusFromBD;
import com.irinatest.test.common.models.requests.ApplicationProcessRequest;
import com.irinatest.test.common.models.requests.CreateAdminRequest;
import io.qameta.allure.Step;
import io.restassured.response.ValidatableResponse;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static com.irinatest.test.common.models.Endpoints.CREATE_ADMIN;
import static com.irinatest.test.common.models.Endpoints.REQUEST_PROCESS;
import static com.irinatest.test.common.models.Endpoints.buildUrl;
import static io.restassured.RestAssured.given;
import static java.time.format.DateTimeFormatter.ofPattern;
import static org.apache.commons.lang3.RandomStringUtils.randomAlphabetic;
import static org.apache.commons.lang3.RandomStringUtils.randomNumeric;

public class AdminRequests {

    @Step("Create admin request")
    public ValidatableResponse createAdminRequest(CreateAdminRequest requestBody) {
        return given()
                .auth().preemptive().basic("user", "senlatest")
                .header("Content-type", "application/json")
                .header("Accept", "*/*")
                .header("Host","regoffice.senla.eu")
                .body(requestBody)
                .post(buildUrl(CREATE_ADMIN))
                .then();
    }

    @Step("Applications processing")
    public ValidatableResponse requestProcessing(ApplicationProcessRequest requestBody) {
        return given()
                .auth().preemptive().basic("user", "senlatest")
                .header("Content-type", "application/json")
                .header("Accept", "*/*")
                .header("Host","regoffice.senla.eu")
                .body(requestBody)
                .post(buildUrl(REQUEST_PROCESS))
                .then();
    }
    @Step("Create new admin")
    public ValidatableResponse createNewAdmin(LocalDate date, String passport) {
        DateTimeFormatter format = ofPattern("yyyy-MM-dd");

        CreateAdminRequest body = CreateAdminRequest.builder()
                .personalFirstName(randomAlphabetic(10))
                .personalLastName(randomAlphabetic(10))
                .personalMiddleName(randomAlphabetic(10))
                .dateofbirth(date.format(format))
                .personalPhoneNumber(randomNumeric(10))
                .personalNumberOfPassport(passport)
                .build();

        return createAdminRequest(body);
    }

    public ValidatableResponse makeDecideForApplication(
            ApplicationStatusFromBD decide,
            Integer applicationId,
            Integer adminId
    ) {
        ApplicationProcessRequest requestBody = ApplicationProcessRequest.builder()
                .action(decide.getStatus())
                .applId(applicationId)
                .staffid(adminId)
                .build();

        return requestProcessing(requestBody);
    }
}
