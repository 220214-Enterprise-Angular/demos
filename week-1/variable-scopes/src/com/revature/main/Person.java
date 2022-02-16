package com.revature.main;

import java.util.ArrayList;

public class Person {
	
	// global / static scope
	public static int numOfInstances;
	
	// Instance scope
	// The variables are scoped to individual 
	// instances (objects) created from this class
	public String firstName;
	public String lastName;
	public int age;
	
	public Person(String firstName, String lastName, int age) {
		// this.firstName <- instance scoped
		// firstName <- method scoped
		// They are 2 DIFFERENT variables
		this.firstName = firstName;
		
		this.lastName = lastName;
		this.age = age;
		
		numOfInstances++;
	}
	
	public void calculateAge100YearsFromNow() {
		// x is a method scoped variable
		int x = this.age + 100;
		
		System.out.println("100 years from now, this person will be " + x);
		
		for (int i = 0; i < 100; i++) {
			// i is block scoped
		}
		
		if (true) {
			int myBlockScopedVariable = 50; // block scoped
		}
		
		// block scoped variables only exist inside of the block
		// being executed
		// When the block of code is done executing, the variables
		// are essentially destroyed
	}
	
}
