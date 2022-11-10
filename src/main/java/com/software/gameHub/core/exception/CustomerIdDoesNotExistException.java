package com.software.gameHub.core.exception;

public class CustomerIdDoesNotExistException extends RuntimeException {
    public CustomerIdDoesNotExistException(String message) {
        super(message);
    }
}
