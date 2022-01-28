package com.santosh.springjdbcsample.builder;

import com.santosh.springjdbcsample.dto.response.BaseResponse;

public class BaseResponseBuilder {

    public static BaseResponse successResponse(String message) {
        BaseResponse baseResponse = new BaseResponse();
        baseResponse.setSuccess(true);
        baseResponse.setMessage(message);
        return baseResponse;
    }

    public static BaseResponse failureResponse(String message) {
        BaseResponse baseResponse = new BaseResponse();
        baseResponse.setSuccess(false);
        baseResponse.setMessage(message);
        return baseResponse;
    }
}
