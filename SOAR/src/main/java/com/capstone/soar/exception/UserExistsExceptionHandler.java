package com.capstone.soar.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@RestController
public class UserExistsExceptionHandler extends ResponseEntityExceptionHandler{
	@ExceptionHandler(UserExistsException.class)
	public final ResponseEntity<Object> handleUserExistsException(Exception ex, WebRequest request) {
		UserExistsExceptionResponse response =  new UserExistsExceptionResponse(new Date(), "User Exists", "Another user exists with the same username");
		return new ResponseEntity<>(response, HttpStatus.CONFLICT);
	}
}
