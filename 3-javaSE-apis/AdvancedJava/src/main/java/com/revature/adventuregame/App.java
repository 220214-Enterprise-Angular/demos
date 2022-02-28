package com.revature.adventuregame;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class App {

	// Create a HashMap of locations;
	
	private static Map<Integer, Location> locations = new HashMap<Integer, Location>();
	
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		// before we even prompt the user to go in a certain direction
		// we instantiate all Locations with their respective exits
		
		// the 1st location that we create will be homeBase
		Location homeBase = new Location(0, "You're sitting at a computer learning Java", null); // null because dosn't have exits map
		locations.put(0, homeBase);
		
		// create a tempExit which will be the exit passed into the loation contructor
		Map<String, Integer> tempExit = new HashMap<String, Integer>();
		// n -> 5, e -> 3, s -> 4, w -> 2
		tempExit.put("N", 5);
		tempExit.put("E", 3);
		tempExit.put("S", 4);
		tempExit.put("W", 2);
		
		Location road = new Location(1, "You're standing at the end of a road in front of a brick building", tempExit);
		// add the road to our locations map -> {1, road}
		locations.put(road.getLocationId(), road); // locationId is = 1;
		
		// set tempExit = a new HashMap that's empty
		tempExit = new HashMap<String, Integer>();
		// set the exits for the hill on the tempExit map
		tempExit.put("N", 5);
		// instantiate the hill location object
		Location hill = new Location(2, "You're ontop of a grassy hill with a dark forest to the north", tempExit);
		// put it into our locations Map
		locations.put(hill.getLocationId(), hill);
		
		
		tempExit = new HashMap<String, Integer>();
		tempExit.put("W", 1);
		locations.put(3, new Location(3, "You're in an old brick building", tempExit));

		tempExit = new HashMap<String, Integer>();
		tempExit.put("N", 1);
		tempExit.put("W", 2);
		locations.put(4, new Location(4, "You're standing in the middle of a big green valley", tempExit));
		
		tempExit = new HashMap<String, Integer>();
		tempExit.put("S", 1);
		tempExit.put("W", 2);
		locations.put(5, new Location(5, "You're in a dark forest", tempExit));
		
		
		int loc = 1;
		// game logic for getting user input
		while(true) {
			
			// print the current location's description
			System.out.println(locations.get(loc).getDescription());
			
			// if they go to location 0, we break the loop
			if (loc == 0) {
				break;
			}
			
			System.out.println("The available exits are:");
			
			// capture the exits, iterate through the keysets and print them out
			Map<String, Integer> exits = locations.get(loc).getExits();
			
			for (String exit : exits.keySet()) { // keys are "N", "E", "S", "W"...etc
				
				System.out.print(exit + ", ");
				
			}
			
			System.out.println("Where would you like to go?");
			
			// capture the input with the scanner and send it to upper case
			String direction = scan.next().toUpperCase();
			
			/**
			 * OPTIONAL - to make it a better game
			 * allow the user to write things like "run north" and
			 * make them change their location
			 * 
			 */

			if (exits.containsKey(direction)) {
				loc = exits.get(direction);
			} else {
				System.out.println("That's not a possible exit"); 
				// the loop will repeat if this is not a possible exit
			}
			
		}
		

	}

}
