package com.tms.project;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@SpringBootApplication
@EnableFeignClients
@OpenAPIDefinition(info = @Info(title = "Project-Management", version = "1.0", description = "Documentation Project-Management v1.0"))
public class ProjectManagementApplication 
{

	public static void main(String[] args) 
	{
		SpringApplication.run(ProjectManagementApplication.class, args);
	}

	@Bean
	public ModelMapper getModel()
	{
		return new ModelMapper();
	}
}


