package com.example.springbootdemo.api.exception;

public class InvalidRequestException extends ApplicationException {
    public InvalidRequestException(String message) {
        super(message);
    }
}
