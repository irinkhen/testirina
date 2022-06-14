package com.irinatest.test.api;

import com.irinatest.test.common.models.response.CreateUserResponse;
import com.irinatest.test.common.requests.UserRequests;
import org.testng.annotations.Test;

import java.time.LocalDate;

public class UserRequestsTests {

    private UserRequests userRequests = new UserRequests();

    @Test
    public void createUserTest() {
        userRequests.createUserForTheBirth(LocalDate.now()
                .minusYears(10))
                .statusCode(200)
                .extract().body().as(CreateUserResponse.class);
    }
}

/*{"mode":"birth","personalLastName":"mmm,m,,m","personalFirstName":"fwrfre","personalMiddleName":"kkkllk",
"personalPhoneNumber":"098765432","personalNumberOfPassport":"234567890",
"citizenLastName":"hjvc","citizenFirstName":"nmbv",
"citizenMiddleName":"vbnm","citizenBirthDate":"0456-03-12","citizenNumberOfPassport":"098765432",
"citizenGender":"m","dateOfMarriage":null,"newLastName":null,"anotherPersonLastName":null,"anotherPersonFirstName":null,
"anotherPersonMiddleName":null,"birth_of_anotoherPerson":null,"anotherPersonPassport":null,"birth_place":"kljhgfd",
"birth_mother":"ыпаыап","birth_father":"dscdcsdc","death_dateOfDeath":null,"death_placeOfDeath":null}*/