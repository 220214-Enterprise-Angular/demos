package com.revature.collections;

import java.util.Comparator;

/**
 * 
 * A comparable object is an object capable of comparing itself with another object.
 * This class MUST implement the compareTo() method.
 * 
 * The implementation of the compareTO() method defines 
 * 
 *
 */
public class Animal implements Comparable<Animal>{
	
	private String species;
	private int age;
	
	public Animal(String species, int age) {
		super();
		this.species = species;
		this.age = age;
	}
	
	// this is where we indicate how to sort an Animal object
	@Override
	public int compareTo(Animal otherAnimal) {
		// TODO Auto-generated method stub
		return this.age - otherAnimal.getAge(); 
	}

	public String getSpecies() {
		return species;
	}

	public void setSpecies(String species) {
		this.species = species;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Animal [species=" + species + ", age=" + age + "]";
	}

	
	// generates a number representing the properties of an object
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + age;
		result = prime * result + ((species == null) ? 0 : species.hashCode());
		return result;
	}

	// if I override equals, we ensure that an animal obj
	// with the same properties as another animal obj
	// will return true if we do a1.equals(a2);
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Animal other = (Animal) obj;
		if (age != other.age)
			return false;
		if (species == null) {
			if (other.species != null)
				return false;
		} else if (!species.equals(other.species))
			return false;
		return true;
	}	
	
	
}

/**
 * Unlike Comparable, Comparator is external to the element type we are
 * comparing. It’s a separate class. We create multiple separate classes (that
 * implement Comparator) to compare by different members.
 * 
 * Collections class has a second sort() method and it takes Comparator. The
 * sort() method invokes the compare() to sort objects.
 */
class SpeciesSorter implements Comparator<Animal> {

	// Sort by Species, we're comparing the String value
	// does the type that we're comparing override the compareTo() method?
	@Override
	public int compare(Animal a1, Animal a2) {
		return a1.getSpecies().compareTo(a2.getSpecies());
	}	
}



