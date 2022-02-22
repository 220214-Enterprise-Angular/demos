package com.revature.main;

import java.util.ArrayList;

public class Driver {

	public static void main(String[] args) {
		
		// 8 primitives
		// byte
		// short
		// char
		// int
		// long
		// float
		// double
		// boolean
		
		// We also have the ability to represent a primitive as an object
		// The reason we might want to do this has to do with "generics" (another concept to be covered 
		// in the future)
		// Generics are useful in creating generalized classes that can take different "types"
		// For example, ArrayList and other collections built into Java
		
		/*
		 * A Wrapper class is a class that corresponds to a primitive type
		 * 
		 * It is used to represent primitives as objects instead
		 * 
		 * This is useful, because the data structures within the Collections Framework (included with 
		 * the Java runtime library) can only deal with objects (because they are generalized for many different
		 * types of data using generics, and generics can only leverage non-primitive types)
		 * 
		 * Important points to know:
		 * 1. Autoboxing
		 * 2. Unboxing
		 * 3. Why wrapper classes exist
		 */
		
		// Byte class
		// Short class
		// Character class
		// Integer class
		// Long class
		// Float class
		// Double class
		// Boolean class
		
		// Autoboxing and unboxing
		// Autoboxing: The process of automatically creating a wrapper object based on a primitive value
		// Unboxing: The process of unpacking a wrapper object into its corresponding primitive
		
		Byte b = 10; // autoboxing
		Integer i = 10000; // autoboxing
		Integer i2 = 20000;
		
		System.out.println(i + i2); // Integer + Integer -> unboxing -> int + int = int
		
		Integer i3 = 5000; // autoboxing (new Integer(...))
		Integer i4 = 5000; // autoboxing (new Integer(...))
		
		// i3 and i4 are both reference variables
		// In other words, their values are the memory addresses of the objects they are referring to
		// They are pointing to 2 different objects, and therefore, i3 == i4 will be false
		System.out.println("i3 == i4: " + (i3 == i4));
		
		/*
		 * If you have 2 reference variables, and you use == operator, then if they are pointing to
		 * 2 different objects, it will evaluate to false
		 */
		
		// .equals() is a method that can be used for comparing the internal values of 2 objects
		System.out.println("i3.equals(i4): " + i3.equals(i4)); // both objects have the same internal value
		
		/*
		 * The wrapper classes contain a lot of useful static methods that you can utilize
		 * They also contain various constants defined statically
		 */
		System.out.println(Integer.MIN_VALUE);
		System.out.println(Integer.MAX_VALUE);
		
		// There are also methods to convert a String into its corresponding primitive value
		int age = Integer.parseInt("75"); // take the string "75" and give an int 75
		
		// Collections such as ArrayList can only deal with non-primitive types
		// for example, cannot store int primitives, only Integer objects
		ArrayList<Integer> myInts = new ArrayList<>();
		myInts.add(10);
		myInts.add(1000);
	}

}
