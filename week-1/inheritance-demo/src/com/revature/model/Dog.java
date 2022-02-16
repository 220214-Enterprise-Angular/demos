package com.revature.model;

// When Dog extends Animal, we are adding in addition to the properties already existing in Animal,
// the name property and the fetch behavior
public class Dog extends Animal {
	
	private String name;

	// Whenever you construct an Object of a subclass, you will always need to also invoke the constructor in the superclass
	public Dog(String name, String favoriteFood, String noise, int numOfLegs, boolean isDeceased) {
		super(favoriteFood, noise, numOfLegs, isDeceased);
		this.name = name;
	}
	
	public void fetch() {
		System.out.println(this.name + " is playing fetch and running with " + super.numOfLegs + " legs");
		// super.<variable name> is not required, but the main reason we might use it here
		// is for READABILITY
		// It allows any programmer looking at our code to know that we are referring to an instance variable in the parent class, 
		// not inside of this current class
	}

	/*
	 * Getters and Setters
	 */
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
	
}
