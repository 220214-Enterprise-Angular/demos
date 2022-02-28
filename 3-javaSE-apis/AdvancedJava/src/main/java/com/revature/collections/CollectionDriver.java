package com.revature.collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.Vector;

public class CollectionDriver {
	
	public static void main(String[] args) {
		// type main + ctrl + space
		
		/**
		 * List
		 */
		
		// instantitating an empty arraylist
		List<Integer> numbers = new ArrayList<Integer>();
		
		numbers.add(42); // automatically, the primitive value 42 is autoboxed to become an Integer Object
		
		System.out.println(numbers);
		
		// let's create an ArrayList of custom types 
		Animal a1 =  new Animal("Dog", 12); // because we have NOT overridden the hashCode and equals
		Animal a2 =  new Animal("Tiger", 4); // we have no way of checking whether a1 & a3 are equal
		Animal a3 =  new Animal("Dog", 12);
		
		// Lists can store duplicate values -- SETS don't store duplciate values
		// Lists maintain insertion order -- SETS don't maintain insertion order (Unless you use a LinkedHashSet)
		
		System.out.println("Is a1 == to a3?" + (a1 == a3)); // == points to addres in memory
		System.out.println(a1.equals(a3)); // equal in value because overrode the hascode and equals
		
		// add the animals to the list
		List<Animal> animals = new ArrayList<Animal>();
		animals.add(a1);
		animals.add(a2);
		animals.add(a3);
		
		// iterate over the list and print each objects hashcode
		for (Animal a : animals) {
			System.out.println(a.hashCode()); 
			
		}
		
		System.out.println("Iterating over list with iterator");
		Iterator itr = animals.iterator(); // Only implementation classes of an interface that extends 
										   // Collection has the iterator() method
		
		while (itr.hasNext()) {
			Object element = itr.next();
			System.out.println(element.hashCode());
		}
		
		System.out.println("======EQUALITY=======");
		
		// do 2 animal objects with the SAME properties equal
		// eachother in value?
		System.out.println(a1.equals(a3));
		
		System.out.println("A1's hashcode:" + a1.hashCode());
		System.out.println("A3's hashcode:" + a3.hashCode());
		
		
		/**
		 * A Vector differs from an ArrayLit in 2 ways:
		 * 
		 * - Synchronization - it's operations are slower because it blocks multiple threads from using it at once.
		 * - Data growth - a vector will oduble in size when it expands, whereas an arraylist increases by 50%.
		 * 
		 */
		
		List<Integer> threadSafeNums = new Vector<Integer>();
		
		threadSafeNums.add(76);
		threadSafeNums.add(84);
		
		
		// LinkedLists are better for insertions & deletion, arraylists are optimal for retireval (O(1)
		
		// SETS - don't allow duplicates
		// they maintain a strong contract with the hashCode() method
		Set<Animal> animalSet = new HashSet<Animal>();
		// add all the animals to the set
		
		animalSet.add(a1); // a1 and a3 have the same properties
		animalSet.add(a2);
		animalSet.add(a3); // when we add a3 it violates the no-dup rule
		animalSet.add(new Animal("Elephant", 7));
		
		// iterate over each object in the set and print them out
		
		for (Animal a : animalSet) {
			System.out.println(a.getSpecies() + ": " +a.hashCode());
			
		}
		
		System.out.println("Do a1 and a3 share the same memory address? : " + (a1 == a3));
		
		/**
		 * Queues
		 * 
		 * A Queue is a collection designed for holding elements prior to processing.
		 * Queues follow a FIFO structure (first in, first out) 
		 * 
		 */
		
		Queue<Animal> animalQ = new LinkedList<Animal>();

		System.out.println("====== queues!-=======");
		animalQ.add(a1);
		animalQ.add(a2);
		animalQ.add(a3); // queues can store duplicates
		
		// Queue interface gives us a few methods suchs as poll() - poll removes the head of the queue from the structure and returns it
		while (animalQ.size() != 0) {
			
			System.out.println("Animal Q's size is " + animalQ.size());
			System.out.println("Processing... " + animalQ.poll());

		}
		
		System.out.println("Finished processing the animal queue");
 		
		// Collections Utility Class
		int[] nums = {8, 322, 767, 1, 12};
		Arrays.sort(nums); // utility class
		System.out.println(Arrays.toString(nums)); // sorted in ascending order
		
		numbers.add(12);
		numbers.add(7654);
		Collections.sort(numbers);
		System.out.println(numbers);
		
		animals.add(new Animal("Aardvark", 1));
		animals.add(new Animal("Zebra", 72));
		
		// compare -- we need to make our custom class comparable so it can be sorted
//		Collections.sort(animals);  // sorts by compareTo()....
		Collections.sort(animals, new SpeciesSorter());
		
		System.out.println(animals);
		
		
	}

	
	
	
}
