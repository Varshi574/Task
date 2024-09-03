package com.tms.user.service;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.tms.user.dto.ProjectDTO;

@FeignClient(url="http://localhost:9094", value="Project-Management")
public interface ProjectClient 
{
	@PostMapping("/project/create")
	public ProjectDTO createProject(ProjectDTO projectdto);
	
    @GetMapping("/project/getproject/{projectId}")
    public ProjectDTO getProjectByPid(@PathVariable("projectId") Long projectId);
    
    @GetMapping("/project/getall")
    public List<ProjectDTO> getAllProject();
    
    
}
