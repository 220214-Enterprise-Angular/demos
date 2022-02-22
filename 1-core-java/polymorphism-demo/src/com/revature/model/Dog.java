package com.revature.model;

public class Dog extends Animal {

	// @Override is one particular ANNOTATION. Annotations can provide metadata for various different versatile purposes
	// If you place @Override on a method, it will tell the IDE + the compiler that you intended to override a method
	// If you are not actually overriding a method, it will complain to you that you are not
	@Override
	public void makeNoise() {
		System.out.println("Bark!");
	}
	
	/*
	 * Method overriding:
	 * Whenever you override a method, you need to have 
	 * 1. exactly the same number of parameters and type of parameters
	 * 2. same return type or covariant return types
	 * 		- Covariant return type means that the return type of the overridden method should be a subclass of the original return type
	 * 3. The access modifier must be the same or LESS restrictive
	 * 
	 */
	
}
