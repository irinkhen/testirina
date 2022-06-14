package com.irinatest.test.common.models.requests;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class ApplicationProcessRequest {
    Integer applId;
    Integer staffid;
    String action;
}