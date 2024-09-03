package com.tms.user.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tms.user.entity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Long> 
{
	List<UserEntity> findAllByProjectId(Long projectId);
    Optional<UserEntity> findByEmail(String email);
}
