package com.irinatest.test.common.pageobjects.user;

import com.irinatest.test.common.pageobjects.MainPageObject;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.element;
import static java.time.format.DateTimeFormatter.ofPattern;
import static org.apache.commons.lang3.RandomStringUtils.randomAlphabetic;
import static org.apache.commons.lang3.RandomStringUtils.randomNumeric;

public class PersonDataPage extends MainPageObject {

    /** Fields with info about subject */
    private final By lastNameField = getById("TextInputField-6");
    private final By nameField = getById("TextInputField-7");
    private final By surnameField = getById("TextInputField-8");
    private final By dateOfBirthField = getById("TextInputField-9");
    private final By passportField = getById("TextInputField-10");
    private final By genderField = getById("TextInputField-11");


    @Step("Fill lastname")
    public PersonDataPage fillLastName(String lastname) {
        element(lastNameField).shouldBe(visible).sendKeys(lastname);

        return this;
    }

    @Step("Fill name")
    public PersonDataPage fillName(String name) {
        element(nameField).shouldBe(visible).sendKeys(name);

        return this;
    }

    @Step("Fill surname")
    public PersonDataPage fillSurname(String surname) {
        element(surnameField).shouldBe(visible).sendKeys(surname);

        return this;
    }

    @Step("Fill date of birth")
    public PersonDataPage fillDateOfBirth(LocalDate date) {
        DateTimeFormatter format = ofPattern("ddMMyyyy");
        element(dateOfBirthField).shouldBe(visible).sendKeys(date.format(format));

        return this;
    }

    @Step("Fill number of passport")
    public PersonDataPage fillPassport(String passport) {
        element(passportField).shouldBe(visible).sendKeys(passport);

        return this;
    }

    @Step("Fill user gender")
    public PersonDataPage fillGender(String gender) {
        element(genderField).shouldBe(visible).sendKeys(gender);

        return this;
    }

    @Step("Fill all fields")
    public PersonDataPage fillAllFields() {
        fillLastName(randomAlphabetic(10));
        fillName(randomAlphabetic(10));
        fillSurname(randomAlphabetic(10));
        fillDateOfBirth(LocalDate.now().minusYears(20));
        fillPassport(randomNumeric(8));
        fillGender("Ж");

        return this;
    }

    @Step("Click button for the open details of service")
    public void clickNextButton() {
        element(nextButton).shouldBe(visible).click();
    }
}
