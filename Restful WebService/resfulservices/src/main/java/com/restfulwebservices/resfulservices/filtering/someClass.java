package com.restfulwebservices.resfulservices.filtering;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

//you can use @JsonIgnore for unwanted variables or you can use @JsonIgnoreProperties at class level 
//@JsonIgnoreProperties({"lastName" , "secondName"}) for more variables

//@JsonIgnoreProperties("lastName")
@JsonFilter("JacksonValueFilter")
public class someClass {

	private String firstName;
	
	//if we does't want to show in output we use @JsonIgnore
//	@JsonIgnore
	private String secondName;
	private String lastName;
	
	
	public someClass(String firstName, String secondName, String lastName) {
		super();
		this.firstName = firstName;
		this.secondName = secondName;
		this.lastName = lastName;
	}
	public String getFirstName() {
		return firstName;
	}
	public String getSecondName() {
		return secondName;
	}
	public String getLastName() {
		return lastName;
	}
	@Override
	public String toString() {
		return "someclass [firstName=" + firstName + ", secondName=" + secondName + ", lastName=" + lastName + "]";
	}
	
	
}
