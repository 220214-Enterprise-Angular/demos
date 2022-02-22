package com.revature.main;

// Inheritance: You can inherit directly from only 1 class, but you can inherit directly from multiple
// interfaces
// A class can implement AS many interfaces as it wants
// However, a class can extend ONLY 1 class
public class MyIntegerArrayList implements MyIntegerList {

	private Integer[] arr;
	private int numOfElements; // default value of 0
	private int capacity;
	
	public MyIntegerArrayList() {
		this.capacity = 4;
		this.arr = new Integer[this.capacity];
	}
	
	// Constructor overloading
	public MyIntegerArrayList(int initialCapacity) {
		if (initialCapacity <= 0) {
			throw new IllegalStateException("Initial Capacity must be at least 1");
		}
		
		this.capacity = initialCapacity;
		this.arr = new Integer[this.capacity];
	}
	
	/*
	 * Behaviors
	 */
	
	// O(1) amortized time
	public void add(Integer element) {
		// Check if numberOfElements is the same as capacity
		// If it is, then it means that our array is full, and we need to create a new one
		if (this.numOfElements == this.capacity) {
			Integer[] temp = new Integer[this.capacity * 2];
			this.capacity = this.capacity * 2;
			
			for (int i = 0; i < this.numOfElements; i++) {
				temp[i] = this.arr[i];
			}
			
			this.arr = temp;
		}
				
		this.arr[numOfElements] = element;
		numOfElements++;
	}
	
	public Integer get(int index) {
		if (index >= this.numOfElements) {
			throw new IndexOutOfBoundsException();
		}
		
		return this.arr[index];
	}
	
	public int size() {
		return this.numOfElements;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("[");
		
		for (int i = 0; i < this.numOfElements - 1; i++) {
			sb.append(this.arr[i] + ", ");
		}
		
		sb.append(this.arr[this.numOfElements - 1] + "]"); 
		
		return sb.toString();
	}
	
}
