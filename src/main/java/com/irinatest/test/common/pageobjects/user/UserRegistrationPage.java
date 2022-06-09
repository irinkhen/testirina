package com.irinatest.test.common.pageobjects.user;

import com.irinatest.test.common.pageobjects.MainPageObject;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.element;
import static org.apache.commons.lang3.RandomStringUtils.randomAlphabetic;
import static org.apache.commons.lang3.RandomStringUtils.randomNumeric;

public class UserRegistrationPage extends MainPageObject {

    /** Fields for user person */
    private final By lastNameField = getById("TextInputField-1");
    private final By nameField = getById("TextInputField-2");
    private final By surNameField = getById("TextInputField-3");
    private final By phoneField = getById("TextInputField-4");
    private final By passportField = getById("TextInputField-5");

    public UserRegistrationPage validate() {
        element(lastNameField).shouldBe(visible, enabled);
        element(nameField).shouldBe(visible, enabled);
        element(surNameField).shouldBe(visible, enabled);
        element(phoneField).shouldBe(visible, enabled);
        element(passportField).shouldBe(visible, enabled);

        return this;
    }

    @Step("Click next button")
    public ServicesPage clickNextButton() {
        element(nextButton).shouldBe(visible).click();

        return new ServicesPage();
    }

    @Step("Fill last name")
    public UserRegistrationPage fillLastName(String lastname) {
        element(lastNameField).shouldBe(visible).sendKeys(lastname);

        return this;
    }

    @Step("Fill name")
    public UserRegistrationPage fillName(String name) {
        element(nameField).shouldBe(visible).sendKeys(name);

        return this;
    }

    @Step("Fill surname")
    public UserRegistrationPage fillSurname(String surname) {
        element(surNameField).shouldBe(visible).sendKeys(surname);

        return this;
    }

    @Step("Fill phone number")
    public UserRegistrationPage fillPhone(String phone) {
        element(phoneField).shouldBe(visible).sendKeys(phone);

        return this;
    }

    @Step("Fill number of passport")
    public UserRegistrationPage fillPassport(String passport) {
        element(passportField).shouldBe(visible).sendKeys(passport);

        return this;
    }

    @Step("Fill all fields")
    public UserRegistrationPage fillAllFields() {
        fillLastName(randomAlphabetic(10));
        fillName(randomAlphabetic(10));
        fillSurname(randomAlphabetic(10));
        fillPhone(randomNumeric(10));
        fillPassport(randomNumeric(8));

        return this;
    }
}
