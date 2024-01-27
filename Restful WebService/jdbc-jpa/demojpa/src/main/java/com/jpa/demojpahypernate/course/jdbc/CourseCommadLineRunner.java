package com.jpa.demojpahypernate.course.jdbc;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.jpa.demojpahypernate.course.jpa.Course;
import com.jpa.demojpahypernate.course.jpa.CourseJpaRepository;
import com.jpa.demojpahypernate.course.springdatajpa.SpringDataJpaRepository;

 

@Component
public class CourseCommadLineRunner implements CommandLineRunner{

//	@Autowired
//	private CourseJdbcRepository repository;
//	@Autowired
//	private CourseJpaRepository repository;
//	@Override
//	public void run(String... args) throws Exception {
//		repository.insert();
//		
//	}
	
//	@Override
//	public void run(String... args) throws Exception {
//		repository.insert(new Course(15, "my 1st query", "I'm vinay1" ));
//		repository.insert(new Course(16, "my 2nd query", "I'm vinay2" ));
//		repository.insert(new Course(17, "my 3rd query", "I'm vinay3" ));
//		
//		repository.delete( 15);
//		repository.delete( 17);
//		
//		System.out.println(repository.select(16));
//		
//	}
	
	//jpa has less code(direct mapping table attributes to entities(varaibles)) jdbc(queries) and  SpringDatajpa has less code than jpa
	@Autowired
	private SpringDataJpaRepository repository;

@Override
public void run(String... args) throws Exception {
	repository.save(new Course(15, "my 1st query", "I'm vinay1" )); //SpringDataJpa uses save() instead of insert for updation or insertion
	repository.save(new Course(16, "my 2nd query", "I'm vinay2" ));
	repository.save(new Course(17, "my 3rd query", "I'm vinay3" ));
	
	repository.deleteById(16);  //InBuild method
	
	System.out.println(repository.findById(15)); //Inbuild method by SpringDataJpa
	System.out.println(repository.findAll());
	System.out.println(repository.count());
	
	System.out.println(repository.findByName("my 3rd query")); //i created this method in SprigDataJpaRepository interface
}
	
	
	

	
}
