package com.revature.main;

import com.revature.anotherpackage.B;

public class Driver {

	public static void main(String[] args) {
		A a = new A();
		
		// System.out.println(a.w); 
		// can't do this because w is private
		
		System.out.println(a.x); // x default
		// works because we're in the same package
		
		System.out.println(a.y); // protected
		// works because we're in the same package
		
		System.out.println(a.z); // public
		// works because public is accessible from
		// anywhere
		
		
		//
		// System.out.println(A.a); // private
		System.out.println(A.b); // default
		System.out.println(A.c); // protected
		System.out.println(A.d); // public
		
		/*
		 * 
		 */
		B b = new B();
		
		System.out.println(b.z);
		
		System.out.println(b.d);
		

	}

}
