package com.revature.main;

public class MyArrayList<E> {

	private E[] arr;
	private int numOfElements; // default value of 0
	private int capacity;
	
	public MyArrayList() {
		this.capacity = 4;
		this.arr = (E[]) new Object[this.capacity];
	}
	
	// Constructor overloading
	public MyArrayList(int initialCapacity) {
		if (initialCapacity <= 0) {
			throw new IllegalStateException("Initial Capacity must be at least 1");
		}
		
		this.capacity = initialCapacity;
		this.arr = (E[]) new Object[this.capacity];
	}
	
	/*
	 * Behaviors
	 */
	
	// O(1) amortized time
	public void add(E element) {
		// Check if numberOfElements is the same as capacity
		// If it is, then it means that our array is full, and we need to create a new one
		if (this.numOfElements == this.capacity) {
			E[] temp = (E[]) new Object[this.capacity * 2];
			this.capacity = this.capacity * 2;
			
			for (int i = 0; i < this.numOfElements; i++) {
				temp[i] = this.arr[i];
			}
			
			this.arr = temp;
		}
				
		this.arr[numOfElements] = element;
		numOfElements++;
	}
	
	public E get(int index) {
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
