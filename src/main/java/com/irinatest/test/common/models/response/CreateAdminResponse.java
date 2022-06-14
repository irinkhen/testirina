package com.irinatest.test.common.models.response;

import lombok.Data;

import java.util.UUID;

@Data
public class CreateAdminResponse {
    DataRequest data;
    UUID requestId;

    @Data
    public static class DataRequest {
        Integer staffid;
    }
}
