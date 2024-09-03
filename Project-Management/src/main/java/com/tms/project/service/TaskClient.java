package com.tms.project.service;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.tms.project.dto.TaskDTO;

@FeignClient(url="http://localhost:9095",name="Task-Management")
public interface TaskClient 
{
	@GetMapping("/task/gettask/{tSid}")
	public TaskDTO getTaskByTid(@PathVariable Long tid);
	
	@GetMapping("/task/getalltask")
	public List<TaskDTO> getAllTask();
	
	@GetMapping("/task/getalltasksbypid/{projectId}")
	public List<TaskDTO> getAllTasksByPid(@PathVariable Long projectId);
}
