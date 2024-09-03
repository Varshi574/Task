package com.tms.user.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ApiResponseDTO 
{
	private ProjectDTO projectdto;
	private UserDTO userdto;
	private TaskDTO taskdto;
	private List<UserDTO> userdtolist;
	public ProjectDTO getProjectdto() {
		return projectdto;
	}
	public void setProjectdto(ProjectDTO projectdto) {
		this.projectdto = projectdto;
	}
	public UserDTO getUserdto() {
		return userdto;
	}
	public void setUserdto(UserDTO userdto) {
		this.userdto = userdto;
	}
	public TaskDTO getTaskdto() {
		return taskdto;
	}
	public void setTaskdto(TaskDTO taskdto) {
		this.taskdto = taskdto;
	}
	public ApiResponseDTO(ProjectDTO projectdto, UserDTO userdto, TaskDTO taskdto) {
		super();
		this.projectdto = projectdto;
		this.userdto = userdto;
		this.taskdto = taskdto;
	}
	public ApiResponseDTO(ProjectDTO projectdto, UserDTO userdto) {
		super();
		this.projectdto = projectdto;
		this.userdto = userdto;
	}
	public ApiResponseDTO() {
		super();
	}
}
