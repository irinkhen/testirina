package com.irinatest.test.common.pageobjects.user;

import com.irinatest.test.common.pageobjects.MainPageObject;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.element;

public class ServicesPage extends MainPageObject {
    private final By registryBornButton = getByText("Регистрация рождения");
    private final By registryMarriedButton = getByText("Регистрация брака");
    private final By registryDeathButton = getByText("Регистрация смерти");

    @Step("Validate page elements")
    public ServicesPage validate() {
        element(registryBornButton).shouldBe(visible, enabled);
        element(registryMarriedButton).shouldBe(visible, enabled);
        element(registryDeathButton).shouldBe(visible, enabled);

        return this;
    }

    @Step("Select birth registration service")
    public PersonDataPage selectBorn() {
        element(registryBornButton).shouldBe(visible).click();

        return new PersonDataPage();
    }

    @Step("Select marriage registration service")
    public PersonDataPage selectMarried() {
        element(registryMarriedButton).shouldBe(visible).click();

        return new PersonDataPage();
    }

    @Step("Select death registration service")
    public PersonDataPage selectDeath() {
        element(registryDeathButton).shouldBe(visible).click();

        return new PersonDataPage();
    }
}
