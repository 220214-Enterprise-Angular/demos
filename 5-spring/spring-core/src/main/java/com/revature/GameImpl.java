package com.revature;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GameImpl implements Game{

	// == constants ==
	private static final Logger log = LoggerFactory.getLogger(GameImpl.class);

	// == fields ==
	private NumberGenerator numberGenerator; 
	// We will use the Spring Application Context to tell Spring Core (IoC container)
	// how to inkject objects into other objects

	private int guessCount = 10;
	private int number;
	private int guess;
	private int smallest;
	private int biggest;
	private int remainingGuesses;
	private boolean validNumberRange = true;

	@Override
	public void reset() {
		smallest = 0;
		guess = 0;
		remainingGuesses = guessCount;
		biggest = numberGenerator.getMaxNumber();
		number = numberGenerator.next();
		log.debug("the number is {}", number); // the {} are a place holder for the value of the second parameter
	}

	@Override
	public int getNumber() {
		return number;
	}

	@Override
	public int getGuess() {
		return guess;
	}

	@Override
	public void setGuess(int guess) {
		this.guess = guess;
	}

	@Override
	public int getSmallest() {
		return smallest;
	}

	@Override
	public int getBiggest() {
		return biggest;
	}

	@Override
	public int getRemainingGuesses() {
		return remainingGuesses;
	}

	@Override
	public void check() { // checks the user's answer

		checkValidNumberRange();

		if (validNumberRange) {
			if (guess > number) {
				biggest = guess - 1;
			}

			if (guess < number) {
				smallest = guess + 1;
			}
		}

		remainingGuesses--;
	}

	@Override
	public boolean isValidNumberRange() {
		return validNumberRange;
	}

	@Override
	public boolean isGameWon() {
		return guess == number;
	}

	@Override
	public boolean isGameLost() {
		return !isGameWon() && remainingGuesses <= 0;
	}

	// == private methods ==
	private void checkValidNumberRange() {
		validNumberRange = (guess >= smallest) && (guess <= biggest);
	}

}
