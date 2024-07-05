package com.capstone.soar.exception;

import java.util.Date;

public class UserExistsExceptionResponse{
	private Date exceptionTime;
	private String message;
	private String details;
	
	public UserExistsExceptionResponse(Date exceptionTime, String message, String details) {
		super();
		this.exceptionTime = exceptionTime;
		this.message = message;
		this.details = details;
	}
	public Date getExceptionTime() {
		return exceptionTime;
	}
	public String getMessage() {
		return message;
	}
	public String getDetails() {
		return details;
	}
}
