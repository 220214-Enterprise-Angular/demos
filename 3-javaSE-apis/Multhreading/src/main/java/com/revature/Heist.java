package com.revature;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Heist {
	
	public static final int MAX_PASSWORD = 9999;
	
	public static void main(String[] args) {
		
		// the action begins here
		// 1. Generate a random number to pass as the password for the Vault's constructor
		Random random = new Random();
		int password = random.nextInt(MAX_PASSWORD); // generates a random number between 0 - 9999;
		
		System.out.println("The password is " + password);
		
		// 2. Instantiate a Vault
		Vault vault = new Vault(password);
		
		// 3. instantiate our 3 threads: 2 hackers, 1 cop
		// only objects of classes that extend Thread can be added to this list
		List<Thread> threads = new ArrayList<Thread>(); 
		
		// add an instance of each thread (desc. hacker, asc. Hacker, policeman thread to the list
		DescendingHackerThread descHacker = new DescendingHackerThread(vault);
		AscendingHackerThread ascHacker = new AscendingHackerThread(vault);
		PolicemanThread policemanThread = new PolicemanThread();
		
		threads.add(descHacker); // I'm instantiating AND adding it to the list at the same time
		threads.add(ascHacker);
		threads.add(policemanThread);
		
		// 4. for each thread, run the start() method 
		threads.forEach(t -> t.start());

	}
	
	// this is a STATIC class that that it can be instantiated in the main() method of the enclosing class
	private static class Vault {
		
		private int password;
		
		// every time we instantiate a Vault we want to set its password to some random number between 0 and the max_password
		
		public Vault(int password) {
			this.password = password;
		}
		
		// method that the hacker threads will call
		public boolean isCorrectPassword(int guess) {
			
			// put the sleep the thread that calls this method for a brief period to 
			// extend the amount of time that passes in the game
				try {
					Thread.sleep(5);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			
			return guess == this.password; // true or false?
		}
		
	}
	
	private static abstract class HackerThread extends Thread {
		
		// every Hacker gets Vault that they're attacking
		protected Vault vault;
		
		// this constructor will be inherited by the Desc and Asc Hacker Sub Classes...
		public HackerThread(Vault vault) {
			this.vault = vault;
			this.setName(this.getClass().getSimpleName());
			this.setPriority(Thread.MAX_PRIORITY);
		}
		
		@Override
		public void start() {
			System.out.println("Starting Thread: " + this.getName()); 
			super.start(); // see which thread has been started when we call .start()	
		}
	}
	
	// TODO: Create a DescendingHackerThread and an AscendingHackerThread that extend the HackerThread class
	private static class DescendingHackerThread extends HackerThread {

		public DescendingHackerThread(Vault vault) { // any objects that are instantiated from this class
			super(vault);							 // will be threads and will max priority and will have
			  										 // their thread names set to DescendingHackerThread
		}
		
		@Override
		public void run() {
			// goal: iterate from the MAX_PASSWORD to 0 and call the vault object's isCorrectPassword
			// to check if it got it right with every iteration
			for (int guess=MAX_PASSWORD; guess>=0; guess--) {
				
				if (vault.isCorrectPassword(guess)) {
					System.out.println(this.getName() + " guessed the password! The password was " + guess);
					System.exit(0); // stops the java app and exits with a status code that no issues occurred
				}		
			}
		}
	}
	
	private static class AscendingHackerThread extends HackerThread {

		public AscendingHackerThread(Vault vault) {
			super(vault);
			// TODO Auto-generated constructor stub
		}
		
		@Override
		public void run() { 
			for (int guess=0; guess<=MAX_PASSWORD; guess++) {
				
				if (vault.isCorrectPassword(guess)) {
					System.out.println(this.getName() + " guessed the password! The password was " + guess);
					System.exit(0); // stops the java app and exits with a status code that no issues occurred
				}		
			}
		}	
	}
	
	// The only job of this thread is to count down from 10
	private static class PolicemanThread extends Thread {
		
		@Override
		public void run() { // this fires when we run policeManThread.start();
			
			for (int i=15; i > 0; i--) {
				
				try {
					Thread.sleep(1000); // sleep for 1 second in between iterations
				} catch (InterruptedException e) {
					e.printStackTrace();
				} 
				// pint out how many seconds left
				System.out.println(i + " seconds left");
			}
			// after the for loop ends, tell the hackers that it's game over
			System.out.println("Game over for you, hackers!");
			
			System.exit(0); // end the program
		}
	}
}
