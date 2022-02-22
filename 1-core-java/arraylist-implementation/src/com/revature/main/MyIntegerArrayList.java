package com.revature.main;

public class MyIntegerArrayList {

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
