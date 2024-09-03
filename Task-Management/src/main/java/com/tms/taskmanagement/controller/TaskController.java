package com.tms.taskmanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.CrossOrigin;
import com.tms.taskmanagement.dto.TaskDTO;
import com.tms.taskmanagement.service.TaskService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/task")
@CrossOrigin
public class TaskController {

    @Autowired
    private TaskService taskService;

    @PostMapping("/create")
    public TaskDTO createTask(@Valid @RequestBody TaskDTO taskDTO) {
        return taskService.createTask(taskDTO);
    }
    
    
    @GetMapping("/gettask/{tid}")
    public TaskDTO getTaskByTid(@PathVariable Long tid) 
    {
        return taskService.getTaskByTid(tid);
    }

    
    @GetMapping("/getalltasksbypid/{projectId}")
    public List<TaskDTO> getAllTasksByPid(@PathVariable Long projectId)
    {
    	return taskService.getAllTasksByPid(projectId);
    }
    
    
    @GetMapping("/getalltask")
    public List<TaskDTO> getAllTask() {
        return taskService.getAllTask();
    }
    
    @PutMapping("/update/{tid}")
    public TaskDTO updateTask(@Valid @PathVariable Long tid, @RequestBody TaskDTO taskDTO) 
    {
        return taskService.updateTask(tid, taskDTO);
    }
    
    @PutMapping("/updatetstatus/{uid}/{projectId}/{taskId}/{taskStatus}")
	public void updateTaskStatus(@Valid @PathVariable Long uid,@PathVariable Long projectId,@PathVariable Long taskId,@PathVariable String taskStatus)
	{
		taskService.updateTaskStatus(uid, projectId, taskId, taskStatus);
	}

    @DeleteMapping("/delete/{tid}")
    public void deleteTask(@PathVariable Long tid) 
    {
        taskService.deleteTaskDTO(tid);
    }
}
