package com.irinatest.test.common.pageobjects.user;

import com.irinatest.test.common.pageobjects.MainPageObject;
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

    public String getServiceInfo() {
        String textOfService = element(serviceInfo).shouldBe(visible).getText();
        return textOfService.substring(19);
    }

    public String getStatusInfo() {
        String textOfService = element(statusOfRequest).shouldBe(visible).getText();
        System.out.println(textOfService);
        return textOfService.substring(15);
    }

    public String getDateOfRequestInfo() {
        String textOfService = element(dateOfRequestText).shouldBe(visible).getText();
        return textOfService.substring(25);
    }
}
