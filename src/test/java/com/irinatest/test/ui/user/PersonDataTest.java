package com.irinatest.test.ui.user;

import com.irinatest.test.common.pageobjects.user.PersonDataPage;
import com.irinatest.test.common.pageobjects.user.ServicesPage;
import com.irinatest.test.common.pageobjects.user.UserRegistrationPage;
import com.irinatest.test.suites.UISuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class PersonDataTest extends UISuite {
    private UserRegistrationPage registrationPage = new UserRegistrationPage();
    private ServicesPage servicesPage = new ServicesPage();
    private PersonDataPage personDataPage = new PersonDataPage();

    @BeforeMethod
    public void init() {
        registrationPage.navigate();
        registrationPage
                .loginByUser()
                .fillAllFields()
                .clickNextButton();
    }

    @Test
    public void fillInfoCorrectly() {
        servicesPage
                .validate()
                .selectBorn();
        personDataPage
                .fillAllFields();

        boolean isNextButtonAvailable = personDataPage.isNextButtonAvailable();
        assertTrue(isNextButtonAvailable);
    }
}
