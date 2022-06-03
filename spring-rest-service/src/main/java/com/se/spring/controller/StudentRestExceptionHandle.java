package com.se.spring.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class StudentRestExceptionHandle {
	@ExceptionHandler
	public ResponseEntity<StudentErrorResponse> handleException(StudentNotFoundException exc){
		StudentErrorResponse erro = new StudentErrorResponse();
		erro.setStatus(HttpStatus.NOT_FOUND.value());
		erro.setMessage(exc.getMessage());
		erro.setTimStamp(System.currentTimeMillis());
		
		return new ResponseEntity<>(erro, HttpStatus.NOT_FOUND);
	}
}
