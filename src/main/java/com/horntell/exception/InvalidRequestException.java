package com.horntell.exception;

public class InvalidRequestException extends HorntellException {

    public InvalidRequestException(String message, Integer code, String type, Throwable e) {
        super(message, code, type, e);
    }

    public InvalidRequestException(String message, Integer code, String type) {
        super(message, code, type);
    }

}
