package com.revature;

import java.util.Arrays;

public class Driver {

	public static void main(String[] args) {
		
		// Is Unique: Implement an algorithm to determine if a char array has all unique characters. 
		// What if you cannot use additional data structures?
		
		char[] chars = { 'a', 'z', 'e', 'f', 'e' };
		
		// bruteforce solution
		System.out.println(charactersAreUniqueBruteforce(chars));
		
		System.out.println(charactersAreUniqueWithoutAdditionalDS(chars));
		
		System.out.println(charactersAreUniqueOofN(chars));
	}
	
	// O(n)
	public static boolean charactersAreUniqueOofN(char[] c) {
		boolean[] characterEncountered = new boolean[128];
		
		for (char element : c) {
			if (characterEncountered[element]) return false;
			// if the element was set to true, you've already encountered this character, which means we need to
			// return false because not all characters are unique
			
			characterEncountered[element] = true; // if you encountered for the first time, then set it to true
		}
		
		return true;
	}
	
	
	// Sorting takes O(n log n) time, the for loop takes O(n) time
	// The overall performance of the algorithm is the larger of the two
	// Therefore, this is a O(n log n) algorithm
	public static boolean charactersAreUniqueWithoutAdditionalDS(char[] c) {
		// Sorting is the approach we can take
		// { 'a', 'z', 'e', 'f', 'e' }
		// { 'a', 'e', 'e', 'f', 'z' }
		
		Arrays.sort(c); // O(n log n) <- worse than O(n) but better than O(n^2)
		
		// Once you have sorted the characters in the Array
		// You only need a single for loop instead of 2 nested for loops
		// We hence reduce our time complexity to O(n) for loop
		
		// O(n)
		for (int i = 0; i < c.length - 1; i++) {
			if (c[i] == c[i+1]) return false;
		}
		
		return true;
		
	}
	
	// O(n^2)
	public static boolean charactersAreUniqueBruteforce(char[] c) {
		for (int i = 0; i < c.length - 1; i++) {
			for (int j = i + 1; j < c.length; j++) {
				if (c[i] == c[j]) return false;
			}
		}
		
		return true;
	}

}
