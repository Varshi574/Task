package com.tms.user.validation;

import org.springframework.beans.factory.annotation.Autowired;

import com.tms.project.repository.ProjectRepository;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class ValidPidValidator implements ConstraintValidator<ValidPid, Long> 
{
	@Autowired
	private ProjectRepository projectrepository;

	@Override
	public boolean isValid(Long pid, ConstraintValidatorContext context) 
	{
		return pid!=null && projectrepository.existsById(pid);
	}

}
