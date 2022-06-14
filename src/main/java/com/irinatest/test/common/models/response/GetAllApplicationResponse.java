package com.irinatest.test.common.models.response;

import lombok.Data;

import java.util.UUID;

@Data
public class GetAllApplicationResponse {
    DataRequest[] data;
    UUID requestId;

    @Data
    public static class DataRequest {
        Integer applicantid;
        Integer applicationid;
        Integer citizenid;
        String dateofapplication;
        String kindofapplication;
        String statusofapplication;
        String channel;
        String image;
        Integer staffid;
    }
}
