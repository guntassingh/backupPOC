package com.rsystems.exceptions;

public class UrlFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public UrlFoundException(String message) {
		super(message);
	}
	
	public UrlFoundException(String message, Throwable cause) {
		super(message, cause);
	}
	
}
