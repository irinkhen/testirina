package com.irinatest.test.common.models.requests;

import io.qameta.allure.internal.shadowed.jackson.annotation.JsonProperty;
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
    String birth_of_anotoherPerson;
    String anotherPersonPassport;
    @JsonProperty("birth_place")
    String birth_place;
    @JsonProperty("birth_mother")
    String birth_mother;
    @JsonProperty("birth_father")
    String birth_father;
    @JsonProperty("death_dateOfDeath")
    String death_dateOfDeath;
    @JsonProperty("death_placeOfDeath")
    String death_placeOfDeath;
}
/*{
    "mode": "birth",
    "personalLastName": "mmm,m,,m",
    "personalFirstName": "fwrfre",
    "personalMiddleName": "kkkllk",
    "personalPhoneNumber": "098765432",
    "personalNumberOfPassport": "234567890",
    "citizenLastName": "hjvc",
    "citizenFirstName": "nmbv",
    "citizenMiddleName": "vbnm",
    "citizenBirthDate": "0456-03-12",
    "citizenNumberOfPassport": "098765432",
    "citizenGender": "m",
    "dateOfMarriage": null,
    "newLastName": null,
    "anotherPersonLastName": null,
    "anotherPersonFirstName": null,
    "anotherPersonMiddleName": null,
    "birth_of_anotoherPerson": null,
    "anotherPersonPassport": null,
    "birth_place": "kljhgfd",
    "birth_mother": "ыпаыап",
    "birth_father": "dscdcsdc",
    "death_dateOfDeath": null,
    "death_placeOfDeath": null
}*/