package com.revature.exceptions;

// This is an unchecked exception that may occur at runtime when a user fails registration
public class RegisterUserFailedException extends RuntimeException{

	public RegisterUserFailedException(String message) {
		super(message);
		// This is a constructor I've inherited from the RuntimeException class
	}
}
