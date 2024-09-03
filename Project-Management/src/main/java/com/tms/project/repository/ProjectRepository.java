package com.tms.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tms.project.entity.ProjectEntity;

public interface ProjectRepository extends JpaRepository<ProjectEntity, Long> 
{

}
