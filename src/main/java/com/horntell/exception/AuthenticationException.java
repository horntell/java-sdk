package com.horntell.exception;

public class AuthenticationException extends Exception {

    public AuthenticationException(String message, Integer code, String type) {
        super(message, code, type);
    }

}
