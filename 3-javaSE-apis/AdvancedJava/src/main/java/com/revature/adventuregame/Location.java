package com.revature.adventuregame;

import java.util.HashMap;
import java.util.Map;

/**
 * Location is a fully immutable class 
 * so that third-party plugins cannot modify
 * the location instances of the game maps.
 *
 */
public final class Location { // final classes can't be extended

	// why final? so we can't change the properties of a location after instantiation
	private final int locationId;
	private final String description;
	private final Map<String, Integer> exits;// {"S", 1} the key refers to the cardinal direction, the value is the locationId of the 
									   // location that exit goes to
	
	public Location(int locationId, String description, Map<String, Integer> exits) {
		
		this.locationId = locationId;
		this.description = description;
		
		// if exits is NOT null, set the exits property equal to the map that's passed through 
		if (exits != null) {
			this.exits = new HashMap<String, Integer>(exits); // make a duplicate HashMap with the values passed through
			
		} else {
			this.exits = new HashMap<String, Integer>();
		}
		
		// if a user is in any of our locations and presses Q for quit, it leads them to room 0 (exit)
		this.exits.put("Q", 0);
		
	}

	// we want to make sure that a COPY of the exits is returned when we call getExits()
	public Map<String, Integer> getExits() {
		
		// we're creating a copy of the references that point to the objects in the original map
		// but don't allow for them to be changed
		
		return new HashMap<String, Integer>(exits);
		// you don't want to return the real exits map because that would allow
		// the calling program to change the map's keys and values
	}
	
	
	
	// getters & setters for description, and locationId
	public int getLocationId() {
		return locationId;
	}

	public String getDescription() {
		return description;
	}
	

	
	
	
	
}
