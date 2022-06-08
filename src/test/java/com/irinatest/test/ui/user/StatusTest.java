package com.irinatest.test.ui.user;

import com.irinatest.test.common.pageobjects.user.DeathServicePage;
import com.irinatest.test.common.pageobjects.user.PersonDataPage;
import com.irinatest.test.common.pageobjects.user.ServicesPage;
import com.irinatest.test.common.pageobjects.user.StatusPage;
import com.irinatest.test.common.pageobjects.user.UserRegistrationPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

import static com.irinatest.test.common.models.RequestStatus.IN_PROGRESS;
import static com.irinatest.test.common.models.ServiceName.DEATH;
import static java.time.format.DateTimeFormatter.ofPattern;
import static java.util.Locale.US;
import static org.testng.Assert.assertEquals;

public class StatusTest {
    private UserRegistrationPage registrationPage = new UserRegistrationPage();
    private ServicesPage servicesPage = new ServicesPage();
    private PersonDataPage personDataPage = new PersonDataPage();
    private DeathServicePage deathServicePage = new DeathServicePage();

    private StatusPage statusPage = new StatusPage();

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
                .selectDeath();
        personDataPage
                .fillAllFields()
                .clickNextButton();
        deathServicePage
                .fillAllFields()
                .clickFinalButton();
        statusPage
                .validate();

        String serviceName = statusPage.getServiceInfo();
        String statusOfRequest = statusPage.getStatusInfo();
        String dateOfRequest = statusPage.getDateOfRequestInfo();

        DateTimeFormatter format = ofPattern("E MMM dd yyyy").withLocale(US);
        String currentDate = LocalDate.now().format(format);
        System.out.println(currentDate);

        assertEquals(serviceName, DEATH.getService());
        assertEquals(statusOfRequest, IN_PROGRESS.getStatus());
        assertEquals(dateOfRequest, currentDate);
    }
}
