package com.irinatest.test.common.pageobjects.admin;

import com.irinatest.test.common.pageobjects.MainPageObject;
import io.qameta.allure.Step;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.element;
import static java.time.format.DateTimeFormatter.ofPattern;
import static org.apache.commons.lang3.RandomStringUtils.randomAlphabetic;
import static org.apache.commons.lang3.RandomStringUtils.randomNumeric;

public class AdminRegistrationPage extends MainPageObject {

    @Step("Click next button")
    public ApplicationsPage clickNextButton() {
        element(nextButton).shouldBe(visible).click();

        return new ApplicationsPage();
    }

    public AdminRegistrationPage validate() {
        element(lastNameField).shouldBe(visible, enabled);
        element(nameField).shouldBe(visible, enabled);
        element(surNameField).shouldBe(visible, enabled);
        element(phoneField).shouldBe(visible, enabled);
        element(passportField).shouldBe(visible, enabled);
        element(dateOfBirthField).shouldBe(visible, enabled);

        return this;
    }

    @Step("Fill last name")
    public AdminRegistrationPage fillLastName(String lastname) {
        element(lastNameField).shouldBe(visible).sendKeys(lastname);

        return this;
    }

    @Step("Fill name")
    public AdminRegistrationPage fillName(String name) {
        element(nameField).shouldBe(visible).sendKeys(name);

        return this;
    }

    @Step("Fill surname")
    public AdminRegistrationPage fillSurname(String surname) {
        element(surNameField).shouldBe(visible).sendKeys(surname);

        return this;
    }

    @Step("Fill phone number")
    public AdminRegistrationPage fillPhone(String phone) {
        element(phoneField).shouldBe(visible).sendKeys(phone);

        return this;
    }

    @Step("Fill number of passport")
    public AdminRegistrationPage fillPassport(String passport) {
        element(passportField).shouldBe(visible).sendKeys(passport);

        return this;
    }

    @Step("Fill date of birth")
    public AdminRegistrationPage fillDateOfBirth(LocalDate date) {
        DateTimeFormatter format = ofPattern("ddMMyyyy");
        element(dateOfBirthField).scrollIntoView(false).shouldBe(visible).sendKeys(date.format(format));

        return this;
    }

    @Step("Fill all fields")
    public AdminRegistrationPage fillAllFields() {
        fillLastName(randomAlphabetic(10));
        fillName(randomAlphabetic(10));
        fillSurname(randomAlphabetic(10));
        fillPhone(randomNumeric(10));
        fillPassport(randomNumeric(8));
        fillDateOfBirth(LocalDate.now().minusYears(20));

        return this;
    }
}
