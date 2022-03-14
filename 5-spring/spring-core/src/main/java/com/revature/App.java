package com.revature;

import org.slf4j.Logger; // here we import the FACADE, not the logging framework itself
import org.slf4j.LoggerFactory;

public class App {
	
	// since we want to log everything that happens in this class, we'll declare a logger
	private static final Logger log = LoggerFactory.getLogger(App.class);
	
	public static void main(String[] args) {
		
		log.info("Starting the application...");
		
		// configure an application context: global information about who depends on who
		
		// instantiate the necessary bjects (spring beans = objects managed by Spring's IoC container)
		
		// play the game! - call some methods on a game object 
		
		
		
		
	}

}
