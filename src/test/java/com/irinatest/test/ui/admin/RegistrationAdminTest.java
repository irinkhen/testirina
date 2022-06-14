package com.irinatest.test.ui.admin;

import com.irinatest.test.common.pageobjects.admin.AdminRegistrationPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class RegistrationAdminTest {
    private AdminRegistrationPage registrationPage = new AdminRegistrationPage();

    @BeforeMethod
    public void init() {
        registrationPage.navigate();
        registrationPage.loginByAdmin();
    }

    @Test
    public void fillInfoCorrectly() {
        registrationPage
                .validate()
                .fillAllFields();

        boolean isNextButtonAvailable = registrationPage.isNextButtonAvailable();
        assertTrue(isNextButtonAvailable);
    }
}
