package com.horntell.exception;

public class InvalidRequestException extends Exception {

    public InvalidRequestException(String message, Integer code, String type) {
        super(message, code, type);
    }

}
