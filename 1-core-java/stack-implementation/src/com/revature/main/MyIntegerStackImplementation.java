package com.revature.main;

// Implement a stack that will store Integer wrapper objects
// Utilize an Array behind the scenes
// Support the following operations:
// 1. push(element): add an element to the top of the stack
// 2. element pop(): remove an element from the top of the stack

// Take into account that you may run out of room in your array, just like for an Array List
// In that case, think about creating a new array that is 2 times larger, so that you can continue
// pushing elements onto the stack
public class MyIntegerStackImplementation {

	private int arrSize = 4;
	private Integer[] myArr = new Integer[this.arrSize];
	private int numOfElements = 0;
	
	public Integer pop() {
		Integer returnValue = this.myArr[this.numOfElements - 1];
		this.myArr[this.numOfElements - 1] = null;
		this.numOfElements = this.numOfElements - 1;
		return returnValue;
	}
	
	public void push(Integer a) {
		if (this.numOfElements == this.myArr.length) {
			this.arrSize = 2 * this.arrSize;
			
			Integer[] temp = new Integer[this.arrSize];
			for (int i = 0; i < this.numOfElements; i++) {
				temp[i] = this.myArr[i];
			}
			
			this.myArr = temp;
		}
		
		this.myArr[numOfElements] = a;
		this.numOfElements = this.numOfElements + 1;
	}
	
	// return true if the stack contains the element
	// return false if the stack does not
	public boolean contains(Integer a) {
		// linear search
		for (int i = 0; i < this.numOfElements; i++) {
			if (this.myArr[i].equals(a)) {
				return true;
			}
		}
		
		return false;
	}
	
	public boolean isEmpty() {
		return this.numOfElements == 0;
	}
	
	public int size() {
		return this.numOfElements;
	}
	
}
