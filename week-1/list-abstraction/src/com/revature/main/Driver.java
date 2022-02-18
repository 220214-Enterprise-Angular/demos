package com.revature.main;

public class Driver {

	public static void main(String[] args) {
		MyIntegerList myLinkedList = new MyIntegerLinkedList();
		
		myLinkedList.add(10);
		myLinkedList.add(20);
		myLinkedList.add(-100);
		
		MyIntegerList myArrayList = new MyIntegerArrayList();
		myArrayList.add(-1);
		myArrayList.add(19);
		myArrayList.add(30);
		
		System.out.println(linearSearch(myLinkedList, 20));
		System.out.println(linearSearch(myArrayList, 30));
	}
	
	// MyIntegerList is an abstract data type that can be used to reference
	// MyIntegerArrayList objects AND MyIntegerLinkedList objects
	// The important thing to note is that the MyIntegerList abstract data type
	// exposes the add, get, and size methods that would allow us to perform a linear search
	public static int linearSearch(MyIntegerList arr, Integer element) {
		for (int i = 0; i < arr.size(); i++) {
			if (arr.get(i).equals(element)) {
				return i;
			}
		}
		
		return -1;
	}
	
}
