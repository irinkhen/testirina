package com.irinatest.test.common.pageobjects;

import com.irinatest.test.common.pageobjects.user.StatusPage;
import com.irinatest.test.common.pageobjects.user.UserRegistrationPage;
import com.irinatest.test.common.utils.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.element;

public class MainPageObject extends BasePage {

    /** Navigation buttons */
    public final By nextButton = getByText("Далее");
    private final By closeButton = getByText("Закрыть");
    private final By userLoginButton = getByText("Войти как пользователь");
    private final By adminLoginButton = getByText("Войти как администратор");

    /** Final button */
    private final By finalButton = getByText("Завершить");

    @Step("Open interface for user")
    public UserRegistrationPage loginByUser() {
        element(userLoginButton).shouldBe(visible).click();
        return new UserRegistrationPage();
    }

    @Step("Open interface for admin")
    public void loginByAdmin() {
        element(adminLoginButton).shouldBe(visible).click();
        //return new FirstUserRegistrationPage();
    }

    @Step("Check availability for the next button")
    public boolean isNextButtonAvailable() {
        return element(nextButton).shouldBe(visible).is(enabled);
    }

    @Step("Close request window")
    public MainPageObject clickCloseButton() {
        element(closeButton).shouldBe(visible).click();

        return new MainPageObject();
    }

    @Step("Finalize request")
    public StatusPage clickFinalButton() {
        element(finalButton).shouldBe(visible).click();
        return new StatusPage();
    }

    @Step("Check availability for the final button")
    public boolean isFinalButtonAvailable() {
        return element(finalButton).shouldBe(visible).is(enabled);
    }
}
