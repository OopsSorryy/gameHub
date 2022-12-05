package com.software.gameHub.core.exception;

public class YouDoNotHaveEnoughMoneyException extends RuntimeException {
    public YouDoNotHaveEnoughMoneyException(String messge) {
        super(messge);
    }
}
