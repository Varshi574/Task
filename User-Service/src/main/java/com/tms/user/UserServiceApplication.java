package com.tms.user;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@SpringBootApplication
@EnableFeignClients
@OpenAPIDefinition(info = @Info(title = "User-Service", version = "1.0", description = "Documentation Project-Management v1.0"))
public class UserServiceApplication 
{

	public static void main(String[] args) 
	{
		SpringApplication.run(UserServiceApplication.class, args);
	}
	
	
	@Bean
	public ModelMapper newMapper()
	{
		return new ModelMapper();
	}
	
}




//http://localhost:9093/swagger-ui/index.html#/