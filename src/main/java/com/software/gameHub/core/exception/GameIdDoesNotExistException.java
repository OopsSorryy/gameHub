package com.software.gameHub.core.exception;

public class GameIdDoesNotExistException extends  RuntimeException{
    public GameIdDoesNotExistException(String message) {
        super(message);
    }
}
