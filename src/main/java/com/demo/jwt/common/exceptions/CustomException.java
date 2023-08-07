package com.demo.jwt.common.exceptions;

import com.demo.jwt.common.helpers.RequestStatus;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class CustomException extends RuntimeException{

    private String status;
    private String code;

    public CustomException() {
        super();
    }
    public CustomException(String message) {
        super(message);
    }
    public CustomException(String code, String message) {
        super(message);
        this.setStatus(RequestStatus.FAILURE.getStatus());
        this.code = code;
    }

}
