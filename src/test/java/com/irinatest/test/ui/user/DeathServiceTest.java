package com.irinatest.test.ui.user;

import com.irinatest.test.common.pageobjects.user.DeathServicePage;
import com.irinatest.test.common.pageobjects.user.PersonDataPage;
import com.irinatest.test.common.pageobjects.user.ServicesPage;
import com.irinatest.test.common.pageobjects.user.UserRegistrationPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class DeathServiceTest {
    private UserRegistrationPage registrationPage = new UserRegistrationPage();
    private ServicesPage servicesPage = new ServicesPage();
    private PersonDataPage personDataPage = new PersonDataPage();
    private DeathServicePage deathServicePage = new DeathServicePage();

    @BeforeMethod
    public void init() {
        registrationPage.navigate();
        registrationPage
                .loginByUser()
                .fillAllFields()
                .clickNextButton();
        servicesPage
                .selectDeath();
        personDataPage
                .fillAllFields()
                .clickNextButton();
    }

    @Test
    public void fillInfoCorrectly() {
        deathServicePage.fillAllFields();

        boolean isFinalButtonAvailable = deathServicePage.isFinalButtonAvailable();
        assertTrue(isFinalButtonAvailable);
    }
}
