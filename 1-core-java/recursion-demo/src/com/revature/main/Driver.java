package com.revature.main;

import java.util.HashMap;

public class Driver {

	private static HashMap<Long, Long> previouslyCalculatedResults = new HashMap<>();
	
	public static void main(String[] args) {
		
		// 0 1 2 3 4 5
		// 1 1 2 3 5 8
		
		System.out.println(getNthFib(0));
		System.out.println(getNthFib(1));
		System.out.println(getNthFib(2));
		System.out.println(getNthFib(3));
		System.out.println(getNthFib(4));
		System.out.println(getNthFib(5));
		
//		System.out.println("Super slow...");
//		System.out.println(getNthFib(46));
		
		System.out.println("Super fast!!!");
		System.out.println(getNthFibMemoize(1000));
	}
	
	// O(2^n)
	public static long getNthFib(long n) {
		if (n <= 1) {
			return 1; // base case
		}
		
		return getNthFib(n - 1) + getNthFib(n - 2); // We are making progress towards the base case
	}
	
	// O(n)
	public static long getNthFibMemoize(long n) {
		// Memoization is all about storing previous calculations so you don't need to do them again
		previouslyCalculatedResults.put(0L, 1L);
		previouslyCalculatedResults.put(1L, 1L);
		
		if (previouslyCalculatedResults.containsKey(n)) {
			return previouslyCalculatedResults.get(n);
		}
		
		previouslyCalculatedResults.put(n, getNthFibMemoize(n - 1) + getNthFibMemoize(n - 2));
		return previouslyCalculatedResults.get(n);
	}

}
