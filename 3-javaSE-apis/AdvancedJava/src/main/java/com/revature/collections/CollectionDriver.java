package com.revature.collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.Vector;

public class CollectionDriver {
	
	public static void main(String[] args) {
		/*
		 * List
		 * 
		 * A List is an ordered Collection (sometimes called a sequence). Lists may
		 * contain duplicate elements. In addition to the operations inherited from
		 * Collection, the List interface includes operations for the following:
		 * 
		 * + Positional access — manipulates elements based on their numerical position
		 * in the list. This includes methods such as get, set, add, addAll, and remove.
		 * 
		 * + Search — searches for a specified object in the list and returns its
		 * numerical position. Search methods include indexOf and lastIndexOf.
		 * 
		 * + Iteration — extends Iterator semantics to take advantage of the list's
		 * sequential nature. The listIterator methods provide this behavior.
		 * 
		 * + Range-view — The sublist method performs arbitrary range operations on the
		 * list.
		 * 
		 * The Java platform contains two general-purpose List implementations.
		 * ArrayList, which performs well when adding or removing from the collection
		 * frequently. A LinkedList which offers better performance when the collection
		 * will be accessed frequently (get and set methods).
		 */

		List<Animal> animalList = new ArrayList<Animal>();

		Animal a1 = new Animal("Dog", 12); // we have no way of defining whether a1 and a3 are the same
		Animal a2 = new Animal("Tiger", 4);
		Animal a3 = new Animal("Dog", 12);

		System.out.println("We have NOT overridden the equals() method...testing .equals().... " + a1.equals(a3));
		System.out.println(a1 == a2);

		animalList.add(a1);
		animalList.add(a2);
		animalList.add(a3);

		for (Animal a : animalList) {

			System.out.println(a.hashCode()); // after we override the hashCode(), it will determine that a1 and a3 are
												// indeed duplicates
		}

		/**
		 * Iterator enables you to cycle through a collection, obtaining or removing
		 * elements. ListIterator extends Iterator to allow bidirectional traversal of a
		 * list, and the modification of elements.
		 * 
		 * Before you can access a collection through an iterator, you must obtain one.
		 * Each of the collection classes provides an iterator( ) method that returns an
		 * iterator to the start of the collection. By using this iterator object, you
		 * can access each element in the collection, one element at a time.
		 */
		System.out.print("Original contents of animalList: ");
		Iterator itr = animalList.iterator();

		while (itr.hasNext()) {
			Object element = itr.next();
			System.out.print(element + " ");
		}

		/*
		 * Vector differs from ArrayList in 2 ways:
		 * 
		 * - Data Growth: A vector will double in size when it expands. (Whereas an
		 * ArrayList increases by 50%)
		 * 
		 * - Synchronization: It's slower because it blocks multiple threads from using
		 * it at once. (locking). - If you're dealing with a multi-threaded program, and
		 * multiple threads are accessing one List, - you want to make sure it's a
		 * Vector.
		 */
		List<Integer> numbers = new Vector<Integer>();

		numbers.add(3);
		numbers.add(74);
		numbers.add(-9000);

		System.out.println(numbers);

		/*
		 * Set
		 * 
		 * A Set is a Collection that cannot contain duplicate elements. It models the
		 * mathematical set abstraction. The Set interface contains only methods
		 * inherited from Collection and adds the restriction that duplicate elements
		 * are prohibited.
		 * 
		 * Set also adds a stronger contract on the behavior of the equals and hashCode
		 * operations, allowing Set instances to be compared meaningfully even if their
		 * implementation types differ. Two Set instances are equal if they contain the
		 * same elements.
		 */
		System.out.println("==================== SETS BELOW =========================");

		Set<Animal> animalSet = new LinkedHashSet<Animal>(); // linkedHashset

		animalSet.add(a1); // this is the same as a3
		animalSet.add(a2);
		animalSet.add(a3); // the compiler won't complain but the set isn't going to do it

		for (Animal a : animalSet) {

			System.out.println(a);

		}

		/*
		 * Queue
		 * 
		 * A collection designed for holding elements prior to processing.
		 * 
		 * Besides basic Collection operations, queues provide additional insertion,
		 * extraction, and inspection operations. Each of these methods exists in two
		 * forms: one throws an exception if the operation fails, the other returns a
		 * special value (either null or false, depending on the operation). The latter
		 * form of the insert operation is designed specifically for use with
		 * capacity-restricted Queue implementations; in most implementations, insert
		 * operations cannot fail.
		 * 
		 * For the most part, queues maintain a first-in, first-out order (FIFO). One
		 * exception to this rule is the PriorityQueue implementation, which order
		 * elements according to a supplied comparator, or the elements' natural
		 * ordering.
		 */
		Queue<Animal> animalQ = new LinkedList<>();
		// In a Queue you can store duplicate values.
		// This is a special linkedList with specific Queue operability

		System.out.println("============= Queues! ");

		// You can add duplicates in a Queue!!
		animalQ.add(a1);
		animalQ.add(a2);
		animalQ.add(a3);

		while (animalQ.size() != 0) {

			System.out.println("Queue size: " + animalQ.size());
			System.out.println("Processing... " + animalQ.poll()); // poll() removes the head of the queue
		}	
		
		/*
		 * Collections Utility Class (different from Collection Interface...)
		 * 
		 * This class consists exclusively of static methods that operate on or return
		 * collections. It contains polymorphic algorithms that operate on collections,
		 * "wrappers", which return a new collection backed by a specified collection,
		 * and a few other odds and ends.
		 */

		// Arrays is the Utility class for arrays
		int[] nums = {8, 322, 767, 1, 12};
		Arrays.sort(nums); // utility class
		System.out.println(Arrays.toString(nums)); // sorted in ascending order
		
		numbers.add(12);
		numbers.add(7654);
		Collections.sort(numbers);
		System.out.println(numbers);
		
		animalList.add(new Animal("Aardvark", 1));
		animalList.add(new Animal("Zebra", 72));
		
		
		Collections.sort(animalList);  // sorts by compareTo()....
		Collections.sort(animalList, new SpeciesSorter()); // sorts by alternative sorting class 
		
		System.out.println(animalList);
		
		
	}

}
