package com.irinatest.test.common.pageobjects.user;

import com.irinatest.test.common.pageobjects.MainPageObject;
import org.openqa.selenium.By;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.element;
import static java.time.format.DateTimeFormatter.ofPattern;
import static org.apache.commons.lang3.RandomStringUtils.randomAlphabetic;

public class DeathServicePage extends MainPageObject {
    private final By dateOfDeathField = getById("TextInputField-12");
    private final By placeOfDeathField = getById("TextInputField-13");

    public DeathServicePage fillDateOfDeath(LocalDate date) {
        DateTimeFormatter format = ofPattern("ddMMyyyy");
        element(dateOfDeathField).scrollIntoView(true)
                .shouldBe(visible).sendKeys(date.format(format));

        return this;
    }

    public DeathServicePage fillPlaceOfDeath(String place) {
        element(placeOfDeathField).shouldBe(visible).sendKeys(place);

        return this;
    }

    public DeathServicePage fillAllFields() {
        fillDateOfDeath(LocalDate.now().minusDays(3));
        fillPlaceOfDeath(randomAlphabetic(10));

        return this;
    }


}
