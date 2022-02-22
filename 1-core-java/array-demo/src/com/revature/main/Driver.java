package com.revature.main;

public class Driver {

	private static int someStaticField; // 0
	private static String someStaticStringField; // null
	private static boolean someStaticBooleanField; // false
	
	public static void main(String[] args) {
		
		// Create an array of doubles
		// of size 5
		// "square brackets" []
		// "curly braces" {}
		double[] bob = new double[5];
		
		// default value for numbers is 0 or 0.0
		// default value for boolean is false
		// default value for reference types is null
		
		// String[] strings = new String[10];
		
		
		// iterating over this array,
		for (int i = 0; i < bob.length; i++) {
			System.out.println(bob[i]);
		}
		
		bob[0] = 15.5;
		bob[1] = 10.2;
		bob[2] = 10.0;
		bob[3] = 5.3434;
		bob[4] = 5.3243423423432;

		for (int i = 0; i < bob.length; i++) {
			System.out.println(bob[i]);
		}
		
		// for-each loop (or enhanced for loop)
		for (double element : bob) {
			System.out.println(element);
		}
		
		// Other syntax for instantiating arrays (arrays are objects stored in the heap)
		double[] myDoubles = { 34.3, 43.4, 0.0, 23.1 }; // size is 4 for this array
		
		// SIZES CANNOT BE changed. If you want a larger array, then you need to 
		// create a brand new array (and copy the elements from the old array over
		// to the new array if you want to continue expanding)
		// Sneak Peak: This is what an ArrayList does behind the scenes
		
		// Challenge: implement an ArrayList (research about what a List is)
		
		/*
		 * Multi-dimensional Arrays
		 * 
		 * You can have arrays within arrays. That's what a multidimensional array is
		 */
		int[][] my2DArray = new int[2][3]; // 2 rows x 3 columns
		my2DArray[0][0] = 10;
		my2DArray[0][1] = 15;
		my2DArray[0][2] = -10;
		my2DArray[1][0] = 34;
		my2DArray[1][1] = 100;
		my2DArray[1][2] = -3;
		
		// iterate over 2D array
		// Use 2 for loops
		for (int i = 0; i < my2DArray.length; i++) { // my2DArray.length = # of rows
			for (int j = 0; j < my2DArray[i].length; j++) {
				System.out.println(my2DArray[i][j]);
			}
		}
		
		// enhanced for loop
		for (int[] row : my2DArray) {
			for (int element : row) {
				System.out.println(element);
			}
		}
		
		// var-args
		double result = sum(10.5, 3.14, 2.3, 5, 10, 2.5);
		System.out.println("result: " + result);
	}
	
	// ... signifies "variable-arguments"
	// We can pass in any number of doubles into this method when we are invoking it
	public static double sum(double... numbers) {
		// the type of the numbers parameter is
		// double[]
		// It is a reference variable to a double array
		// it is not a primitive variable
		
		double sum = 0;
		for (int i = 0; i < numbers.length; i++) {
			sum = sum + numbers[i];
		}
		
		return sum;
	}

}
