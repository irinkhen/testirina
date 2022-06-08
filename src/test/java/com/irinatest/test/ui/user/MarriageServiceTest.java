package com.irinatest.test.ui.user;

import com.irinatest.test.common.pageobjects.user.MarriageServicePage;
import com.irinatest.test.common.pageobjects.user.PersonDataPage;
import com.irinatest.test.common.pageobjects.user.ServicesPage;
import com.irinatest.test.common.pageobjects.user.UserRegistrationPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class MarriageServiceTest {
    private UserRegistrationPage registrationPage = new UserRegistrationPage();
    private ServicesPage servicesPage = new ServicesPage();
    private PersonDataPage personDataPage = new PersonDataPage();
    private MarriageServicePage marriageServiceTest = new MarriageServicePage();

    @BeforeMethod
    public void init() {
        registrationPage.navigate();
        registrationPage
                .loginByUser()
                .fillAllFields()
                .clickNextButton();
        servicesPage
                .selectMarried();
        personDataPage
                .fillAllFields()
                .clickNextButton();
    }

    @Test
    public void fillInfoCorrectly() {
        marriageServiceTest
                .scrollToTop()
                .fillAllFields();

        boolean isFinalButtonAvailable = marriageServiceTest.isFinalButtonAvailable();
        assertTrue(isFinalButtonAvailable);
    }
}
