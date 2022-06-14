package com.irinatest.test.api;

import com.irinatest.test.common.models.response.ApplicationProcessResponse;
import com.irinatest.test.common.models.response.CreateAdminResponse;
import com.irinatest.test.common.models.response.CreateUserResponse;
import com.irinatest.test.common.models.response.GetAllApplicationResponse;
import com.irinatest.test.common.models.response.GetApplicationStatusResponse;
import com.irinatest.test.common.requests.AdminRequests;
import com.irinatest.test.common.requests.ApplicationRequests;
import com.irinatest.test.common.requests.UserRequests;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.LocalDate;

import static com.irinatest.test.common.models.ApplicationStatusFromBD.APPROVED;
import static com.irinatest.test.common.models.ApplicationStatusFromBD.CONSIDERATION;
import static com.irinatest.test.common.models.ApplicationStatusFromBD.DECLINE;
import static org.apache.commons.lang3.RandomStringUtils.randomNumeric;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;

public class ApplicationsTest {
    private AdminRequests adminRequests = new AdminRequests();
    private UserRequests userRequests = new UserRequests();
    private ApplicationRequests applicationRequests = new ApplicationRequests();
    private CreateAdminResponse admin;

    @BeforeClass
    public void init() {
        admin = adminRequests.createNewAdmin(LocalDate.now(), randomNumeric(8))
                .statusCode(200)
                .extract().body()
                .as(CreateAdminResponse.class);
    }

    @Test
    public void getNewApplicationStatus() {
        CreateUserResponse user = userRequests.createUserForTheDeath(LocalDate.now())
                .statusCode(200)
                .extract().body()
                .as(CreateUserResponse.class);

        Integer applicationId = user.getData().getApplicationid();

        GetApplicationStatusResponse status = applicationRequests
                .getApplicationStatus(applicationId.toString())
                .statusCode(200)
                .extract().body().as(GetApplicationStatusResponse.class);

        assertEquals(status.getData().getStatusofapplication(), CONSIDERATION.getStatus());
    }

    @Test
    public void acceptApplication() {
        CreateUserResponse user = userRequests.createUserForTheDeath(LocalDate.now())
                .statusCode(200)
                .extract().body()
                .as(CreateUserResponse.class);

        Integer applicationId = user.getData().getApplicationid();

        ApplicationProcessResponse processing = adminRequests
                .makeDecideForApplication(APPROVED, applicationId, admin.getData().getStaffid())
                .statusCode(200)
                .extract().body()
                .as(ApplicationProcessResponse.class);

        assertEquals(processing.getData().getStatusofapplication(), APPROVED.getStatus());
    }

    @Test
    public void declineApplication() {
        CreateUserResponse user = userRequests.createUserForTheDeath(LocalDate.now())
                .statusCode(200)
                .extract().body()
                .as(CreateUserResponse.class);

        Integer applicationId = user.getData().getApplicationid();

        ApplicationProcessResponse processing = adminRequests
                .makeDecideForApplication(DECLINE, applicationId, admin.getData().getStaffid())
                .statusCode(200)
                .extract().body()
                .as(ApplicationProcessResponse.class);

        assertEquals(processing.getData().getStatusofapplication(), DECLINE.getStatus());
    }

    @Test
    public void getAllApplications() {
        GetAllApplicationResponse applicationsList = applicationRequests.getAllApplications()
                .statusCode(200)
                .extract().body()
                .as(GetAllApplicationResponse.class);

        assertNotNull(applicationsList);
    }
}
