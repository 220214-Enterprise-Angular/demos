package com.revature.main;

import java.util.Scanner;

public class Driver {

	private static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		System.out.println("Enter your age: ");
		
//		int age = sc.nextInt(); // nextLine returns a String
//		sc.nextLine();
		int age = Integer.parseInt(sc.nextLine());
		
		System.out.println("Enter your first name: ");
		
		String firstName = sc.nextLine();
		
		System.out.println("Enter your last name: ");
		
		String lastName = sc.nextLine();
		
		System.out.println("Hi, " + firstName + " " + lastName);

	}

}
