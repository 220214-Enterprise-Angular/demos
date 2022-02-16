package com.revature.main;

import java.util.Scanner;

import com.revature.exception.DenominatorCannotBeZeroException;

public class Driver {

	private static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		// Idea: create an application that takes in
		// 1. a number for the numerator
		// 2. a number for the denominator
		
		System.out.println("Welcome to the calculator app for dividing numbers");
		
		System.out.println("Please enter a numerator: ");
		double numerator = Double.parseDouble(sc.nextLine());
		
		System.out.println("Please enter a denominator: ");
		double denominator = Double.parseDouble(sc.nextLine());
		
		try {
			System.out.println("The result is: " + divide(numerator, denominator));
		} catch (DenominatorCannotBeZeroException e) {
			System.out.println(e.getMessage());
		} finally { // finally block will always run whether an exception occurs or not
			System.out.println("This will always run regardless of what happens");
		}
		
		System.out.println("=== PROGRAM ENDED SUCCESSFULLY ===");
		
	}
	
	public static double divide(double x, double y) throws DenominatorCannotBeZeroException {
		
		if (y == 0) {
			throw new DenominatorCannotBeZeroException("You cannot have a denominator of 0"); // Throw the checked exception
			// DenominatorCannotBeZeroException
		}
		
		double result = x / y;
		
		return result;
	}

}
