package com.restfulwebservices.resfulservices.helloworld;

import com.fasterxml.jackson.annotation.JsonProperty;

public class hello_world {

@JsonProperty("na name")	
private String message;

public hello_world(String message) {
	 
	this.message = message;
}

public String getMessage() {
	return message;
}

public void setMessage(String message) {
	this.message = message;
}

@Override
public String toString() {
	return "hello_world [message =" + message + "]";
}

}
