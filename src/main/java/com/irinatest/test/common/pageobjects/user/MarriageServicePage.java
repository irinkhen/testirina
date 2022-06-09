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

public class MarriageServicePage extends MainPageObject {

    private final By dateOfRegistrationField = getById("TextInputField-12");
    private final By newLastNameField = getById("TextInputField-13");
    private final By partnerLastName = getById("TextInputField-14");
    private final By partnerName = getById("TextInputField-15");
    private final By partnerSurname = getById("TextInputField-16");
    private final By partnerDateOfBirthField = getById("TextInputField-17");
    private final By partnerPassport = getById("TextInputField-18");

    private final By headOfPage = getByText("Данные услуги");

    @Step("Scroll page to the top")
    public MarriageServicePage scrollToTop() {
        element(headOfPage).scrollIntoView(true);
        return this;
    }

    @Step("Fill date of registration")
    public MarriageServicePage fillDateOfRegistration(LocalDate date) {
        DateTimeFormatter format = ofPattern("ddMMyyyy");
        element(dateOfRegistrationField).scrollIntoView(true)
                .shouldBe(visible).sendKeys(date.format(format));

        return this;
    }

    @Step("Fill user new lastname")
    public MarriageServicePage fillNewLastname(String lastname) {
        element(newLastNameField).shouldBe(visible).sendKeys(lastname);

        return this;
    }

    @Step("Fill partner lastname")
    public MarriageServicePage fillPartnerLastName(String lastname) {
        element(partnerLastName).shouldBe(visible).sendKeys(lastname);

        return this;
    }

    @Step("Fill partner name")
    public MarriageServicePage fillPartnerName(String name) {
        element(partnerName).shouldBe(visible).sendKeys(name);

        return this;
    }

    @Step("Fill partner surname")
    public MarriageServicePage fillPartnerSurname(String surname) {
        element(partnerSurname).shouldBe(visible).sendKeys(surname);

        return this;
    }

    @Step("Fill partner date of birth")
    public MarriageServicePage fillPartnerDateOfBirth(LocalDate date) {
        DateTimeFormatter format = ofPattern("ddMMyyyy");
        element(partnerDateOfBirthField).shouldBe(visible).sendKeys(date.format(format));

        return this;
    }

    @Step("Fill partner number of passport")
    public MarriageServicePage fillPartnerPassport(String passport) {
        element(partnerPassport).shouldBe(visible).sendKeys(passport);

        return this;
    }

    @Step("Fill all fields")
    public MarriageServicePage fillAllFields() {
        fillDateOfRegistration(LocalDate.now().plusDays(10));
        fillNewLastname(randomAlphabetic(10));
        fillPartnerLastName(randomAlphabetic(10));
        fillPartnerName(randomAlphabetic(10));
        fillPartnerSurname(randomAlphabetic(10));
        fillPartnerDateOfBirth(LocalDate.now().minusYears(20));
        fillPartnerPassport(randomNumeric(8));

        return this;
    }
}
