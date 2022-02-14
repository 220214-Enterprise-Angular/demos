package com.revature.main;

import com.revature.model.Calculator;
import com.revature.model.SportsCar;

public class Driver {

	public static void main(String[] args) {
		// SportsCar sc1 = new SportsCar(); // invoking the default constructor
			
		// Whenever we define a class that we do not explicitly write a constructor inside of,
		// then the compiler will provide what is known as a default constructor
		// This is a constructor that takes in 0 arguments and simply calls super()
		
		SportsCar sc2 = new SportsCar("Toyota", "Supra", 1994, "red", 800, 750);
		SportsCar sc3 = new SportsCar("BMW", "M3", 2018, "black", 500, 400);
		
		sc2.accelerate(); // Toyota Supra is accelerating!
		sc3.accelerate(); // BMW M3 is accelerating!
		
		Calculator c1 = new Calculator();
		
		double addResult = c1.add(5, 10); // add returns a double
		double subtractResult = c1.subtract(10, 3.5);
		double multiplyResult = c1.multiply(2.3, 2);
		double divideResult = c1.divide(5, 2);
		double remainderResult = c1.remainder(4, 2);
		
		System.out.println(addResult);
		System.out.println(subtractResult);
		System.out.println(multiplyResult);
		System.out.println(divideResult);
		System.out.println(remainderResult);
	}
	
}
