package com.tms.taskmanagement;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tms.taskmanagement.entity.TaskEntity;

public interface TestRepository extends JpaRepository<TaskEntity, Long> 
{

}
