package com.horntell.exception;

public class NetworkException extends HorntellException {

        private String type;
	private String message;
        
	public NetworkException(String message, Integer code, String type, Throwable e) {
		super(message, code, type, e);
                this.message = "Could not connect to Horntell. Please check your network connection and try again. If the problem persists, please get in touch with us at hello@horntell.com.";
		this.type = "network_error";
	}
        
        public NetworkException(String message, Integer code, String type) {
		super(message, code, type);
                this.message = "Could not connect to Horntell. Please check your network connection and try again. If the problem persists, please get in touch with us at hello@horntell.com.";
		this.type = "network_error";
	}
}
