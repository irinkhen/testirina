package com.irinatest.test.ui.user;

import com.irinatest.test.common.pageobjects.user.DeathServicePage;
import com.irinatest.test.common.pageobjects.user.PersonDataPage;
import com.irinatest.test.common.pageobjects.user.ServicesPage;
import com.irinatest.test.common.pageobjects.user.StatusPage;
import com.irinatest.test.common.pageobjects.user.UserRegistrationPage;
import com.irinatest.test.config.allure.TestListener;
import com.irinatest.test.config.dbconfig.DBUserHelper;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static com.irinatest.test.common.models.RequestStatus.IN_PROGRESS;
import static com.irinatest.test.common.models.ServiceName.DEATH;
import static java.time.format.DateTimeFormatter.ofPattern;
import static java.util.Locale.US;
import static org.apache.commons.lang3.RandomStringUtils.randomAlphabetic;
import static org.apache.commons.lang3.RandomStringUtils.randomNumeric;
import static org.testng.Assert.assertEquals;

@Listeners(TestListener.class)
public class StatusTest {
    private UserRegistrationPage registrationPage = new UserRegistrationPage();
    private ServicesPage servicesPage = new ServicesPage();
    private PersonDataPage personDataPage = new PersonDataPage();
    private DeathServicePage deathServicePage = new DeathServicePage();
    private StatusPage statusPage = new StatusPage();
    private DBUserHelper registerDB = new DBUserHelper();
    private String passport = randomNumeric(8);

    @BeforeMethod
    public void init() {
        registrationPage
                .navigate();
        registrationPage
                .loginByUser()
                .fillAllFields()
                .clickNextButton();
    }

    @AfterClass
    public void after() {
        Integer userId = Integer.valueOf(registerDB.getCitizenIdByPassport(passport));
        Integer applicantId = Integer.valueOf(registerDB.getApplicationIdByCitizenId(userId));
        System.out.println(userId);
        System.out.println(applicantId);

        registerDB.deleteDeathCertificatesById(applicantId);
        registerDB.deleteApplicationsByCitizenId(userId);
        registerDB.deleteApplicantByPassport(passport);
        registerDB.deleteCitizenById(userId);
        registerDB.deleteBirthCertificatesById(userId);

    }

    @Test
    public void fillInfoCorrectly() {
        servicesPage
                .selectDeath();
        personDataPage
                .fillLastName(randomAlphabetic(10))
                .fillName(randomAlphabetic(10))
                .fillSurname(randomAlphabetic(10))
                .fillDateOfBirth(LocalDate.now().minusYears(20))
                .fillPassport(passport)
                .fillGender("Ж")
                .clickNextButton();
        deathServicePage
                .fillAllFields()
                .clickFinalButton();
        statusPage
                .validate();
        //personDataPage.fillAllFields();

        String serviceName = statusPage.getServiceInfo();
        String statusOfRequest = statusPage.getStatusInfo();
        String dateOfRequest = statusPage.getDateOfRequestInfo();

        DateTimeFormatter format = ofPattern("E MMM dd yyyy").withLocale(US);
        String currentDate = LocalDate.now().format(format);

        assertEquals(serviceName, DEATH.getService());
        assertEquals(statusOfRequest, IN_PROGRESS.getStatus());
        assertEquals(dateOfRequest, currentDate);
    }
}
