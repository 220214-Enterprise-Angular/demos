package com.revature.model;

public class Animal {
	
	// Properties
	protected String favoriteFood;
	protected String noise;
	protected int numOfLegs;
	protected boolean isDeceased;
	
	/*
	 * In general, it's a good idea to have 2 different constructors
	 * 1. No-args constructor
	 * 2. Parameterized constructor
	 */
	public Animal() {
		super();
	}
	
	public Animal(String favoriteFood, String noise, int numOfLegs, boolean isDeceased) {
		this.favoriteFood = favoriteFood;
		this.noise = noise;
		this.numOfLegs = numOfLegs;
		this.isDeceased = isDeceased;
	}
	
	// Behaviors
	public void makeNoise() {
		System.out.println(noise);
	}
	
	public void sleep() {
		System.out.println("Animal is sleeping");
	}
	
	public void eat() {
		System.out.println("Animal is eating " + favoriteFood);
	}
	
	/*
	 * Getters/setters
	 */

	public String getFavoriteFood() {
		return favoriteFood;
	}

	public void setFavoriteFood(String favoriteFood) {
		this.favoriteFood = favoriteFood;
	}

	public String getNoise() {
		return noise;
	}

	public void setNoise(String noise) {
		this.noise = noise;
	}

	public int getNumOfLegs() {
		return numOfLegs;
	}

	public void setNumOfLegs(int numOfLegs) {
		this.numOfLegs = numOfLegs;
	}

	public boolean isDeceased() {
		return isDeceased;
	}

	public void setDeceased(boolean isDeceased) {
		this.isDeceased = isDeceased;
	}
	
}
