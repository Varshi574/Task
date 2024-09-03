package com.tms.taskmanagement.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data @AllArgsConstructor @NoArgsConstructor
public class ApiResponseDTO 
{
	private TaskDTO taskDTO;
	private UserDTO userDTO;
	
}
