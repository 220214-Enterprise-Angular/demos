package com.revature.main;

public class Driver {

	public static void main(String[] args) {
		Person p1 = new Person("Bach", "Tran", 100);
		Person p2 = new Person("Billy", "Jones", 50);
		
		System.out.println(Person.numOfInstances);
		
		System.out.println(p1.firstName);
		System.out.println(p1.lastName);
		System.out.println(p1.age);
		
		System.out.println(p2.firstName);
		System.out.println(p2.lastName);
		System.out.println(p2.age);
		
		p2.firstName = "Bill";
		
		System.out.println(p1.firstName);
		System.out.println(p1.lastName);
		System.out.println(p1.age);
		
		System.out.println(p2.firstName);
		System.out.println(p2.lastName);
		System.out.println(p2.age);
		
	}

}
