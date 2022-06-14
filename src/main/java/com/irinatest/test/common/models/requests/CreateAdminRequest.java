package com.irinatest.test.common.models.requests;

import lombok.Builder;
import lombok.Getter;

@Builder
public class CreateAdminRequest {
    @Getter
    String dateofbirth;
    @Getter
    String personalFirstName;
    @Getter
    String personalLastName;
    @Getter
    String personalMiddleName;
    @Getter
    String personalNumberOfPassport;
    @Getter
    String personalPhoneNumber;
}