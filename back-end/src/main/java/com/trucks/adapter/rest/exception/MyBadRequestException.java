package com.trucks.adapter.rest.exception;

import org.springframework.http.HttpStatus;

public class MyBadRequestException extends MyException {

    public MyBadRequestException() {
        super();
        super.setStatus(HttpStatus.BAD_REQUEST);
        super.setMessage(ApiError.MESSAGE_BAD_REQUEST);
    }
}