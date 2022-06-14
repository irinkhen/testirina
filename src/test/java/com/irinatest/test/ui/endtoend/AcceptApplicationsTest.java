package com.irinatest.test.ui.endtoend;

import com.irinatest.test.common.pageobjects.admin.AdminRegistrationPage;
import com.irinatest.test.common.pageobjects.admin.ApplicationsPage;
import com.irinatest.test.common.pageobjects.user.BirthServicePage;
import com.irinatest.test.common.pageobjects.user.MarriageServicePage;
import com.irinatest.test.common.pageobjects.user.PersonDataPage;
import com.irinatest.test.common.pageobjects.user.ServicesPage;
import com.irinatest.test.common.pageobjects.user.StatusPage;
import com.irinatest.test.common.pageobjects.user.UserRegistrationPage;
import com.irinatest.test.config.dbconfig.DBUserHelper;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.LocalDate;

import static com.codeborne.selenide.Selenide.refresh;
import static com.irinatest.test.common.models.AdminApplicationName.BIRTH;
import static com.irinatest.test.common.models.AdminApplicationName.MARRIAGE;
import static com.irinatest.test.common.models.AdminStatusApplication.ACCEPT;
import static com.irinatest.test.common.models.AdminStatusApplication.PROGRESS;
import static com.irinatest.test.common.models.AdminStatusApplication.REJECT;
import static com.irinatest.test.common.models.ApplicationStatusFromBD.APPROVED;
import static com.irinatest.test.common.models.ApplicationStatusFromBD.DECLINE;
import static org.apache.commons.lang3.RandomStringUtils.randomAlphabetic;
import static org.apache.commons.lang3.RandomStringUtils.randomNumeric;
import static org.testng.Assert.assertEquals;

public class AcceptApplicationsTest {
    private AdminRegistrationPage registrationAdminPage = new AdminRegistrationPage();
    private ApplicationsPage applicationsPage = new ApplicationsPage();
    private UserRegistrationPage registrationUserPage = new UserRegistrationPage();
    private ServicesPage servicesPage = new ServicesPage();
    private PersonDataPage personDataPage = new PersonDataPage();
    private BirthServicePage birthService = new BirthServicePage();
    private MarriageServicePage marriageServicePage = new MarriageServicePage();
    private StatusPage statusPage = new StatusPage();
    private DBUserHelper registerDB = new DBUserHelper();

    @BeforeMethod
    public void init() {
        registrationUserPage
                .navigate();
        registrationUserPage
                .loginByUser()
                .fillAllFields()
                .clickNextButton();
    }

    @Test
    public void acceptApplicationTest() {
        String passport = randomNumeric(8);

        servicesPage
                .selectBorn();
        personDataPage
                .fillLastName(randomAlphabetic(10))
                .fillName(randomAlphabetic(10))
                .fillSurname(randomAlphabetic(10))
                .fillDateOfBirth(LocalDate.now().minusYears(20))
                .fillPassport(passport)
                .fillGender("Ж")
                .clickNextButton();
        birthService
                .fillAllFields()
                .clickFinalButton();
        statusPage
                .validate();

        Integer userId = Integer.valueOf(registerDB.getCitizenIdByPassport(passport));
        Integer applicationId = Integer.valueOf(registerDB.getApplicationIdByCitizenId(userId));

        registrationUserPage
                .navigate();
        registrationUserPage
                .loginByAdmin();
        registrationAdminPage
                .fillAllFields()
                .clickNextButton();

        String applicationStatus = applicationsPage.getApplicationStatus(applicationId);
        String applicationType = applicationsPage.getApplicationType(applicationId);

        assertEquals(applicationStatus, PROGRESS.getStatus());
        applicationsPage.acceptApplication(applicationId);
        applicationsPage.waitNewStatus(applicationId, ACCEPT.getStatus());
        String newApplicationStatus = applicationsPage.getApplicationStatus(applicationId);
        String applicationStatusFromBD = registerDB.getApplicationStatus(applicationId);

        assertEquals(applicationType, BIRTH.getService());
        assertEquals(newApplicationStatus, ACCEPT.getStatus());
        assertEquals(applicationStatusFromBD, APPROVED.getStatus());
    }

    @Test
    public void declineApplicationTest() {
        String passport = randomNumeric(8);

        servicesPage
                .selectMarried();
        personDataPage
                .fillLastName(randomAlphabetic(10))
                .fillName(randomAlphabetic(10))
                .fillSurname(randomAlphabetic(10))
                .fillDateOfBirth(LocalDate.now().minusYears(20))
                .fillPassport(passport)
                .fillGender("Ж")
                .clickNextButton();
        marriageServicePage
                .fillAllFields()
                .clickFinalButton();
        statusPage
                .validate();

        Integer userId = Integer.valueOf(registerDB.getCitizenIdByPassport(passport));
        Integer applicationId = Integer.valueOf(registerDB.getApplicationIdByCitizenId(userId));

        registrationUserPage
                .navigate();
        refresh();
        registrationUserPage
                .loginByAdmin();
        registrationAdminPage
                .fillAllFields()
                .clickNextButton()
                .reloadApplications();

        String applicationStatus = applicationsPage.getApplicationStatus(applicationId);
        String applicationType = applicationsPage.getApplicationType(applicationId);

        assertEquals(applicationStatus, PROGRESS.getStatus());

        applicationsPage.declineApplication(applicationId);
        applicationsPage.waitNewStatus(applicationId, REJECT.getStatus());
        String newApplicationStatus = applicationsPage.getApplicationStatus(applicationId);
        String applicationStatusFromBD = registerDB.getApplicationStatus(applicationId);

        assertEquals(applicationType, MARRIAGE.getService());
        assertEquals(newApplicationStatus, REJECT.getStatus());
        assertEquals(applicationStatusFromBD, DECLINE.getStatus());
    }
}
