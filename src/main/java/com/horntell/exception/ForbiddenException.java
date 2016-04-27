package com.horntell.exception;

public class ForbiddenException extends Exception {
    public ForbiddenException(String message, Integer code, String type) {
        super(message, code, type);
    }
}
