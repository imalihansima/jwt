package com.demo.jwt.common.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Response {

    private String responseCode;
    private String status;
    private String message;

    @JsonIgnore
    private String statusCode;
    @JsonIgnore
    private String statusDesc;
}
