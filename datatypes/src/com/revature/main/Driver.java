package com.revature.main;

public class Driver {

	public static void main(String[] args) {
		
		// Variable: a placeholder for some value
		// int x = 10
		//
		// Java is a strongly typed language, which means that ALL variables have a specific type
		// for example the variable x above has the type "int"
		
		// At a high level, there are two types of variables in Java
		// 1. primitive types: 8 types
		// 2. reference types: infinite number of reference types
		
		/*
		 * Primitive Types:
		 * 1. byte (-128 to 127) (8 bits)
		 * 2. short (-32,768 to 32,767) (16 bits)
		 * 3. char (0 to 65,536) (16 bits)
		 * 4. int (-2,147,483,648 to 2,147,483, 647) (32 bits)
		 * 5. long (-9,223,372,036,854,775,808 to 9,223,372,036,854,775,807) (64 bits)
		 * 6. float (±3.40282347E+38F) (32 bits)
		 * 7. double (±1.79769313486231570E+308) (64 bits)
		 * 8. boolean (true or false) (JVM dependent)
		 */
		
		// Most commonly used primitive types?
		// 1. int
		// 2. double
		// 3. boolean
		// 4. char
		
		// What is a literal? it's a constant value\
		byte reallySmallNumber = 127;
		short shortNumber = 32767;
		char letter = 'a'; // you can store numbers in a char, but typically you will store a character
		int standardNumber = 1000000;
		long bigNumber = 12312312313212312L; // an L at the end of the number signifies that the number is a long literal
		float smallerDecimalNumber = 93.8f;
		double standardDecimalNumber = 100.8; // by default, any decimal number is going to be a "double" literal
		
		boolean isHungry = true; // false
		
		/*
		 * Casting: turning values of one type into another
		 * 
		 * Widening Casting (implicit) -- Automatic (smaller to larger) ex. byte to int
		 * Narrowing Casting (explicit) -- Need to manually tell the computer (larger to smaller) ex. int to byte
		 */
		
		byte a = 40;
		int b = a; // the value of a is a byte, which can be turned into an int, and stored inside of the int variable
		
		byte c = (byte) b; // The value of b is an int, and we want to store it inside of a byte variable, but you
		// need to manually tell it to convert to a smaller value
		
		// Reference variables have a different term
		// 1. Upcasting
		// 2. Downcasting
		
		/*
		 * Constants
		 * 
		 * We have the "final" keyword that can be 
		 * applied to variables
		 * 
		 * This means that you cannot change the value of that variable
		 * 
		 * Constants should be completely uppercase, and if there are multiple words, use an _
		 * ex. NUM_OF_WHEELS
		 */
		final double PI = 3.14159;
		
		/*
		 * Naming conventions
		 * 
		 * Classes: Start with uppercase letters
		 * 	ex. SodaCan
		 * 
		 * Variables: Camelcase
		 * 	ex. myVeryLargeNumber
		 * 
		 * Methods: Camelcase
		 * 	ex. makeNoise()
		 * 
		 * packages: all lowercase
		 * 	ex. com.revature.main
		 */
	}
	
}
