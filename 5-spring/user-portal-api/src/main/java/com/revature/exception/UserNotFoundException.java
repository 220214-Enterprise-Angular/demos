package com.revature.exception;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class UserNotFoundException extends RuntimeException{
	
	// right click -> source -> generate Constructors from SuperClass
	public UserNotFoundException(String message) {
		super(message);
	}

}
