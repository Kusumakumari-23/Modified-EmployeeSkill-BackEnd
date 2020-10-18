package com.employee.demo.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.employee.demo.entity.ErrorMessage;

@ControllerAdvice
public class EmployeeExceptionHandler extends ResponseEntityExceptionHandler{

	@ExceptionHandler(value= {ResourceNotFoundException.class})
	public ResponseEntity<Object> handleResourceNotFoundException(ResourceNotFoundException ex, WebRequest request){
		
		ErrorMessage err = new ErrorMessage(ex.getMessage(), 404);
		
		return new ResponseEntity<>(err, new HttpHeaders(), HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(value= {EmployeeSkillInsertionException.class})
	public ResponseEntity<Object> handleEmployeeSkillInsertionException(EmployeeSkillInsertionException ex, WebRequest request){
		
		ErrorMessage err = new ErrorMessage(ex.getMessage(), 500);
		
		return new ResponseEntity<>(err, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
