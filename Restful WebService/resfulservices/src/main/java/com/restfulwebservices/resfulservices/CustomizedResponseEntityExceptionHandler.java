package com.restfulwebservices.resfulservices;

import java.time.LocalDate;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.restfulwebservices.resfulservices.exception.ErrorDetails;
import com.restfulwebservices.resfulservices.exception.UserNotFoundException;

@ControllerAdvice
public class CustomizedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler{

	
	@ExceptionHandler(Exception.class)
	public final ResponseEntity<ErrorDetails> handleAllException(Exception ex, WebRequest request) throws Exception {

	ErrorDetails detail= new ErrorDetails(LocalDate.now(), ex.getMessage(), request.getDescription(false));
	
	return new ResponseEntity<ErrorDetails>(detail, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(UserNotFoundException.class)
	public final ResponseEntity<ErrorDetails> handleUserNotFoundException(Exception ex, WebRequest request) throws Exception {

	ErrorDetails detail= new ErrorDetails(LocalDate.now(), ex.getMessage(), request.getDescription(false));
	
	return new ResponseEntity<ErrorDetails>(detail, HttpStatus.NOT_FOUND);
	}
	
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(
			MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {

		ErrorDetails detail= new ErrorDetails(LocalDate.now(), "rey total errors:"+ ex.getErrorCount()+ "  mari first emo: "+ ex.getFieldError().getDefaultMessage(), request.getDescription(false));
		
		return new ResponseEntity<>(detail, HttpStatus.BAD_REQUEST);
}
}