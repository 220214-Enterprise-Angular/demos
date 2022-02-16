package com.revature.main;

public class Driver {

	public static void main(String[] args) {
		
		// 0, 1, 2, 3, 4, 5, 6, 7, 8
		String s = "my string"; 
		
		long startTime;
		long endTime;
		
		startTime = System.nanoTime();
		System.out.println(reverseStringWithStringConcatenation(s));
		endTime = System.nanoTime();
		
		System.out.println("reverseStringWithStringConcatenation took " + (endTime - startTime) + " nano seconds");
		
		startTime = System.nanoTime();
		System.out.println(reverseStringWithStringBuilder(s));
		endTime = System.nanoTime();
		
		System.out.println("reverseStringWithStringBuilder took " + (endTime - startTime) + " nano seconds");

	}
	
	// Algorithm: a series of steps to accomplish a particular task
	// Task: reverse a String
	// Input: a String
	// Output: the String reversed
	
	// Time complexity: quantify on an abstract level how fast an algorithm takes given 
	// a certain input size
	
	// Ex. A longer string will result in a longer time that the algorithm must run for
	
	// This algorithm is O(n^2)
	public static String reverseStringWithStringConcatenation(String s) {
		String myReversedString = "";
		
		for (int i = s.length() - 1; i >= 0; i--) {
			myReversedString = myReversedString + s.charAt(i); // j + 1 steps, where j is the
			// current length of the myReversedString
			// Whenever you concatenate Strings, it must make a brand new copy of the original 
			// String + the new String added to it
		}
		
		return myReversedString;
	}
	// n + (n - 1) + (n - 2) + 1
	// -> n^2
	

	// 1 + n + n = 2n + 1 -> n
	// This is a O(n) algorithm
	public static String reverseStringWithStringBuilder(String s) {
		StringBuilder sb = new StringBuilder(); // 1 operation
		
		// n times
		// n iterations * 1 operation = n operations
		for (int i = s.length() - 1; i >= 0; i--) {
			sb.append(s.charAt(i)); // O(1) operation
		}
		
		return new String(sb); // n operations
	}
	
	// hello
	// hello  (5 + 1) <- hello + ' '
	// hello w (6 + 1) <- hello' ' + 'w'
	// hello wo (7 + 1)
	// hello wor (8 + 1)
	// (5 + 1) + 6 + 1 + 7 + 1 + 8 + 1
	
	// sum all the numbers from 1 to 100
	// n (n + 1) / 2 = (n^2 + n) / 2 -> n^2
}
