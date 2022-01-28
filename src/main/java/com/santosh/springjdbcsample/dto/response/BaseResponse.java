package com.santosh.springjdbcsample.dto.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BaseResponse {
    private boolean success;
    private String message;
}
