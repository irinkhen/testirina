package com.irinatest.test.api;

import com.irinatest.test.common.models.response.CreateAdminResponse;
import com.irinatest.test.common.requests.AdminRequests;
import org.testng.annotations.Test;

import java.time.LocalDate;

import static org.apache.commons.lang3.RandomStringUtils.randomNumeric;

public class CreateAdminTest {
    private AdminRequests adminRequests = new AdminRequests();

    @Test
    public void createAdminTest() {
        String passport = randomNumeric(8);

        CreateAdminResponse response = adminRequests
                .createNewAdmin(LocalDate.now().minusYears(1), passport)
                .statusCode(200)
                .extract().body().as(CreateAdminResponse.class);
    }

}
