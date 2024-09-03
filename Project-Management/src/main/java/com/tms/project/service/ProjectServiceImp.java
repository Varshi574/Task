package com.tms.project.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tms.project.dto.ApiResponseDTO;
import com.tms.project.dto.ProjectDTO;
import com.tms.project.dto.TaskDTO;
import com.tms.project.entity.ProjectEntity;
import com.tms.project.exception.ProjectIdNotFoundException;
import com.tms.project.repository.ProjectRepository;

@Service
public class ProjectServiceImp implements ProjectService {

	@Autowired
	private ProjectRepository projectRepository;

	@Autowired
	private ModelMapper modelMapper;

	@Autowired
	private TaskClient taskClient;

	@Override
	public ProjectDTO createProject(ProjectDTO projectdto) {
		ProjectEntity project = modelMapper.map(projectdto, ProjectEntity.class);
		ProjectEntity savedProject = projectRepository.save(project);
		return modelMapper.map(savedProject, ProjectDTO.class);
	}

	@Override
	public ProjectDTO getProjectByProjectId(Long pid) {
		ProjectEntity projectentity = projectRepository.findById(pid).orElseThrow(() -> new ProjectIdNotFoundException("Id Not Found"));
		return modelMapper.map(projectentity, ProjectDTO.class);
	}

	@Override
	public List<ProjectDTO> getAllProject() {
		List<ProjectEntity> projects = projectRepository.findAll();
		return projects.stream().map(project -> modelMapper.map(project, ProjectDTO.class)).toList();
	}

	@Override
	public List<ApiResponseDTO> getAllProjectTasks(Long pid) {
		ProjectEntity projectentity = projectRepository.findById(pid).orElseThrow(() -> new ProjectIdNotFoundException("Id not Found"));

		List<TaskDTO> tasklist = taskClient.getAllTasksByPid(pid);

		ApiResponseDTO apidto = new ApiResponseDTO(modelMapper.map(projectentity, ProjectDTO.class), tasklist);

		List<ApiResponseDTO> apilist = List.of(apidto);
		return apilist;
	}

	@Override
	public void deleteProject(Long pid) {
		if (projectRepository.existsById(pid)) {
			projectRepository.deleteById(pid);
		} else {
			throw new RuntimeException("Project not found with ID: " + pid);
		}
	}

	

	@Override
	public ProjectDTO updateProject(Long pid, ProjectDTO projectDTO) 
	{
		ProjectEntity projectEntity = projectRepository.findById(pid).orElseThrow(() -> new ProjectIdNotFoundException("Project-ID not Found"));
		
		projectEntity.setProjectName(projectDTO.getProjectName());
		projectEntity.setProjectDescription(projectDTO.getProjectDescription());
		projectEntity.setProjectStatus(projectDTO.getProjectStatus());
		projectEntity.setProjectStart(projectDTO.getProjectStart());
		projectEntity.setProjectEnd(projectDTO.getProjectEnd());

		ProjectEntity savedentity = projectRepository.save(projectEntity);
		
		return modelMapper.map(savedentity, ProjectDTO.class);
	}

}