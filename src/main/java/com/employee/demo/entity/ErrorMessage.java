package com.employee.demo.entity;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ErrorMessage {

	private String errorDescription;
	private int errorCode;
	
	public ErrorMessage() {
		
	}
	
	public ErrorMessage(String errorDescription, int errorCode) {
		super();
		this.errorDescription = errorDescription;
		this.errorCode = errorCode;
	}

	public String getErrorDescription() {
		return errorDescription;
	}

	public void setErrorDescription(String errorMessage) {
		this.errorDescription = errorMessage;
	}

	public int getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}
	
	
}
