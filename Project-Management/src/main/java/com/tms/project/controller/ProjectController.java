package com.tms.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tms.project.dto.ApiResponseDTO;
import com.tms.project.dto.ProjectDTO;
import com.tms.project.service.ProjectService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/project")
@CrossOrigin
public class ProjectController {

	@Autowired
	private ProjectService service;

	@PostMapping("/create")
	public ProjectDTO createProject(@Valid @RequestBody ProjectDTO projectdto) {
		return service.createProject(projectdto);
	}

	@GetMapping("getproject/{projectId}")
	public ProjectDTO getProjectByPid( @PathVariable Long projectId) {
		return service.getProjectByProjectId(projectId);
	}

	@GetMapping("/getall")
	public List<ProjectDTO> getAllProject() {
		return service.getAllProject();
	}

	@GetMapping("/getalltasks/{projectTd}")
	public List<ApiResponseDTO> getAllProjectTasks(@PathVariable Long projectTd) {
		return service.getAllProjectTasks(projectTd);
	}

	@PutMapping("/update/{projectTd}")
	public ProjectDTO updateProject(@Valid @PathVariable Long projectTd, @RequestBody ProjectDTO projectdto) 
	{
		return service.updateProject(projectTd, projectdto);
	}
	
	@DeleteMapping("/delete/{projectTd}")
	public void deleteProject(@PathVariable Long projectTd) 
	{
		service.deleteProject(projectTd);
	}
}