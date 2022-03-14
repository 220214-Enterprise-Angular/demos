package com.revature;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;


public class MessageGeneratorImpl implements MessageGenerator{

	// == constants == (static fields)
	private static final Logger log = LoggerFactory.getLogger(MessageGeneratorImpl.class);
	
	
	// == fields == (pertaining to the obj)
	// we need to create a Game class, then inject it into this class
	
	@Autowired // we will ensure that we can automatically inject some implementation of the Game interface 
			   // into an instance of this class
	private Game game;
	
	@Override
	public String getMainMessage() {
		
		return "Number is between " + game.getSmallest() + " and " + game.getBiggest() + ". Can you guess it?";
			// the number is between ___ and ___
	}

	@Override
	public String getResultMessage() {
		
		if (game.isGameWon()) {
			return "You guessed it! The number was " + game.getNumber();
			
		} else {
			return "You didn't guess it";
		}
		
	}

}
