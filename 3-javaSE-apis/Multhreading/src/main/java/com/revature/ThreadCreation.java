package com.revature;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadCreation {
	
	/*
	 * =================================================================
	 * ====== THERE ARE THREE MAIN WAYS TO CREATE THREADS ================
	 * =================================================================
	 * 
	 * 		(1) Implement Runnable interface and pass it to a new Thread object's constructor
	 * 
	 * 		(2) Extend Thread class, and create an object of that class. 
	 * 
	 * 		(3) Execute tasks asynchronously with an ExecutorService (it's similar to a thread pool)
	 * 
	 * ================== Both are equal! ====================
	 */
	
	public static void main(String[] args) {
		
		// this is being run by the main thread
		System.out.println("Main thread starting");
		
		
		// we instnatiate and start this thread WITHIN the main() method
		// of the main thread....
		Thread t1 = new Thread(new Runnable() {

			public void run() {
				System.out.println("Thread 1 is running!");
			}
		});
		
		// run method is defined by the lambda expression
		Thread lambdaThread = new Thread(() -> System.out.println("running from the lambda thread"));
		
		t1.start(); // it's task is defined in the run() method
		
		lambdaThread.start();
		
		try { // we're saying please wait for the t1 thread to complete 
			t1.join(); // the main thread is invoking this method 
		} catch (InterruptedException e) {
			System.out.println("Thread interrupted, couldn't wait for t1");
		}
	
		MyThread t3 = new MyThread();
		t3.setName("My Special thread");
		t3.setPriority(Thread.MAX_PRIORITY); // we can ensure that this thread has the maximum priority in the context of this app
		
		t3.start(); 
		
		// comes from java.util.concurrent package
		ExecutorService executorService = Executors.newSingleThreadExecutor();
		executorService.execute(new Runnable() {
			// Creates a thread
			// allows us to implement the thread's run method
			// then it starts the thread (invoked the run() method on that thread)
			@Override
			public void run() {
				System.out.println("Executing from the executor service");	
			}
		});
		// we only complete this step from the main thread when t1 thread is done
		System.out.println("Main thread exiting...");	
		
		/**
		 * Thread Life Cycle
		 * - New - when its created
		 * - Runnable phase - when the run() method has been implemented
		 * - Active (Running)  phase - when its start() method has been invoked
		 * - Non-Runnable (Blocked) - when another thread is interfering with the thread and inhibiting its run() method
		 * - Terminated thread - the thread is done with its task - YOU CANNOT REVIVE A DEAD THREAD 
		 */
		
		
	}
}

class MyThread extends Thread {
	
	public void run() {
		System.out.println("Hello from " + this.getName());
		
	}
}







