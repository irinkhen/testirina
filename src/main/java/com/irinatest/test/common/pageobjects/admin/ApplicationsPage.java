package com.irinatest.test.common.pageobjects.admin;

import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.element;
import static org.openqa.selenium.By.xpath;

public class ApplicationsPage extends AdminRegistrationPage {

    private final By reloadButton = getByText("Обновить");

    public ApplicationsPage reloadApplications() {
        element(reloadButton).shouldBe(visible, enabled).click();

        return this;
    }

    @Override
    public ApplicationsPage validate() {
        element(getByText("№")).shouldBe(visible);
        element(getByText("Заявитель")).shouldBe(visible);
        element(getByText("Тип")).shouldBe(visible);
        element(getByText("Время")).shouldBe(visible);
        element(getByText("Статус")).shouldBe(visible);
        element(getByText("Действие")).shouldBe(visible);

        element(reloadButton).shouldBe(visible, enabled);
        element(closeButton).shouldBe(visible, enabled);

        return this;
    }

    @Step("Accept application")
    public AdminRegistrationPage acceptApplication(Integer applicationId) {
        By acceptButton = xpath(new StringBuilder()
                .append("//*[contains(text(), '")
                .append(applicationId)
                .append("')]/following-sibling::td/div/button[1]")
                .toString());

        element(acceptButton).shouldBe(visible, enabled).click();

        return this;
    }

    @Step("Decline application")
    public AdminRegistrationPage declineApplication(Integer applicationId) {
        By acceptButton = xpath(new StringBuilder()
                .append("//*[contains(text(), '")
                .append(applicationId)
                .append("')]/following-sibling::td/div/button[2]")
                .toString());

        element(acceptButton).shouldBe(visible, enabled).click();

        return this;
    }

    @Step("Get application status")
    public String getApplicationStatus(Integer applicationId) {
        By status = xpath(new StringBuilder()
                .append("//*[contains(text(), '")
                .append(applicationId)
                .append("')]/following-sibling::td[4]")
                .toString());

        return element(status).scrollIntoView(false).shouldBe(visible).getText();
    }

    @Step("Get application type by application id")
    public String getApplicationType(Integer applicationId) {
        By type = xpath(new StringBuilder()
                .append("//*[contains(text(), '")
                .append(applicationId)
                .append("')]/following-sibling::td[2]")
                .toString());

        return element(type).shouldBe(visible).getText();
    }

    @Step("Get user id by application id")
    public String getUserId(Integer applicationId) {
        By user = xpath(new StringBuilder()
                .append("//*[contains(text(), '")
                .append(applicationId)
                .append("')]/following-sibling::td[1]")
                .toString());

        return element(user).shouldBe(visible).getText();
    }

    public void waitNewStatus(Integer applicationId, String status) {
        By element = xpath(new StringBuilder()
                .append("//*[contains(text(), '")
                .append(applicationId)
                .append("')]/following-sibling::td[4]")
                .toString());

        element(element).shouldHave(text(status));
    }
}
