package com.tms.project.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@RestControllerAdvice
public class GlobalExceptionHandler 
{
	
	@ExceptionHandler(ProjectIdNotFoundException.class)
    public ResponseEntity<ErrorMessage> handleUserUidNotFoundException(ProjectIdNotFoundException exception) 
	{
        ErrorMessage em = new ErrorMessage("404", exception.getMessage());
        return new ResponseEntity<>(em, HttpStatus.NOT_FOUND);
    }
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<Object> handleMethodArgumentNotValidException(MethodArgumentNotValidException me)
	{
		Map<String,String> errorMap = new HashMap<>();
		
		me.getBindingResult().getAllErrors().forEach(
				error -> {
					    errorMap.put(((FieldError)error).getField()    , error.getDefaultMessage());
				});
		
		return new ResponseEntity<Object>(errorMap,HttpStatus.BAD_REQUEST);	
	}
	
}
