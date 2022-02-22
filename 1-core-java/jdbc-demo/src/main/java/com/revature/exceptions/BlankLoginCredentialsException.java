package com.revature.exceptions;

public class BlankLoginCredentialsException extends Exception {

	public BlankLoginCredentialsException() {
		super();
	}

	public BlankLoginCredentialsException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public BlankLoginCredentialsException(String message, Throwable cause) {
		super(message, cause);
	}

	public BlankLoginCredentialsException(String message) {
		super(message);
	}

	public BlankLoginCredentialsException(Throwable cause) {
		super(cause);
	}

}
