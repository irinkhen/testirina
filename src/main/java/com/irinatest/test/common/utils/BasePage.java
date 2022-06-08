package com.irinatest.test.common.utils;

import com.codeborne.selenide.SelenideElement;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import java.util.Random;

import static com.codeborne.selenide.Condition.empty;
import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.open;
import static java.lang.Thread.sleep;
import static org.apache.commons.lang3.RandomStringUtils.randomAlphabetic;
import static org.openqa.selenium.By.xpath;
import static org.openqa.selenium.By.id;
import static org.openqa.selenium.Keys.BACK_SPACE;

public class BasePage {

    public void navigate() {
        open("https://regoffice.senla.eu/", "", "user", "senlatest");
    }

    public By getByText(String name) {
        return xpath(new StringBuilder().append("//*[contains(text(), '").append(name).append("')]").toString());
    }

    public By getById(String id) {
        return id(id);
    }

    public SelenideElement clearNumericContent(SelenideElement element) {
        element.shouldBe(visible).shouldBe(enabled).click();
        for (int i = 0; element.getValue().length() > 0; i++) {
            element.sendKeys(Keys.BACK_SPACE);
            element.sendKeys(Keys.DELETE);
            if (element.getValue() == "") {
                break;
            }
        }
        element.shouldBe(empty);
        return this.clearNumericContent(element);
    }
}
