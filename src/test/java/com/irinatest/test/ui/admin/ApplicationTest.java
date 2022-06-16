package com.irinatest.test.ui.admin;

import com.irinatest.test.common.pageobjects.admin.AdminRegistrationPage;
import com.irinatest.test.common.pageobjects.admin.ApplicationsPage;
import com.irinatest.test.suites.UISuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ApplicationTest extends UISuite {
    private AdminRegistrationPage registrationPage = new AdminRegistrationPage();
    private ApplicationsPage applicationsPage = new ApplicationsPage();

    @BeforeMethod
    public void init() {
        registrationPage
                .navigate();
        registrationPage
                .loginByAdmin()
                .validate()
                .fillAllFields()
                .clickNextButton();
    }

    @Test
    public void fillInfoCorrectly() {
        applicationsPage.validate();
    }
}
