package com.se.spring.controller;

public class StudentErrorResponse {
	private int status;
	private String message;
	private long timStamp;
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public long getTimStamp() {
		return timStamp;
	}
	public void setTimStamp(long timStamp) {
		this.timStamp = timStamp;
	}
	public StudentErrorResponse(int status, String message, long timStamp) {
		super();
		this.status = status;
		this.message = message;
		this.timStamp = timStamp;
	}
	public StudentErrorResponse() {
		super();
	}
	
	
}
