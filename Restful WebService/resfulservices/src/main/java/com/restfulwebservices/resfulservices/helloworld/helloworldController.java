package com.restfulwebservices.resfulservices.helloworld;

import java.util.Locale;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class helloworldController {

private MessageSource messageSource;

public helloworldController(MessageSource messageSource) {
	this.messageSource= messageSource;
}
 
 
@GetMapping( "/sayhello")
public String write() {
		 return "hello world";
	}

@GetMapping( "/sayhello/bean")
public hello_world writebean() {
		 return new hello_world("hello world bean");
	}

@GetMapping( "/sayhello/{tellname}")
public hello_world writebean(@PathVariable String tellname) {
		 return new hello_world(String.format("Hello world, %s", tellname ));
	}

@GetMapping( "/Internationlization")
public String writeInternationlization() {
   
	Locale locale= LocaleContextHolder.getLocale();
	return  messageSource.getMessage("good.morning", null, "This is Default message", locale);
//	return "hello world ";
	}
	
}
