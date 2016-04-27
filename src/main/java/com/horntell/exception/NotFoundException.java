package com.horntell.exception;

public class NotFoundException extends InvalidRequestException {

    public NotFoundException(String message, Integer code, String type) {
        super(message, code, type);
    }

}
