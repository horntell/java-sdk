package com.horntell.exception;

public class ForbiddenException extends HorntellException {

    public ForbiddenException(String message, Integer code, String type, Throwable e) {
            super(message, code, type, e);
    }

    public ForbiddenException(String message, Integer code, String type) {
	super(message, code, type);
    }
}
