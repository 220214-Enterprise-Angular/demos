package com.revature.collections;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class WildCardDriver {
	
	
	public static void main(String[] args) {
		
		
		List<Integer> list1 = new LinkedList<Integer>();
		list1.add(21);
		list1.add(22);
		
		
		List<Animal> list2 = Arrays.asList(new Animal("Platypus", 10), new Animal("Eagle", 8));
		
		// we want to be able to pass boths lists to our printList method
		printList(list2);
		
		// Why is this thropwing a compiler error
		double result = add(list1);
		
		System.out.println(result);
		
		List<Animal> cats = new LinkedList<>();
		cats.add(new Cat("Very Fluffy Species", 4));
		
		 addCatToList(cats);
		
		
	}	
	
	// Upper Bounded Wildcard
	// create a method that only works on lists that hold number type doubles, integers, longs...but no Animal
	private static double add(List<? extends Number> list) {
		
		// add all the values and return the sum
		double sum = 0;
		
		for (Number n : list) {
			sum += n.doubleValue();
		}
		return sum;
	}

	
	
	// take in a list as a parameter
	// I can print the value of ANY type of element stored inside of a list
	private static void printList(List<?> list) { // this is an UNBOUNDED WILDCARD

		// print each element of the lists
		for (Object o : list) {
			System.out.println(o);
		}
	}
	
	// Lower Bounded Wildcard 
	// Allows use to operate on a list of an object type that extends animal
	private static void addCatToList(List<? super Animal> list) {
		
		list.add(new Cat("Domestic Shorthair", 11));
		System.out.println(list);
	
	}
	
	

}

class Cat extends Animal {

	public Cat(String species, int age) {
		super(species, age);
	}

}







