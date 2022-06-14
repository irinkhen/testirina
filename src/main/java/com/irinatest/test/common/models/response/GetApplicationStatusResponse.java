package com.irinatest.test.common.models.response;

import lombok.Data;

@Data
public class GetApplicationStatusResponse {
    DataRequest data;
    String requestId;
    @Data
    public static class DataRequest {
        Integer applicantid;
        String dateofapplication;
        String kindofapplication;
        String channel;
        String statusofapplication;
    }
}