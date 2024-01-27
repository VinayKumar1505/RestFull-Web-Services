package com.restfulwebservices.resfulservices.user;

 
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class UserDaoService {

	private List<user> users= new ArrayList<>();
	int idCount= 0;
	
	 public UserDaoService() {
		users.add(new user(++idCount, "vinay",  20));
		users.add(new user(++idCount, "kumar", 25));
	 }
	
	public List<user> findAll(){
		return users;
	}
	
	public user findOne(int id) {
		
		for(user num: users) {
			if(num.getId()==id) {
				return num;
			}
		}
		return null;
	}
	
public void deleteById(int id) {
		
		for(user num: users) {
			if(num.getId()==id) {
				users.remove(num);
			}
		}
		 
	}

	public user save(user num) {
		num.setId(++idCount);
		users.add(num);
		return num;
	}
}
