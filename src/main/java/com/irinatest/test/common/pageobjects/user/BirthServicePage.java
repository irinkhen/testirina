package com.irinatest.test.common.pageobjects.user;

import com.irinatest.test.common.pageobjects.MainPageObject;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.element;
import static org.apache.commons.lang3.RandomStringUtils.randomAlphabetic;

public class BirthServicePage extends MainPageObject {

    /** Info about birth details */
    private final By placeOfBirthField = getById("TextInputField-12");
    private final By motherField = getById("TextInputField-13");
    private final By fatherField = getById("TextInputField-14");

    @Step("Validate elements of page")
    public BirthServicePage validate() {
        element(placeOfBirthField).shouldBe(visible, enabled);
        element(motherField).shouldBe(visible, enabled);
        element(fatherField).shouldBe(visible, enabled);

        return this;
    }

    @Step("Fill place of birth")
    public BirthServicePage fillPlaceOfBirthField(String place) {
        element(placeOfBirthField).shouldBe(visible).sendKeys(place);

        return this;
    }

    @Step("Fill mother name")
    public BirthServicePage fillMotherField(String motherName) {
        element(motherField).shouldBe(visible).sendKeys(motherName);

        return this;
    }

    @Step("Fill father name")
    public BirthServicePage fillFatherField(String fatherName) {
        element(fatherField).shouldBe(visible).sendKeys(fatherName);

        return this;
    }

    @Step("Fill all fields")
    public BirthServicePage fillAllFields() {
        fillPlaceOfBirthField(randomAlphabetic(10));
        fillMotherField(randomAlphabetic(10));
        fillFatherField(randomAlphabetic(10));

        return this;
    }
}
