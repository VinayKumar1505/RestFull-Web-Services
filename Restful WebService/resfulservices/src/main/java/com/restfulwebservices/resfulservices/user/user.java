package com.restfulwebservices.resfulservices.user;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Size;

@Entity(name= "user_details")
public class user {
   
	@Id
	@GeneratedValue
	private int id;
   
   @Size(min= 2, message= "minimum 2 characters undal ra!")
   private String name;
   
   @Max(value= 20, message= "minimum 20 years undal ra bacha!")
   private int age;
public user(int id, String name, int age) {
	super();
	this.id = id;
	this.name = name;
	this.age = age;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public int getAge() {
	return age;
}
@Override
public String toString() {
	return "user [id=" + id + ", name=" + name + ", age=" + age + "]";
}
public void setDate(int  age) {
	this.age = age;
}
   
   
   
}
