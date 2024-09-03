package com.tms.taskmanagement.exception;

import lombok.AllArgsConstructor;

import lombok.NoArgsConstructor;

@SuppressWarnings("serial")
 @AllArgsConstructor @NoArgsConstructor
public class TaskIdNotFoundException extends RuntimeException 
{
	private String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	
}
