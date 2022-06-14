package com.irinatest.test.common.models.response;

import lombok.Builder;
import lombok.Getter;

@Builder
public class CreateUserResponse {
    @Getter
    Integer applicantid;
    @Getter
    Integer applicationid;
    @Getter
    Integer citizenid;
    @Getter
    Integer merrigecertificateid;
}
