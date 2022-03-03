package com.revature.models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity // comes from JPA specification
@Table(name="supervillains")
public class SuperVillain {
	// getter, setters, hashcode, equals, 3 constructors
	
	@Id // this represents Primary Key keyword
	@GeneratedValue(strategy=GenerationType.IDENTITY) // serial keyword
	@Column(name="svill_id")
	private int svillId;
	
	@Column(unique=true, nullable=false)
	private String name;
	
	private String superpower;
	
	private double bounty;
	
	// this relationship will best be described by a joins table which hibernate will automatically create for us
	@ManyToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	List<Crime> crimes; // the data won't be loaded into memory until we call getCrimes()

	// many to one relationship between supervillains and prisons
	@ManyToOne(cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	@JoinColumn(name="prison_fk") // instead of making SuperPrison objects available in this column, set it to Foreign KEY
	private SuperPrison superPrisonHolder; // where the SuperVillain is locked up
	
	
	// 3 constructors - no args constructor 
	public SuperVillain() {
		
	}

	// full-args constructor
	public SuperVillain(int svillId, String name, String superpower, double bounty, List<Crime> crimes,
			SuperPrison superPrisonHolder) {
		super();
		this.svillId = svillId;
		this.name = name;
		this.superpower = superpower;
		this.bounty = bounty;
		this.crimes = crimes;
		this.superPrisonHolder = superPrisonHolder;
	}

	// no-id constructor
	public SuperVillain(String name, String superpower, double bounty, List<Crime> crimes,
			SuperPrison superPrisonHolder) {
		super();
		this.name = name;
		this.superpower = superpower;
		this.bounty = bounty;
		this.crimes = crimes;
		this.superPrisonHolder = superPrisonHolder;
	}

	public int getSvillId() {
		return svillId;
	}

	public void setSvillId(int svillId) {
		this.svillId = svillId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSuperpower() {
		return superpower;
	}

	public void setSuperpower(String superpower) {
		this.superpower = superpower;
	}

	public double getBounty() {
		return bounty;
	}

	public void setBounty(double bounty) {
		this.bounty = bounty;
	}

	public List<Crime> getCrimes() {
		return crimes;
	}

	public void setCrimes(List<Crime> crimes) {
		this.crimes = crimes;
	}

	public SuperPrison getSuperPrisonHolder() {
		return superPrisonHolder;
	}

	public void setSuperPrisonHolder(SuperPrison superPrisonHolder) {
		this.superPrisonHolder = superPrisonHolder;
	}

	@Override
	public String toString() {
		return "SuperVillain [svillId=" + svillId + ", name=" + name + ", superpower=" + superpower + ", bounty="
				+ bounty + ", crimes=" + crimes + ", superPrisonHolder=" + superPrisonHolder + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(bounty);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((crimes == null) ? 0 : crimes.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((superPrisonHolder == null) ? 0 : superPrisonHolder.hashCode());
		result = prime * result + ((superpower == null) ? 0 : superpower.hashCode());
		result = prime * result + svillId;
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
		SuperVillain other = (SuperVillain) obj;
		if (Double.doubleToLongBits(bounty) != Double.doubleToLongBits(other.bounty))
			return false;
		if (crimes == null) {
			if (other.crimes != null)
				return false;
		} else if (!crimes.equals(other.crimes))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (superPrisonHolder == null) {
			if (other.superPrisonHolder != null)
				return false;
		} else if (!superPrisonHolder.equals(other.superPrisonHolder))
			return false;
		if (superpower == null) {
			if (other.superpower != null)
				return false;
		} else if (!superpower.equals(other.superpower))
			return false;
		if (svillId != other.svillId)
			return false;
		return true;
	}
	
	
	
	
	
	
}
