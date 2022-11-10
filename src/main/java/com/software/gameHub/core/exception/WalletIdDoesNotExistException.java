package com.software.gameHub.core.exception;

public class WalletIdDoesNotExistException extends RuntimeException {
    public WalletIdDoesNotExistException(String message) {
        super(message);
    }
}
