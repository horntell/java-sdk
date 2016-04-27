package com.horntell.exception;

public class ServiceException extends Exception {

    public ServiceException(String message, Integer code, String type) {
        super(message, code, type);
    }

}
