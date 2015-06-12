package com.horntell.exception;

public class AuthenticationException extends HorntellException {

    public AuthenticationException(String message, Integer code, String type, Throwable e) {
            super(message, code, type, e);
    }

    public AuthenticationException(String message, Integer code, String type) {
            super(message, code, type);
    }

}
