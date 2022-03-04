package com.revature.models;

import java.io.Serializable;

import com.revature.annotations.Column;
import com.revature.annotations.Entity;
import com.revature.annotations.Id;

@Entity(tableName="other_table")
public class DummyOtherUser implements Serializable{ // for the purposes of making it a full java bean
	
	@Id(columnName="other_id")
	private int id;
	
	@Column(columnName="test_field")
	private String testField;
	

}
