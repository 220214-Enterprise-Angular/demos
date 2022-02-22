package com.revature.main;

// You can't instantiate an interface
public interface MyIntegerList {
	
	double PI = 3.14; // public final static (implicitly)
	
	// Interface: defines an abstract data type
	// - contains only abstract methods (as of Java 8, the default keyword was introduced
	// in order to allow non-abstract methods to be defined inside of an interface. The
	// purpose was to promote backwards compatibility)
	//
	// - variables defined in an interface are ALWAYS public, static, and final
	// - non-static methods defined in an interface are ALWAYS public
	
	// add, get, and size are all ABSTRACT methods
	// Abstract method: a method with a signature, but NO body
	// the body of the method must be implemented in a class that inherits 
	// the abstract method
	void add(Integer element); // public (implicit)
	
	Integer get(int index); // public (implicit)
	
	int size(); // public (implicit)
	
	// You can have static methods in an interface
	// static methods aren't inherited
	public static void doSomething() {
		System.out.println("Hello world");
	}
	
}
