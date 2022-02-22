package com.revature.main;

public class Driver {

	public static void main(String[] args) {
		
		MyArrayList<Integer> myInts = new MyArrayList<>();
		
		myInts.add(12);
		myInts.add(13);
		myInts.add(-10);
		
		MyArrayList<String> myStrings = new MyArrayList<>();
		
		myStrings.add("Hello");
		myStrings.add("testing");

		
		for (int i = 0; i < myInts.size(); i++) {
			System.out.println(myInts.get(i));
		}
		
		for (int i = 0; i < myStrings.size(); i++) {
			System.out.println(myStrings.get(i));
		}
		
	}

}
