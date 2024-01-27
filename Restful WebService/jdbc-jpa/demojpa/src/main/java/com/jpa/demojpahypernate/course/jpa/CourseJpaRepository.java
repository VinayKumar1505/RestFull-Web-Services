package com.jpa.demojpahypernate.course.jpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@Repository //when ever a class is to make a contact with database we use @Repository
@Transactional //when working with jpa @Transaction annotation is used
public class CourseJpaRepository {

	@Autowired //@PersistenceContext can also be used similar to @Autowired
	private EntityManager entityMan;
	
	//we are executing methods using jpa as we executed using Jdbc
	public void insert(Course course) {
		entityMan.merge(course);
	}
	
	public Course select(int id) {
		return entityMan.find(Course.class, id);
	}
	
	public void delete(int id) {
		Course course= entityMan.find(Course.class, id);
		entityMan.remove(course);
	}
}
