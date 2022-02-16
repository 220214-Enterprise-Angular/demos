package com.revature.model;

public class Calculator {

	// Breadcrumb statements = code that you leave inside of different sections of your program to see what is being executed
	
	
	/*
	 * Method overloading
	 * 
	 * Requirements for method overloading:
	 * 1. Same method name
	 * 2. Different # of parameters and/or type of parameters
	 * 
	 * Unlike method overriding, method overloading is nothing special
	 * Method overloading is simply a bunch of different methods with the same name
	 */
	public double sum(double x, double y) {
		System.out.println("double sum(double, double) invoked");
		return x + y;
	}
	
	public double sum(double x, double y, double z) {
		System.out.println("double sum(double, double, double) invoked");
		return x + y + z;
	}
	
	public double sum(double... numbers) {
		System.out.println("double sum(double...) invoked");
		
		double sum = 0;
		
		for (double element : numbers) {
			sum += element;
		}
		
		return sum;
	}
	
	public int sum(int x, int y) {
		System.out.println("int sum(int, int) invoked");
		return x + y;
	}
	
}
