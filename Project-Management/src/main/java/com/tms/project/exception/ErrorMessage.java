package com.tms.project.exception;

import com.tms.project.exception.ErrorMessage;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor
public class ErrorMessage 
{
	private String errorCode;
	private String errorMessage;
}
