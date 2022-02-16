package com.revature.main;

public class Driver {

	public static void main(String[] args) {
		
		
		MyIntegerArrayList myList = new MyIntegerArrayList(2);
		
		myList.add(10);
		myList.add(12);
		myList.add(13);
		myList.add(14);
		
		myList.add(-10);
		
		System.out.println(myList.get(0));
		System.out.println(myList.get(1));
		System.out.println(myList.get(2));
		System.out.println(myList.get(3));
		System.out.println(myList.get(4));
		
		System.out.println(myList);
	}

}
