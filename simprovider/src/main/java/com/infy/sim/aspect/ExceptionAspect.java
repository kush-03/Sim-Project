package com.infy.sim.aspect;

import java.util.List;
import java.util.stream.Collectors;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.infy.sim.util.ErrorMessage;


@RestControllerAdvice
public class ExceptionAspect {
	@ExceptionHandler(ConstraintViolationException.class)
	public ResponseEntity<ErrorMessage> handleConstraintViolationException(ConstraintViolationException e){
		ErrorMessage errorMessage=new ErrorMessage();
		errorMessage.setStatusCode(HttpStatus.BAD_REQUEST.value());
		errorMessage.setMessage(e.getMessage());
		errorMessage.setUrl("/simportal");
		ResponseEntity<ErrorMessage> entity=new ResponseEntity<>(errorMessage,HttpStatus.OK);
		return entity;
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ErrorMessage> methodArgumnetNotValidExceptionHandler(MethodArgumentNotValidException e){
		ErrorMessage errorMessage=new ErrorMessage();
		errorMessage.setStatusCode(HttpStatus.BAD_REQUEST.value());
		List<ObjectError> s=e.getBindingResult().getAllErrors();
		String msg = s.stream().map(ObjectError::getDefaultMessage).collect(Collectors.joining(", "));
		errorMessage.setMessage(msg);
		errorMessage.setUrl("/simportal");
		ResponseEntity<ErrorMessage> entity=new ResponseEntity<>(errorMessage,HttpStatus.OK);
		return entity;
		
	}
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorMessage> exceptionHandler(Exception e){
		ErrorMessage errorMessage=new ErrorMessage();
		errorMessage.setStatusCode(HttpStatus.BAD_REQUEST.value());
		errorMessage.setMessage(e.getMessage());
		errorMessage.setUrl("/simportal");
		ResponseEntity<ErrorMessage> entity=new ResponseEntity<>(errorMessage,HttpStatus.OK);
		return entity;
	}
	
}
