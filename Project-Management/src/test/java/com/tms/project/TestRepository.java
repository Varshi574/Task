package com.tms.project;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tms.project.entity.ProjectEntity;

public interface TestRepository extends JpaRepository<ProjectEntity, Long> {

}
