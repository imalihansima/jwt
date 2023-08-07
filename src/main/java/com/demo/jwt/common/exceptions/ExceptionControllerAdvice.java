package com.demo.jwt.common.exceptions;

import com.demo.jwt.common.dto.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionControllerAdvice {

    private final Logger log = LoggerFactory.getLogger(ExceptionControllerAdvice.class);

    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public ResponseEntity<Response> processMethodNotAllowedException(HttpRequestMethodNotSupportedException ex) {

        Response error = new Response();
        error.setResponseCode(HttpStatus.METHOD_NOT_ALLOWED.toString());
        error.setMessage(ex.getMessage());
        return new ResponseEntity<>(error, HttpStatus.METHOD_NOT_ALLOWED);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Response> processRuntimeException(Exception ex) {

        String INTERNAL_ERROR = "WMS SYSTEM INTERNAL ERROR";
        log.error(INTERNAL_ERROR, ex);
        Response error = new Response();
        error.setResponseCode(HttpStatus.INTERNAL_SERVER_ERROR.toString());
        if (ex.getMessage() != null) {
            error.setMessage(ex.getMessage());
        }
        else {
            error.setMessage(INTERNAL_ERROR);
        }
        return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(CustomException.class)
    public ResponseEntity<Response> processValidationException(CustomException ex) {

        Response error = new Response();
        if(ex.getCode() != null) {
            error.setResponseCode(ex.getCode());
        }
        else {
            error.setResponseCode(String.valueOf(HttpStatus.BAD_REQUEST.value()));
        }
        error.setMessage(ex.getMessage());
        error.setStatus(ex.getStatus());
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }
}
