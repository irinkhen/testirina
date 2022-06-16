package com.irinatest.test.ui.user;
import com.irinatest.test.common.pageobjects.user.UserRegistrationPage;
import com.irinatest.test.suites.UISuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.apache.commons.lang3.RandomStringUtils.randomAlphabetic;
import static org.apache.commons.lang3.RandomStringUtils.randomNumeric;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class RegistrationPageTest extends UISuite {
    private final UserRegistrationPage registrationPage = new UserRegistrationPage();

    @BeforeMethod
    public void init() {
        registrationPage.navigate();
        registrationPage.loginByUser();
    }

    @Test
    public void fillInfoCorrectly() {
        registrationPage.validate();
        registrationPage.fillAllFields();

        boolean isNextButtonAvailable = registrationPage.isNextButtonAvailable();
        assertTrue(isNextButtonAvailable);
    }

    @Test
    public void emptyPassportFieldsValidate() {
        registrationPage.fillLastName(randomAlphabetic(10));
        registrationPage.fillName(randomAlphabetic(10));
        registrationPage.fillSurname(randomAlphabetic(10));
        registrationPage.fillPhone(randomNumeric(10));

        boolean isNextButtonAvailable = registrationPage.isNextButtonAvailable();
        assertFalse(isNextButtonAvailable);
    }

}
