package com.tms.taskmanagement.exception;

import com.tms.taskmanagement.exception.ErrorMessage;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor
public class ErrorMessage 
{
	private String errorCode;
	private String errorMessage;
}
