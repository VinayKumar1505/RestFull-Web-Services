package com.jpa.demojpahypernate.course.springdatajpa;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jpa.demojpahypernate.course.jpa.Course;

public interface SpringDataJpaRepository extends JpaRepository<Course, Integer>{ //No need to create Jpa repository just create an interface extend JpaRepository to access all inbuild methods

	List<Course> findByName(String name); //custom methodsi.e.. we can create any
	
}
