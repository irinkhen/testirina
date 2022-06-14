package com.irinatest.test.common.models.response;

import lombok.Builder;
import lombok.Getter;

@Builder
public class ApplicationProcessResponse {
    @Getter
    Integer applicantid;
    @Getter
    Integer applicationid;
    @Getter
    Integer citizenid;
    @Getter
    String dateofapplication;
    @Getter
    String kindofapplication;
    @Getter
    Integer statusofapplication;
    @Getter
    Integer staffid;
}
