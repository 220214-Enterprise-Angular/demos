package com.revature;


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
public class ProducerConsumer {

	public static void main(String[] args) {
		
		Holder data = new Holder();
		int numOfValuesToGenerate = 10;
		
		// create 2 threads:
		Thread producerThread = new Thread(new Producer(data, numOfValuesToGenerate));
		Thread consumerThread = new Thread(new Consumer(data, numOfValuesToGenerate));
		
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

// this is the object that both threads will access
class Holder {
	
	int contents = 0; 
	boolean avail = false;
	
	// will be called by the Consumer Thread
	// Any thread that accesses a synchronized method obtains a lock
	// when entering the method. Only one thread at a time can access a method that's 
	// marked as synchronized. So, that opens up the ability to SIGNAL to other threads,
	// when they can use the method
	public synchronized int getVal() {
		
		try { // adding an extra second to allow the producer to fully complete before the consumer calls the getVal() method
			// shout out to Antonio
			Thread.sleep(5);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		while (avail == false) {
			
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}	
		}
		
		avail = false;
		notifyAll();
		return contents; // return the value of the contents of the Holder object
	}
	
	// this method will be called by the Producer Thread
	public synchronized void setVal(int val) {
		try {
			Thread.sleep(5);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		while (avail == true) {
			
			try {
				wait(); // frozen until the Consumer Thread calls notifyAll();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		contents = val;
		avail = true;
		notifyAll(); // notifyAll() , wait() notify(), all belong to the Object class
	}
}

// copy paste the Producer and Consumer classes
class Producer implements Runnable {
	public Holder data;
	int max;

	public Producer(Holder data, int max) {
		this.data = data;
		this.max = max;
	}

	@Override
	public void run() {
		for (int i = 0; i < max; i++) {
			// loop and set values
			this.data.setVal(i);
			System.out.println("Producer put: " + i);
		}
	}
}

class Consumer implements Runnable {

	public Holder data;
	int max;

	public Consumer(Holder data, int max) {
		this.data = data;
		this.max = max;
	}

	@Override
	public void run() {
		for (int i = 0; i < max; i++) {
			// loop and retrieve values
			int currentVal = this.data.getVal();
			System.out.println("Consumer got: " + currentVal);
		}
	}
}



























