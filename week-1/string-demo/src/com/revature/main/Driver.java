package com.revature.main;

// java.lang is a special package that is always imported for any class
// You do not need to import classes explicitly that are contained inside the java.lang package
// within the Java runtime library

public class Driver {

	public static void main(String[] args) {
		
		String s; // I have created a variable called s of the type String
		// "Variable Declaration"
		
		s = "hi there, I am a String"; // Strings are objects
		// Therefore, s is a reference variable
		
		// "hi there, I am a String" <- " " signifies a 'string literal'
		
		char[] charArray = { 'h', 'e', 'l', 'l', 'o' }; // 'e' <- char literal (') 
		String s2 = new String(charArray);
		
		System.out.println("s: " + s);
		System.out.println("s2: " + s2);
		
		// s = "hi there, I'm a String"
		// s2 = "hello"
		
		s = s.concat(s2); // Any method in the String API that returns a String is actually
		// creating a new String object
		System.out.println(s);
		
		// The reason .concat does not modify the existing String in place is because...
		// STRINGS ARE IMMUTABLE. In other words, once you create a String object,
		// The value of the String object cannot be changed
		
		System.out.println(s.length()); // .length() to see the number of characters of a String
	
		System.out.println(s.startsWith("hi there")); // true
		System.out.println(s.endsWith("String")); // false
		
		/*
		 * Couple of different ways to iterate through a String's characters
		 */
		for (int i = 0; i < s.length(); i++) {
			System.out.println(s.charAt(i));
		}
		
		char[] charactersInStringS = s.toCharArray();
		
		for (int i = 0; i < charactersInStringS.length; i++) {
			System.out.println(charactersInStringS[i]);
		}
		
		for (char c : charactersInStringS) {
			System.out.println(c);
		}
		
		/*
		 * USE .equals() when comparing the values of 2 strings, NOT ==
		 */
		
		String s3 = "hey";
		String s4 = new String("hey");
		System.out.println("s3 == s4: " + (s3 == s4));
		
		System.out.println("s3.equals(s4): " + (s3.equals(s4)));
	}

}
