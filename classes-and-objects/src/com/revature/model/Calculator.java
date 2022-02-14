package com.revature.model;

public class Calculator {

	public double add(double x, double y) {
		return x + y;
	}
	
	public double subtract(double x, double y) {
		return x - y;
	}
	
	public double multiply(double x, double y) {
		return x * y;
	}
	
	public double divide(double x, double y) {
		return x / y;
	}
	
	public double remainder(double x, double y) {
		return x % y; // % is the modulus operator. It will return the remainder of x divided by y
	}
	
}
