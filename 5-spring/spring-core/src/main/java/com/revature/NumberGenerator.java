package com.revature;

public interface NumberGenerator {
	
	// produce a number
	int next();
	
	// get a max number
	int getMaxNumber();
	
	// why an interface? To define a contractual behavior of these methods.
	// even thought we don't provide the implementation, we state that these
	// methods will only everreturn the type that we define here.
	
	// All the details of HOW these abstract methods return their defined type will
	// be defined in an Impl class
}
