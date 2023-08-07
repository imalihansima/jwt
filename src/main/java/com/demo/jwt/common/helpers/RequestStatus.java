package com.demo.jwt.common.helpers;

public enum RequestStatus {
    SUCCESS("success"),
    FAILURE("failure");
    private final String status;

    RequestStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }
}
