package com.demo.payment.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class NoResultException extends RuntimeException {

    public NoResultException(String message) {
        super(message);
    }
}
