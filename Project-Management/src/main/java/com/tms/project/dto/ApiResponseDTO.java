package com.tms.project.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ApiResponseDTO 
{
	private ProjectDTO projectdto;
	private TaskDTO taskdto;
	private List<TaskDTO> listOfTasks;

    public ApiResponseDTO(ProjectDTO projectdto, List<TaskDTO> listOfTasks) 
    {
        this.projectdto = projectdto;
        this.listOfTasks = listOfTasks;
    }

    
    
    
	public List<TaskDTO> getListOfTasks() {
		return listOfTasks;
	}




	public void setListOfTasks(List<TaskDTO> listOfTasks) {
		this.listOfTasks = listOfTasks;
	}




	public ProjectDTO getProjectdto() {
		return projectdto;
	}

	public void setProjectdto(ProjectDTO projectdto) {
		this.projectdto = projectdto;
	}

	public TaskDTO getTaskdto() {
		return taskdto;
	}

	public void setTaskdto(TaskDTO taskdto) {
		this.taskdto = taskdto;
	}

	public ApiResponseDTO(ProjectDTO projectdto, TaskDTO taskdto) {
		super();
		this.projectdto = projectdto;
		this.taskdto = taskdto;
	}


	public ApiResponseDTO() {
		super();
	}
}
