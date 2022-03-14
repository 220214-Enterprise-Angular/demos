package com.revature;

import java.util.Random;

import org.springframework.stereotype.Component;

/**
 * This class' job is to provide the implementation of the methods
 * defined in the Number Generator interface.
 */

@Component("myNumGenerator")
public class NumberGeneratorImpl implements NumberGenerator{

	// == fields ==
	private final Random random = new Random(); // object that creates a random number
	private final int maxNumber = 100; // max number for setting a range
	
	
	// == public methods ==
	@Override
	public int next() {
		
		return random.nextInt(maxNumber); // returns an int between 0 and the upperBound (maxNumber)
	}

	@Override
	public int getMaxNumber() {
		return this.maxNumber;
	}

}
