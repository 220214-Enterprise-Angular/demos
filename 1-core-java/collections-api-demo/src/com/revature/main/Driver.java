package com.revature.main;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.Vector;

public class Driver {

	public static void main(String[] args) {
		
		// List example
		// <> is a generic (diamond operator)
		// Generics: parameterized types
		List<Person> people = new ArrayList<>(); // Putting <Person> is optional on the right side
		// because it is already implied on the left side
		
		people.add(new Person("Bach", 24));
		people.add(new Person("John", 30));
		
		// Iterate using a regular for loop
		for (int i = 0; i < people.size(); i++) {
			System.out.println(people.get(i));
		}
		
		// a List is an Iterable, therefore we can utilize an for-each loop
		for (Person p : people) {
			System.out.println(p);
			System.out.println(p.hashCode());
		}
		
		// LinkedList
		List<Person> people2 = new LinkedList<>();
		people2.add(new Person("Jill", 20));
		people2.add(new Person("Jane", 34));
		
		for (Person p : people2) {
			System.out.println(p);
		}
		
		// Vector
		//
		// Data growth: a vector doubles in size whenever it is full, while an ArrayList
		// 	increases by 50% (instead of 100%)
		//
		// Vector is synchronized, so it is thread-safe (but slower)
		List<Person> people3 = new Vector<>();
		people3.add(new Person("Bob", 50));
		people3.add(new Person("Jimmy", 25));
		
		for (Person p : people3) {
			System.out.println(p);
		}
		
		/*
		 * Set: a collection that cannot contain duplicate elements
		 * 	You also cannot access elements via an index
		 * 	One of the main functions of a Set is to check if an element already
		 *  exists in the set
		 *  
		 *  O(1) time to check if an element already exists in the set
		 */
		Set<Person> people4 = new HashSet<>();
		
		System.out.println(people4.add(new Person("Bob", 50))); // true
		System.out.println(people4.add(new Person("Bob", 51))); // true
		System.out.println(people4.add(new Person("Bob", 50))); // false
		
		System.out.println("people4 contains a Person with firstName Bob and age 50: " 
				+ people4.contains(new Person("Bob", 50)));
		
		/*
		 * Queue: FIFO
		 * 
		 * v Stack: LIFO
		 */
		Queue<Person> lunchLine = new LinkedList<>();
		// lunchLine.get(0) // even though lunchLine is referencing a LinkedList, you cannot
		// use .get, because .get is not a defined method for the Queue abstract datatype
		lunchLine.add(new Person("Marshall", 23));
		lunchLine.add(new Person("Cody", 20));
		
		while (lunchLine.size() != 0) {
			System.out.println(lunchLine.remove());
		}
		
		/*
		 * Collections class
		 * 
		 * Is NOT part of any hierarchy (only inherits from Object class)
		 * 
		 * It simply contains useful STATIC methods
		 * 
		 * It is a UTILITY class
		 */
		List<String> fruits = new ArrayList<>();
		fruits.add("Pear");
		fruits.add("Apple");
		fruits.add("Banana");
		fruits.add("Orange");
		
		System.out.println("BEFORE: " + fruits);
		
		Collections.sort(fruits);
		
		System.out.println("AFTER: " + fruits);
		
		System.out.println(Collections.binarySearch(fruits, "Orange"));
	}

}
