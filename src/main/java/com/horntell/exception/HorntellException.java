package com.horntell.exception;

public class HorntellException extends Exception {

	private Integer code;
	private String type;
	private String message;

	public HorntellException(String message, Integer code, String type, Throwable e) {
		super(message, e);
		this.code = code;
		this.type = type;
	}
        
        public HorntellException(String message, Integer code, String type) {
		super(message, null);
		this.code = code;
		this.type = type;
	}
        
        public Integer getCode() {
		return code;
	}
	public String getType() {
		return type;
	}
}
