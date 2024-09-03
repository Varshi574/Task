package com.tms.user;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tms.user.entity.UserEntity;

public interface TestRepository extends JpaRepository<UserEntity, Long> 
{
	
}
