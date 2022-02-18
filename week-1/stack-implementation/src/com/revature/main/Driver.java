package com.revature.main;

public class Driver {

	public static void main(String[] args) {
		MyIntegerStackImplementation stack1 = new MyIntegerStackImplementation();
		
		MyIntegerStackImplementation stack2 = new MyIntegerStackImplementation();

		stack1.push(10);
		stack1.push(20);
		stack1.push(30);
		stack1.push(40);
		stack1.push(50);
		
		stack2.push(15);
		stack2.push(234);
		stack2.push(12);
		stack2.push(5);
		stack2.push(60);
		
		System.out.println(stack1.contains(30));
		System.out.println(stack2.contains(234));
		System.out.println(stack2.contains(-100));
		
		// Stack is LIFO
		while (!stack1.isEmpty()) {
			System.out.println(stack1.pop());
		}
		
		while (!stack2.isEmpty()) {
			System.out.println(stack2.pop());
		}
		
	}

}
