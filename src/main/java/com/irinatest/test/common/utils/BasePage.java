package com.irinatest.test.common.utils;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.By.id;
import static org.openqa.selenium.By.xpath;

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
}
