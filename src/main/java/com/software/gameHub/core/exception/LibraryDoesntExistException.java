package com.software.gameHub.core.exception;

public class LibraryDoesntExistException extends RuntimeException {
    public LibraryDoesntExistException(String message) {
        super(message);
    }
}
