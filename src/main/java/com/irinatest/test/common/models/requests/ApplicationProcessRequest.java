package com.irinatest.test.common.models.requests;

import lombok.Builder;
import lombok.Getter;

@Builder
public class ApplicationProcessRequest {
    @Getter
    Integer applId;
    @Getter
    Integer staffid;
    @Getter
    String action;
}