package com.revature.main;

import com.revature.model.Person;

public class Main {

	public static void main(String[] args) {
		
		Person p = new Person("Bach", "Tran", 23);
		
		System.out.println(p.getFirstName());
		System.out.println(p.getLastName());
		System.out.println(p.getAge());
		
		p.setAge(24);
		System.out.println("============");
		
		System.out.println(p.getFirstName());
		System.out.println(p.getLastName());
		System.out.println(p.getAge());

	}

}
