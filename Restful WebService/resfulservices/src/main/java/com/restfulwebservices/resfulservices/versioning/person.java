package com.restfulwebservices.resfulservices.versioning;

public class person {

	private String person;

	public person(String person) {
		super();
		this.person = person;
	}

	@Override
	public String toString() {
		return "person [person=" + person + "]";
	}

	public String getPerson() {
		return person;
	}
	
	
}
