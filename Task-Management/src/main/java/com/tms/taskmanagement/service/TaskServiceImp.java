package com.tms.taskmanagement.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tms.taskmanagement.dto.TaskDTO;
import com.tms.taskmanagement.entity.TaskEntity;
import com.tms.taskmanagement.exception.TaskIdNotFoundException;
import com.tms.taskmanagement.repository.TaskRepository;


@Service
public class TaskServiceImp implements TaskService 
{

    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private ModelMapper modelMapper;
    
    @Autowired
    private UserClient userClient;
    
    

    @Override
    public TaskDTO createTask(TaskDTO taskDTO) 
    {
        TaskEntity task = modelMapper.map(taskDTO, TaskEntity.class);
        TaskEntity savedTask = taskRepository.save(task);
        
        userClient.updateTid(taskDTO.getUserId(), taskDTO.getTaskId(), taskDTO.getProjectId() ,taskDTO.getTaskStatus());

        return modelMapper.map(savedTask, TaskDTO.class);
    }

    @Override
    public TaskDTO updateTask(Long tid, TaskDTO taskDTO) 
    {
        TaskEntity taskEntity = taskRepository.findById(tid).orElseThrow(()->new TaskIdNotFoundException("Id Not Fouds"));

        taskEntity.setTaskName(taskDTO.getTaskName());
        taskEntity.setTaskDescription(taskDTO.getTaskDescription());
        taskEntity.setProjectId(taskDTO.getProjectId());
        taskEntity.setTaskStatus(taskDTO.getTaskStatus());
        taskEntity.setUserId(taskDTO.getUserId());
        taskEntity.setTaskEnd(taskDTO.getTaskEnd());

        
        userClient.updateTid(taskDTO.getUserId(),taskDTO.getTaskId(),taskDTO.getProjectId(),taskDTO.getTaskStatus());
        
        TaskEntity savedtaskentity = taskRepository.save(taskEntity);
        
        return modelMapper.map(savedtaskentity, TaskDTO.class);
    }
    
	@Override
	public void updateTaskStatus(Long userId, Long projectId, Long taskId, String taskStatus) 
	{
		TaskEntity taskEntity = taskRepository.findByProjectIdAndTaskId(projectId, taskId);
		if(taskEntity.getUserId() == userId)
		{
			taskEntity.setTaskStatus(taskStatus);
			taskRepository.save(taskEntity);
		}
	}

    @Override
    public TaskDTO getTaskByTid(Long tid) 
    {
    	TaskEntity taskEntity = taskRepository.findById(tid).orElseThrow(() -> new TaskIdNotFoundException("User ID Not Found"));
    	return modelMapper.map(taskEntity,TaskDTO.class);
    }

    @Override
    public List<TaskDTO> getAllTask() 
    {
        List<TaskEntity> tasks = taskRepository.findAll();
        return tasks.stream()
                    .map(task -> modelMapper.map(task, TaskDTO.class))
                    .toList();
    }

    
    @Override
	public List<TaskDTO> getAllTasksByPid(Long pid)
    {
		List<TaskEntity> taskentitylist = taskRepository.findAllByProjectId(pid);
		return taskentitylist.stream().map(entity->modelMapper.map(entity,TaskDTO.class)).collect(Collectors.toList());
	}

    @Override
    public void deleteTaskDTO(Long tid) 
    {
    	TaskEntity userentity = taskRepository.findById(tid).orElseThrow(() -> new TaskIdNotFoundException("User ID Not Found"));
    	taskRepository.delete(userentity);
    }
}
