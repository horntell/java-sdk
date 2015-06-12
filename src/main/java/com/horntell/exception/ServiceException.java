package com.horntell.exception;

public class ServiceException extends HorntellException {

    public ServiceException(String message, Integer code, String type, Throwable e) {
            super(message, code, type, e);
    }

    public ServiceException(String message, Integer code, String type) {
            super(message, code, type);
    }


}
