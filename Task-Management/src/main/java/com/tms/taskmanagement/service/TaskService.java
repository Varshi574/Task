package com.tms.taskmanagement.service;

import java.util.List;

import com.tms.taskmanagement.dto.TaskDTO;

public interface TaskService 
{
	public TaskDTO createTask(TaskDTO taskdto);
	
	public TaskDTO updateTask(Long tid , TaskDTO taskdto);
	public void updateTaskStatus(Long uid,Long pid, Long taskid, String tstatus);
	
	public TaskDTO getTaskByTid(Long tid);
	public List<TaskDTO> getAllTask();
	public List<TaskDTO> getAllTasksByPid(Long pid);
	
	
	public void deleteTaskDTO(Long tid);
}



