package com.restfulwebservices.resfulservices.filtering;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;

@RestController
public class filteringController  {
	
	//static filtering.
    @GetMapping("/filtering")
	private someClass filter() {
		return  new someClass("vinay", "kumar", "annoju");
	}
        
    
    //Don't panic, just printing as list
    @GetMapping("/filtering-List")
	private List<someClass> filterList() {
		return   Arrays.asList(new someClass("vinay", "kumar", "annoju"), 
				new someClass("vinay1", "kumar1", "annoju1"));
	}
	
	//Dynamic filtering.
	@GetMapping("/filtering1")
   	private MappingJacksonValue filterDynamic() {
   		someClass myBean=  new someClass("vinay", "kumar", "annoju");
   		
   		MappingJacksonValue JacksonValue= new MappingJacksonValue(myBean);
   		
   		//prints only firstName and lastName
   		SimpleBeanPropertyFilter simpleFilter= SimpleBeanPropertyFilter.filterOutAllExcept("firstName", "lastName");
   		
		FilterProvider myFilters = new SimpleFilterProvider().addFilter("JacksonValueFilter", simpleFilter);
		
		JacksonValue.setFilters(myFilters);
   		
   		return JacksonValue;
   	}
	
	 @GetMapping("/filtering-List1")
		private MappingJacksonValue filterListDynamic() {
			List<someClass> myBean=   Arrays.asList(new someClass("vinay", "kumar", "annoju"), 
					new someClass("vinay1", "kumar1", "annoju1"));
			
			MappingJacksonValue JacksonValue= new MappingJacksonValue(myBean);
	   		
	   		//prints only firstName and lastName
	   		SimpleBeanPropertyFilter simpleFilter= SimpleBeanPropertyFilter.filterOutAllExcept("firstName", "secondName");
	   		
			FilterProvider myFilters = new SimpleFilterProvider().addFilter("JacksonValueFilter", simpleFilter);
			
			JacksonValue.setFilters(myFilters);
	   		
	   		return JacksonValue;
			
			
		}
}
