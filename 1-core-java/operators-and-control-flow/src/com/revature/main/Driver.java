package com.revature.main;

public class Driver {

	public static void main(String[] args) {
		
		// There are 4 different types of operators
		// 1. Arithmetic operators (+, -, *, /, %)
		// 2. Logical operators (&&, ||, !)
		// 3. Comparison operators (>, <, ==, >=, <=, !=)
		// 4. Assignment operators (=, +=, -=, *=, /=, %=)
		
		// 5. Bitwise (|, &, ^, ~, <<, >>, >>>) (a bit advanced, you can look into them)
		
		// Ternary Operator
		// <boolean expression> ? <expression if true> : <expression if false>
		int age = 20;
		String ageCategory = age >= 18 ? "Adult" : "Minor";
		System.out.println(ageCategory);
		
		// Control flow is an important part of any programming language and consists of
		//  1. conditional statements
		// 		- if
		// 		- if-else
		// 		- if-else if
		// 		- if-else if-else
		//  2. Switch statement
		//  3. Loops
		// 		- for loop
		// 		- while loop
		// 		- do-while loop
		
		/*
		 * conditional statements
		 * 
		 */
		
		//  if something is true, then do something
		if (age >= 18) {
			System.out.println("Person is an adult");
		}
		
		// if something is true, then do that, otherwise this other thing
		boolean isSunny = false;
		if (isSunny) {
			System.out.println("Let's go outside");
		} else {
			System.out.println("Let's stay indoors");
		}
		
		// if something is true, then do that, else if something else is true, then do that, otherwise
		// do the last thing
		if (age == 18) {
			System.out.println("You just became an adult");
		} else if (age > 18) {
			System.out.println("You are an adult");
		} else {
			System.out.println("You are a minor");
		}
		
		/*
		 * Switch statement
		 * 
		 * Supports the following datatypes: 
		 * 	1. int
		 *  2. char
		 *  3. short
		 *  4. byte
		 *  5. String
		 *  6. Wrapper classes of the primitives mentioned above 
		 *  	(Integer, Character, Short, Byte)
		 *  7. Enum
		 */
		int month = 1;
		switch(month) {
			case 1:
				System.out.println("It is January");
				break;
			case 2:
				System.out.println("It is February");
				break;
			case 3:
				System.out.println("It is March");
				break;
			default:
				System.out.println("It's not January, February, or March");
		}
		
		/*
		 * Loops
		 */
		
		// for loop
		// syntax: for (<initialization block>; <conditional block>; <incrementing/decrementing block>)
		for (int i = 0; i < 100; i++) {
			System.out.println("i = ");
			System.out.println(i);
		}
		
		System.out.println("==================");
		// while loop
		int i = 101;
		while (i < 100) {
			System.out.println("i = ");
			System.out.println(i);
			i++;
		}
		
		System.out.println("==================");
		// do-while loop
		// executes at LEAST ONCE
		// because it checks the condition at the end, not at the beginning
		int j = 101;
		do {
			System.out.println("i = ");
			System.out.println(i);
			i++;
		} while (i < 100);
		
		
	}

}
