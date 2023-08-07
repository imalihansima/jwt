package com.demo.jwt.common.helpers;

public enum ResponseCode {
    SUCCESS("01"),
    FAILED("00"),
    BAD_REQUEST_CODE("400"),
    INVALID_LOGGING("2000"),
    INVALID_USER("2002"),
    INVALID_ORDER("2003"),
    EMAIL_FOUND("2001");

    private final String responseCode;

    ResponseCode(String responseCode) {
        this.responseCode = responseCode;
    }

    public String getResponseCode() {
        return responseCode;
    }
}
