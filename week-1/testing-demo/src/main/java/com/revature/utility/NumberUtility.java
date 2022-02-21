package com.revature.utility;

public class NumberUtility {

	// true if a number is prime
	// false if a number is not prime
	// Prime: a number that can be divided only by
	// itself and 1
	// 2, 3, 5, 7, 11, 13
	public boolean isPrime(int number) {
		if (number <= 1) { // edge case
			return false;
		}
		
		for (int i = 2; i < number; i++) {
			if (number % i == 0) {
				return false;
			}
		}
		
		return true;
	}
	
}
