package com.tms.project.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor
public class ProjectIdNotFoundException extends RuntimeException {
	
	private String message;
}
