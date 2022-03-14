package com.revature;

public interface Game {

    int getNumber();

    int getGuess();

    void setGuess(int guess);

    int getSmallest();

    int getBiggest();

    int getRemainingGuesses();

    void reset(); // reset the number by calling next() on the Random obj

    void check();

    boolean isValidNumberRange();

    boolean isGameWon();

    boolean isGameLost();

}
