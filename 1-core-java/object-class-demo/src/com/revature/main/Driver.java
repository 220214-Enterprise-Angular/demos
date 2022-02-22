package com.revature.main;

import java.util.HashMap;

import com.revature.model.Person;

public class Driver {

	public static void main(String[] args) {
		
		Person p = new Person("Bach", "Tran", 24);
		
		String stringRepresentation = p.toString();
		System.out.println("stringRepresentation: " + stringRepresentation);
		
		System.out.println(p);
		
		Person p2 = new Person("Bach", "Tran", 24);
		
		System.out.println("p == p2: " + (p == p2));
		System.out.println("p.equals(p2): " + (p.equals(p2)));
		
		// If you don't override the .equals() method, it behaves exactly the same as ==
		// That is the default behavior as it is defined in the object class

		
		/*
		 * HashCode is used in HashMaps
		 */
		HashMap<String, String> words = new HashMap<>();
		words.put("dog", "a four legged animal descended from wolves");
		words.put("cat", "a four legged animal that is descended from big cats");
		
		String catDefinition = words.get("cat"); // O(1), regardless of how big the HashMap is
		System.out.println(catDefinition);
		
	}

}
