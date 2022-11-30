package com.software.gameHub.core.exception;

public class CustomerNotFoundException extends RuntimeException {
    public CustomerNotFoundException(String  message) {
        super(message);
    }
}
