package com.jpa.demojpahypernate.course.jpa;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

//to map sql colmns to Course java bean. this using entity mapping is only used in jpa not jdbc
@Entity       // you can use @Entity(name="SQLTABLE_NAME") TO map sql table with our class name and since in this both are same we are not using
public class Course {

	public Course() {
		
	}
	//you can use @Id(name="colimn_name") to map sql column to our variable.. in this case both are same so we are not using
	@Id
	private int id;
	
	//you can use @Column(name="colimn_name") to map sql column to our variable.. in this case both are same so we are not using
	private String name;
	//you can use @Column(name="colimn_name") to map sql column to our variable.. in this case both are same so we are not using
	private String author;
	public Course(int id, String name, String author) {
		super();
		this.id = id;
		this.name = name;
		this.author = author;
	}
	
	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public String getAuthor() {
		return author;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	@Override
	public String toString() {
		return "Course [id=" + id + ", name=" + name + ", author=" + author + "]";
	}
	
	
 }
