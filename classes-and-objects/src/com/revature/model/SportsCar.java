package com.revature.model;

// Class: A blueprint for creating instances of the class (objects)
// 		A class should contain the following "members":
// 			1. Properties/states/fields (class-level variables)
//			2. Behaviors (methods)
// 			3. Constructor
public class SportsCar {
	
	// A field is a variable defined directly at the class-level
	// It defines the properties that any instances (objects) of that class should have
	public String make;
	public String model;
	public int year;
	public String color;
	public int hp;
	public int torque;
	
	// This is provided implicitly by the compiler (if there are no constructors explicitly defined)
	// But this is basically what it looks like
//	public SportsCar() {
//		super();
//	}
	
	// A constructor normally takes in arguments by defining parameters
	// make, model, year, etc. are constructor "parameters"
	// Whatever values you pass into a method or constructor are "arguments"
	// Whatever you define for that method/constructor are "parameters"
	public SportsCar(String make, String model, int year, String color, int hp, int torque) {
		// super(); // super is inserted automatically at the top of the constructor
		this.make = make;
		this.model = model;
		this.year = year;
		this.color = color;
		this.hp = hp;
		this.torque = torque;
	}
	
	// What is the structure of a method?
	// <access-modifier?> <non-access-modifier?> <return type> methodName(method-parameters?) { }
	
	// Parameters basically represent input to the method so that the method could
	// potentially modify that input
	// 
	// The return value represents the output of that method
	// input -> code doing some processing -> output
	
	// analogy: factory
	// raw materials -> factory -> car
	public void accelerate() {
		System.out.println(this.make + " " + this.model + " is accelerating!");
	}
	
}
