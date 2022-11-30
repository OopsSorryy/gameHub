package com.software.gameHub.core.exception;

public class GameAlreadyExistInLibrary extends RuntimeException {
    public GameAlreadyExistInLibrary(String message) {
        super(message);
    }
}
