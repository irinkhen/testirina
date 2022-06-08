package com.irinatest.test.common.pageobjects;

import com.irinatest.test.common.pageobjects.user.StatusPage;
import com.irinatest.test.common.pageobjects.user.UserRegistrationPage;
import com.irinatest.test.common.utils.BasePage;
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

    public UserRegistrationPage loginByUser() {
        element(userLoginButton).shouldBe(visible).click();
        return new UserRegistrationPage();
    }

    public void loginByAdmin() {
        element(adminLoginButton).shouldBe(visible).click();
        //return new FirstUserRegistrationPage();
    }

    public boolean isNextButtonAvailable() {
        return element(nextButton).shouldBe(visible).is(enabled);
    }

    public MainPageObject clickCloseButton() {
        element(closeButton).shouldBe(visible).click();

        return new MainPageObject();
    }

    public StatusPage clickFinalButton() {
        element(finalButton).shouldBe(visible).click();
        return new StatusPage();
    }

    public boolean isFinalButtonAvailable() {
        return element(finalButton).shouldBe(visible).is(enabled);
    }
}
