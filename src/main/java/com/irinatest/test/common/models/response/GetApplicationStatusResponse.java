package com.irinatest.test.common.models.response;

import lombok.Builder;
import lombok.Getter;

@Builder
public class GetApplicationStatusResponse {
    @Getter
    Integer applicantid;
    @Getter
    Integer dateofapplication;
    @Getter
    Integer kindofapplication;
    @Getter
    Integer statusofapplication;
}