package com.revature;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MessageGeneratorImpl implements MessageGenerator{

	// == constants == (static fields)
	private static final Logger log = LoggerFactory.getLogger(MessageGeneratorImpl.class);
	
	
	// == fields == (pertaining to the obj)
	// we need to create a Game class, then inject it into this class
	private Game game;
	
	@Override
	public String getMainMessage() {
		return null; // the number is between ___ and ___
	}

	@Override
	public String getResultMessage() {
		// TODO Auto-generated method stub
		return null;
	}

}
