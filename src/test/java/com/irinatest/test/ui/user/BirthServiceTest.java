package com.irinatest.test.ui.user;

import com.irinatest.test.common.pageobjects.user.BirthServicePage;
import com.irinatest.test.common.pageobjects.user.PersonDataPage;
import com.irinatest.test.common.pageobjects.user.ServicesPage;
import com.irinatest.test.common.pageobjects.user.UserRegistrationPage;
import com.irinatest.test.suites.UISuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class BirthServiceTest extends UISuite {
    private UserRegistrationPage registrationPage = new UserRegistrationPage();
    private ServicesPage servicesPage = new ServicesPage();
    private PersonDataPage personDataPage = new PersonDataPage();
    private BirthServicePage birthServicePage = new BirthServicePage();

    @BeforeMethod
    public void init() {
        registrationPage.navigate();
        registrationPage
                .loginByUser()
                .fillAllFields()
                .clickNextButton();
        servicesPage
                .selectBorn();
        personDataPage
                .fillAllFields()
                .clickNextButton();
    }

    @Test
    public void fillInfoCorrectly() {
        birthServicePage
                .validate()
                .fillAllFields();

        boolean isFinalButtonAvailable = birthServicePage.isFinalButtonAvailable();
        assertTrue(isFinalButtonAvailable);
    }

}
