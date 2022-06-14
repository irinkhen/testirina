package com.irinatest.test.common.models.requests;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class CreateUserRequest {
    String mode;
    String personalLastName;
    String personalMiddleName;
    String personalFirstName;
    String personalPhoneNumber;
    String personalNumberOfPassport;
    String citizenLastName;
    String citizenFirstName;
    String citizenMiddleName;
    String citizenBirthDate;
    String citizenNumberOfPassport;
    String citizenGender;
    String dateOfMarriage;
    String newLastName;
    String anotherPersonLastName;
    String anotherPersonFirstName;
    String anotherPersonMiddleName;
    @JsonProperty("birth_of_anotoherPerson")
    String birthOfAnotoherPerson;
    String anotherPersonPassport;
    @JsonProperty("birth_place")
    String birthPlace;
    @JsonProperty("birth_mother")
    String birthMother;
    @JsonProperty("birth_father")
    String birthFather;
    @JsonProperty("death_dateOfDeath")
    String deathDateOfDeath;
    @JsonProperty("death_placeOfDeath")
    String deathPlaceOfDeath;
}
