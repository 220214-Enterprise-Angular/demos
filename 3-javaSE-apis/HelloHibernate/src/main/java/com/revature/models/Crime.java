package com.revature.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Crime model
 * SuperVillain model that has an associated list of crimee commited
 * SuperPrison model which has a list of super villains
 */

// JPA - Java Persistence  API - it allows a specification
// ORM will read the JPA annotations or set of instructions - implementing the specification
// Hibernate is the implementation of the specification

@Entity // import from javax.persistence
@Table(name="crimes") // if we didn't use this the name of the table would be the name of the class
public class Crime { // persistent entity - building a class for an object that we expect to be persisted with Hibernate

	@Id // this annotation means Primary Key
	@GeneratedValue(strategy=GenerationType.IDENTITY) // this is equivalent to the SERIAL key word
	private int crimeId; // we want this auto generated
	
	@Column(unique=true, nullable=false)
	private String crimeName; // Hibernate will automatically generate a column called "crime_name"
	
	// we'll keep this as it is, because Hibernate will automatically create a column with type varchar
	private String description;
	
	// 3 constructors: a no-args, one with an initialized id field, and one without
	public Crime() {
		
	}

	// 2 other constructors:  1 fully parameterized, another will all params, EXCEPT id
	public Crime(String crimeName, String description) {
		super();
		this.crimeName = crimeName;
		this.description = description;
	}

	public Crime(int crimeId, String crimeName, String description) {
		super();
		this.crimeId = crimeId;
		this.crimeName = crimeName;
		this.description = description;
	}

	public int getCrimeId() {
		return crimeId;
	}

	public void setCrimeId(int crimeId) {
		this.crimeId = crimeId;
	}

	public String getCrimeName() {
		return crimeName;
	}

	public void setCrimeName(String crimeName) {
		this.crimeName = crimeName;
	}

	public String getDescrition() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "Crime [crimeId=" + crimeId + ", crimeName=" + crimeName + ", description=" + description + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + crimeId;
		result = prime * result + ((crimeName == null) ? 0 : crimeName.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Crime other = (Crime) obj;
		if (crimeId != other.crimeId)
			return false;
		if (crimeName == null) {
			if (other.crimeName != null)
				return false;
		} else if (!crimeName.equals(other.crimeName))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		return true;
	}
	
}
