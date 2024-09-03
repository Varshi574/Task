package com.tms.user.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

import com.tms.user.dto.TaskDTO;

@FeignClient(name = "task-management", url = "http://localhost:9095")
public interface TaskClient {

    @GetMapping("/task/gettask/{id}")
    public TaskDTO getTaskById(@PathVariable Long id);
    
    @PutMapping("/task/updatetstatus/{userId}/{projectId}/{taskId}/{taskStatus}")
    public void updateTaskStatus(@PathVariable Long userId, @PathVariable Long projectId, @PathVariable Long taskId, @PathVariable String taskStatus);
}
