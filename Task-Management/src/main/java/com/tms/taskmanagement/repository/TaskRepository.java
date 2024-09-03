package com.tms.taskmanagement.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tms.taskmanagement.entity.TaskEntity;
@Repository
public interface TaskRepository extends JpaRepository<TaskEntity, Long> 
{
	List<TaskEntity> findAllByProjectId(Long projectId);
	TaskEntity findByProjectIdAndTaskId(Long projectId, Long taskId);
}
