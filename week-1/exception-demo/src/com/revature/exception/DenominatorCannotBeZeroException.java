package com.revature.exception;

public class DenominatorCannotBeZeroException extends Exception {

	public DenominatorCannotBeZeroException() {
		super();
	}

	public DenominatorCannotBeZeroException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public DenominatorCannotBeZeroException(String message, Throwable cause) {
		super(message, cause);
	}

	public DenominatorCannotBeZeroException(String message) {
		super(message);
	}

	public DenominatorCannotBeZeroException(Throwable cause) {
		super(cause);
	}

}
