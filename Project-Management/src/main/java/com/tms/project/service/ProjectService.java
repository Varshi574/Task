package com.tms.project.service;

import java.util.List;

import com.tms.project.dto.ApiResponseDTO;
import com.tms.project.dto.ProjectDTO;

public interface ProjectService {
	public ProjectDTO createProject(ProjectDTO projectDTO); // working

	public ProjectDTO updateProject(Long projectId, ProjectDTO projectDTO); // working

	public ProjectDTO getProjectByProjectId(Long projectTd);

	public List<ProjectDTO> getAllProject();

	public List<ApiResponseDTO> getAllProjectTasks(Long projectId);
	

	public void deleteProject(Long projectId);

}

// public ApiResponseDTO getProjectTaskByPid(Long pid); returnin a single task so, removed and added "getalltasks"

// public ProjectDTO updatePstatus(Long pid,ProjectDTO projectdto);
// removed updatePstatus because two users work on single project, if one user updates complete and other person is sill pending how can project get completed?