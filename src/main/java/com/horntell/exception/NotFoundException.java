package com.horntell.exception;

public class NotFoundException extends HorntellException {

	public NotFoundException(String message, Integer code, String type, Throwable e) {
		super(message, code, type, e);
	}

    public NotFoundException(String message, Integer code, String type) {
        super(message, code, type);
    }

}
