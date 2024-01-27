package com.restfulwebservices.resfulservices.versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VersioningPerson {

//versioning is like choosing which type of output to visible by user, so developer don't have to change whole structure every time
	
//	1st method using uri.using different uri's
	@GetMapping("/v1/person")
	private person persionV1() {
		return new person("vinay");
	}
	
	@GetMapping("/v2/person")
	private personV2 persionV2() {
		return new personV2(new Name("vinay", "kumar"));
	}
	
//	2nd method using params. eg: localhost:8080/person?version1
	 @GetMapping(path="/person", params= "version1")
	private person personUsingParams() {
		return new person("params vinay");
	}
	 
	 @GetMapping(path= "person", params= "version2")
		private personV2 persionUsingParams2() {
			return new personV2(new Name("p vinay", "p kumar"));
		}
	 // 3rd method using header. its like a key- value pair. Eg: header is the URI and 1 is the value
	 
	 @GetMapping(path= "/person", headers= "URI=1")
	 private person personUsingHeader() {
			return new person("header vinay");
		}
		 
	 @GetMapping(path= "person",  headers= "URI=2")
		private personV2 persionUsingHeader2() {
			return new personV2(new Name("H vinay", "H kumar"));
		}
	 
	 // 4th method using media type versioning aka. accept header
	 
	 @GetMapping(path= "/person",  produces= "application/v1+json")
	 private person personUsingAcceptHeader() {
			return new person("produce vinay");
		}	
	
	 @GetMapping(path= "person",   produces= "application/v2+json")
		private personV2 persionUsingAcceptHeader2() {
			return new personV2(new Name("He vinay", "He kumar"));
		}
	
}
