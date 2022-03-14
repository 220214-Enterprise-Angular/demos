package com.revature;

import org.slf4j.Logger; // here we import the FACADE, not the logging framework itself
import org.slf4j.LoggerFactory;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
	
	// since we want to log everything that happens in this class, we'll declare a logger
	private static final Logger log = LoggerFactory.getLogger(App.class);
	private static final String CONFIG_LOCATION = "beans.xml";
	
	public static void main(String[] args) {
		
		log.info("Starting the application...");
		
		// configure an application context: global information about who depends on who (beans)
		ConfigurableApplicationContext context = new ClassPathXmlApplicationContext(CONFIG_LOCATION);
		
		// instantiate the necessary Objects (spring beans = objects managed by Spring's IoC container)
		NumberGenerator numberGen = context.getBean("myNumGenerator", NumberGenerator.class);
		// above we're grabbing the bean that implements the sepcified interface (as second param)
		
		// get the bean that implements this interface
		Game game = context.getBean(Game.class); // we don't always need to specifiy the ID
		
		// previously we would instantitae the GameImpl class by passing through the instantiated
		// objects that it depends on
//		Game someGame = new GameImpl(new NumberGeneratorImpl numGen);
//		
		// play the game! - call some methods on a game object 
		
		// call next() on the game bean since it's fully assembled and instantiated
		int number = numberGen.next();
		
		log.info("The number is {}", number);
		
		game.reset(); // this will print out the number that was passed to it by the number generator
		
		number = game.getNumber(); // fetches the new number generated after the reset
		
		log.info("The NEW number is {}", number);
	
		log.info("Ending application");
	}

}
