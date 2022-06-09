package com.irinatest.test.common.pageobjects.user;

import com.irinatest.test.common.pageobjects.MainPageObject;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.element;

public class StatusPage extends MainPageObject {

    private final By serviceInfo = getByText("Вы выбрали услугу");
    private final By thankYouText = getByText("Спасибо за обращение!");
    private final By requestText = getByText("Ваша заявка отправлена на рассмотрение");
    private final By dateOfRequestText = getByText("Дата регистрации заявки");
    private final By statusOfRequest = getByText("Статус заявки: ");
    private final By reloadStatusButton = getByText("Обновить");
    private final By createNewRequestButton = getByText("Создать новую заявку");

    @Step("Validate elements of page")
    public StatusPage validate() {
        element(serviceInfo).shouldBe(visible);
        element(thankYouText).shouldBe(visible);
        element(requestText).shouldBe(visible);
        element(dateOfRequestText).shouldBe(visible);
        element(statusOfRequest).shouldBe(visible);
        element(reloadStatusButton).shouldBe(visible, enabled);
        element(createNewRequestButton).shouldBe(visible, enabled);

        return this;
    }

    @Step("Get selected request type")
    public String getServiceInfo() {
        String textOfService = element(serviceInfo).shouldBe(visible).getText();
        return textOfService.substring(19);
    }

    @Step("Get current status of request")
    public String getStatusInfo() {
        String textOfService = element(statusOfRequest).shouldBe(visible).getText();

        return textOfService.substring(15);
    }

    @Step("Get date of request creating")
    public String getDateOfRequestInfo() {
        String textOfService = element(dateOfRequestText).shouldBe(visible).getText();
        return textOfService.substring(25);
    }
}
