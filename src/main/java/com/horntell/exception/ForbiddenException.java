package com.horntell.exception;

public class ForbiddenException extends InvalidRequestException {
    public ForbiddenException(String message, Integer code, String type) {
        super(message, code, type);
    }
}
