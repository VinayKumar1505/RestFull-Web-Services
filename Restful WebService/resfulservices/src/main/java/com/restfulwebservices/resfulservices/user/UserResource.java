package com.restfulwebservices.resfulservices.user;

import java.net.URI;
import java.util.List;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.restfulwebservices.resfulservices.exception.UserNotFoundException;

import jakarta.validation.Valid;

@RestController
public class UserResource {
	
	//method to access UserDaoService loose coupling
	private UserDaoService service;              
	
	public UserResource(UserDaoService service) {
		this.service= service;
	}
	
	@GetMapping("/users")
	public List<user> retriveAll(){
		return service.findAll();
	}

//this is another method but tight coupling
//	UserDaoService service1= new UserDaoService(); 
//	@GetMapping("/users")
//	public List<user> retrive(){
//		return service1.findAll();
//	}
	
	@GetMapping("/users/{id}")
	public user retriveOne(@PathVariable int id) {
		user vinay= service.findOne(id);
		
		if(vinay== null) {
			throw new UserNotFoundException("id:"+ id);
		}
		return vinay;
	}
	
	@GetMapping("/users1/{id}")
	public EntityModel<user> retriveOne1(@PathVariable int id) {
		user vinay= service.findOne(id);
		
		if(vinay== null) {
			throw new UserNotFoundException("id:"+ id);
		}
		
		EntityModel<user> entityModel= EntityModel.of(vinay);
		//to add the link in the output we use webMvcLinkBuilder
		
		WebMvcLinkBuilder myLink= linkTo(methodOn(this.getClass()).retriveAll());
		 
		entityModel.add(myLink.withRel("And-All-Users"));
		
		return entityModel;
	}
	
	
	
	@DeleteMapping("/users/{id}")
	public void deleteOne(@PathVariable int id) {
		service.deleteById(id);
	}
	
	
	@PostMapping("/user_post")
	public user posting(@RequestBody user num) {
		return service.save(num);
	}
	
	@PostMapping("/user_posting")
	public ResponseEntity<user> posting1(@RequestBody user num) {
		service.save(num);
		return ResponseEntity.created(null).build();
		
	}
	
	@PostMapping("/users")
	public ResponseEntity<user> posting2(@Valid @RequestBody user num) {
		user saveduser= service.save(num);
		URI location= ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(saveduser.getId()).toUri();
		return ResponseEntity.created(location).build();
		
	}
}
