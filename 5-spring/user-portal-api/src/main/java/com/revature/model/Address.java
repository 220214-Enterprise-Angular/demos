package com.revature.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.ToString;

@Entity
@Table(name="addresses")
@Data @AllArgsConstructor @NoArgsConstructor
@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="id") 
// Jackson Databind is our object mapper, so we're telling Jackson that the id field of an object uniquely identifies
// an Address object
@EqualsAndHashCode(exclude={"owners"}) @ToString(exclude= {"owners"}) // prevents Hibernate from causing infinite loop
public class Address {
	
	@Id
	@Column(name="address_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	private String street; // 123 Pine St.
	private String secondary; // Apt. 2
	
	@Length(min=2, max=2)
	private String state; // restrict to 2 characters NJ
	
	private String city;
	private String zip;// 02011-452
	
	// many users can own many addresses - we will have to add an Address list in the User class
	@ManyToMany(mappedBy="addresses") // declare the owner of the relationship by mapping it to the property of the User class
	private @NonNull Set<User> owners;

	// this constructor has no id and no owners
	public Address(String street, String secondary, @Length(min = 2, max = 2) String state, String city, String zip) {
		super();
		this.street = street;
		this.secondary = secondary;
		this.state = state;
		this.city = city;
		this.zip = zip;
	}
	
	
	
	
	
}
