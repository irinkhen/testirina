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
        System.out.println(buildUrl(CREATE_USER));
        return given()
                .auth().preemptive().basic("user", "senlatest")
//                .header("content-type", "application/json;charset=UTF-8")
//                .header("accept", "application/json, text/plain, */*")
                //.header("content-length","668")
                .body(requestBody)
                .post(buildUrl(CREATE_USER))
                .then();
    }

    @Step("Create user for the marriage")
    public ValidatableResponse createUserForTheMarriage(LocalDate date, String passport) {
        DateTimeFormatter format = ofPattern("yyyy-MM-dd");

        CreateUserRequest body = CreateUserRequest.builder()
                .mode("marriage")
                .personalFirstName(randomAlphabetic(10))
                .personalLastName(randomAlphabetic(10))
                .personalMiddleName(randomAlphabetic(10))
                .personalNumberOfPassport(passport)
                .personalPhoneNumber(randomNumeric(10))
                .citizenFirstName(randomAlphabetic(10))
                .citizenLastName(randomAlphabetic(10))
                .citizenMiddleName(randomAlphabetic(10))
                .citizenBirthDate(date.format(format))
                .citizenGender("F")
                .dateOfMarriage(date.format(format))
                .citizenNumberOfPassport(randomNumeric(8))
                .anotherPersonFirstName(randomAlphabetic(10))
                .anotherPersonLastName(randomAlphabetic(10))
                .anotherPersonMiddleName(randomAlphabetic(10))
                .birth_of_anotoherPerson(date.format(format))
                .newLastName(randomAlphabetic(10))
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
                .birth_mother(randomAlphabetic(10))
                .birth_father(randomAlphabetic(10))
                .birth_place(randomAlphabetic(10))
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
                .death_dateOfDeath(date.format(format))
                .death_placeOfDeath(randomAlphabetic(10))
                .build();

        return createUser(body);
    }
}
