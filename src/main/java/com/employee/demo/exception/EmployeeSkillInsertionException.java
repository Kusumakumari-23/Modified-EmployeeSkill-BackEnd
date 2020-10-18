package com.employee.demo.exception;

public class EmployeeSkillInsertionException extends RuntimeException {

	private static final long serialVersionUID = -111L;
	
	public EmployeeSkillInsertionException() {
		super();
	}
	
	public EmployeeSkillInsertionException(String message) {
		
		super(message);
	}
}
