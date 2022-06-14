package com.irinatest.test.common.models.response;

import lombok.Data;

import java.util.UUID;

@Data
public class CreateUserResponse {
    DataRequest data;
    UUID requestId;
    @Data
    public static class DataRequest {
        Integer applicantid;
        Integer applicationid;
        Integer citizenid;
        Integer merrigecertificateid;
        Integer deathcertificateid;
        Integer birthcertificateid;
    }
}
