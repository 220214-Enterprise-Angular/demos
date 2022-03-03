package com.revature;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Producer COnsumer Problem: 
 * When 2 therads are accessing the same Queue (some object) and the producer
 * must set the value which the consumer will then consume.
 * 
 * This involves careful synchronization and COMMUNICATION between 2 threads ,
 * so that the producer doens't OVER producer and the consumer doesn't OVER consume.
 *
 * A thread is an independent path of execution in a program.
 *
 */
public class BlockingQueuePCProblem {

	public static void main(String[] args) {
		
		BlockingQueue data = new LinkedBlockingQueue();
		int numOfValuesToGenerate = 10;
		
		// create 2 threads:
		Thread producerThread = new Thread(new Producer2(data, numOfValuesToGenerate));
		Thread consumerThread = new Thread(new Consumer2(data, numOfValuesToGenerate));
		
		System.out.println("Starting Threads...");
		
		producerThread.start();
		consumerThread.start();
		
		
		try {
			producerThread.join();
			consumerThread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	

	}

}

// copy paste the Producer and Consumer classes
class Producer2 implements Runnable {
	
	int max;
	
	private final BlockingQueue sharedQueue;

	public Producer2(BlockingQueue sharedQueue, int max) {
		this.sharedQueue = sharedQueue;
		this.max = max;
	}

	@Override
	public void run() {
		for (int i = 0; i < max; i++) {
			// loop and set values
			try {
				this.sharedQueue.put(i);
				System.out.println("Producer put: " + i);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}
}

class Consumer2 implements Runnable {

	// this is the Holder class but comes from the java.util.concurrent package which ensures that its put and take()
	// methods are synchronized and wiat() and notify the other threads that would accessing the same object
	private final BlockingQueue sharedQueue;
	int max;

	public Consumer2(BlockingQueue sharedQueue, int max) {
		this.sharedQueue = sharedQueue;
		this.max = max;
	}

	@Override
	public void run() {
		
		while(true) {
			// loop and retrieve values forever, unless blocked
		
			try {
				 System.out.println("consumed " + this.sharedQueue.take());
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
