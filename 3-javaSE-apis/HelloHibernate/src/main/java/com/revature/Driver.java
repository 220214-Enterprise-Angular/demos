package com.revature;

import java.util.ArrayList;
import java.util.List;

import com.revature.dao.CrimeDao;
import com.revature.dao.SuperPrisonDao;
import com.revature.dao.SuperVillainDao;
import com.revature.models.Crime;
import com.revature.models.SuperPrison;
import com.revature.models.SuperVillain;

public class Driver {

	static CrimeDao cdao = new CrimeDao();
	static SuperPrisonDao spdao = new SuperPrisonDao();
	static SuperVillainDao svdao = new SuperVillainDao();
	
	
	public static void main(String[] args) {
		
		System.out.println("Running Hibernate Demo");
		
		Crime c1 = new Crime("Freezey power", "covering the city in ice");
		Crime c2 = new Crime("Time Manipulation", "freezin' time, robbin' banks");
		Crime c3 = new Crime("Arson", "setting the city ablaze");
		
		cdao.insert(c1);
		cdao.insert(c2);
		cdao.insert(c3);
		
		// create a list of crimes
		List<Crime> crimes = new ArrayList<Crime>();
		
		// add the crimes to the list
		crimes.add(c1);
		crimes.add(c2);
		crimes.add(c3);
		
		// create a prison
		SuperPrison arkham = new SuperPrison("Arkham Asylum", "Gotham City"); // change the constructor to allow us to enter without super villa
		
		
		// create supervilllain
		SuperVillain joker = new SuperVillain("The Joker", "evilness", 1_000_000.05, crimes, arkham);
		
		
		// add both the superprison and the villain to the database
		spdao.insert(arkham);
		
		svdao.insert(joker);
		
		
	}

}
