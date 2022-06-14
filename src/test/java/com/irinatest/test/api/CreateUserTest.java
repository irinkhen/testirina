package com.irinatest.test.api;

import com.irinatest.test.common.models.response.CreateUserResponse;
import com.irinatest.test.common.requests.UserRequests;
import org.testng.annotations.Test;

import java.time.LocalDate;

import static org.apache.commons.lang3.RandomStringUtils.randomNumeric;

public class CreateUserTest {

    private UserRequests userRequests = new UserRequests();

    @Test
    public void createUserTestForTheBirth() {
        userRequests.createUserForTheBirth(LocalDate.now().minusYears(10))
                .statusCode(200)
                .extract().body()
                .as(CreateUserResponse.class);
    }

    @Test
    public void createUserTestForTheMarriage() {
        String passport = randomNumeric(8);

        userRequests.createUserForTheMarriage(LocalDate.now().minusYears(1), passport)
                .statusCode(200)
                .extract().body()
                .as(CreateUserResponse.class);
    }

    @Test
    public void createUserTestForTheDeath() {
        userRequests.createUserForTheDeath(LocalDate.now().minusYears(1))
                .statusCode(200)
                .extract().body()
                .as(CreateUserResponse.class);
    }
}
