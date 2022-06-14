package com.irinatest.test.common.requests;

import com.irinatest.test.common.models.requests.CreateUserRequest;
import io.qameta.allure.Step;
import io.restassured.response.ValidatableResponse;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static com.irinatest.test.common.models.Endpoints.CREATE_USER;
import static com.irinatest.test.common.models.Endpoints.buildUrl;
import static io.restassured.RestAssured.given;
import static java.time.format.DateTimeFormatter.ofPattern;
import static org.apache.commons.lang3.RandomStringUtils.randomAlphabetic;
import static org.apache.commons.lang3.RandomStringUtils.randomNumeric;


public class UserRequests {

    @Step("Create user request")
    public ValidatableResponse createUser(CreateUserRequest requestBody) {
        return given()
                .auth().preemptive().basic("user", "senlatest")
                .header("Content-type", "application/json")
                .header("Accept", "*/*")
                .header("Host","regoffice.senla.eu")
                .body(requestBody)
                .post(buildUrl(CREATE_USER))
                .then();
    }

    @Step("Create user for the marriage")
    public ValidatableResponse createUserForTheMarriage(LocalDate date, String passport) {
        DateTimeFormatter format = ofPattern("yyyy-MM-dd");

        CreateUserRequest body = CreateUserRequest.builder()
                .mode("wedding")
                .personalFirstName(randomAlphabetic(10))
                .personalLastName(randomAlphabetic(10))
                .personalMiddleName(randomAlphabetic(10))
                .personalNumberOfPassport(passport)
                .personalPhoneNumber(randomNumeric(10))
                .citizenFirstName(randomAlphabetic(10))
                .citizenLastName(randomAlphabetic(10))
                .citizenMiddleName(randomAlphabetic(10))
                .citizenNumberOfPassport(randomNumeric(8))
                .citizenBirthDate(date.format(format))
                .citizenGender("F")
                .newLastName(randomAlphabetic(10))
                .dateOfMarriage(date.format(format))
                .anotherPersonFirstName(randomAlphabetic(10))
                .anotherPersonLastName(randomAlphabetic(10))
                .anotherPersonMiddleName(randomAlphabetic(10))
                .anotherPersonPassport(randomNumeric(8))
                .birthOfAnotoherPerson(date.format(format))
                .build();

        return createUser(body);
    }

    @Step("Create user for the birth")
    public ValidatableResponse createUserForTheBirth(LocalDate date) {
        DateTimeFormatter format = ofPattern("yyyy-MM-dd");

        CreateUserRequest body = CreateUserRequest.builder()
                .mode("birth")
                .personalFirstName(randomAlphabetic(10))
                .personalLastName(randomAlphabetic(10))
                .personalMiddleName(randomAlphabetic(10))
                .personalNumberOfPassport(randomNumeric(8))
                .personalPhoneNumber(randomNumeric(10))
                .citizenFirstName(randomAlphabetic(10))
                .citizenLastName(randomAlphabetic(10))
                .citizenMiddleName(randomAlphabetic(10))
                .citizenGender("M")
                .citizenBirthDate(date.format(format))
                .citizenNumberOfPassport(randomNumeric(8))
                .birthMother(randomAlphabetic(10))
                .birthFather(randomAlphabetic(10))
                .birthPlace(randomAlphabetic(10))
                .build();

        return createUser(body);
    }

    @Step("Create user for the death")
    public ValidatableResponse createUserForTheDeath(LocalDate date) {
        DateTimeFormatter format = ofPattern("yyyy-MM-dd");

        CreateUserRequest body = CreateUserRequest.builder()
                .mode("death")
                .personalFirstName(randomAlphabetic(10))
                .personalLastName(randomAlphabetic(10))
                .personalMiddleName(randomAlphabetic(10))
                .personalNumberOfPassport(randomNumeric(8))
                .personalPhoneNumber(randomNumeric(10))
                .citizenFirstName(randomAlphabetic(10))
                .citizenLastName(randomAlphabetic(10))
                .citizenMiddleName(randomAlphabetic(10))
                .citizenGender("F")
                .citizenBirthDate(date.format(format))
                .citizenNumberOfPassport(randomNumeric(8))
                .deathDateOfDeath(date.format(format))
                .deathPlaceOfDeath(randomAlphabetic(10))
                .build();

        return createUser(body);
    }
}
