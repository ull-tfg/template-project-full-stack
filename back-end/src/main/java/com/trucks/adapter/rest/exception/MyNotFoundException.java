package com.trucks.adapter.rest.exception;

import org.springframework.http.HttpStatus;

public class MyNotFoundException extends MyException {

    public MyNotFoundException() {
        super();
        super.setStatus(HttpStatus.NOT_FOUND);
        super.setMessage(ApiError.MESSAGE_NOT_FOUND);
    }
}
