package com.horntell.exception;

public class Exception extends java.lang.Exception {

    private Integer code;
    private String type;
    private String message;

    public Exception(String message, Integer code, String type, Throwable e) {
        super(message, e);
        this.code = code;
        this.type = type;
    }

    public Exception(String message, Integer code, String type) {
        super(message, null);
        this.code = code;
        this.type = type;
    }
}
