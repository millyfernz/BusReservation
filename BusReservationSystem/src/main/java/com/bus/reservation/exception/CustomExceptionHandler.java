package com.bus.reservation.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class CustomExceptionHandler {
	
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public Map<String,String> handleException(MethodArgumentNotValidException ex){
		Map<String,String> errors = new HashMap<>();
		ex.getBindingResult().getFieldErrors()
		.forEach(error->errors.put(error.getField(), error.getDefaultMessage()));
		
		return errors;
		
	}
	
	@ResponseStatus(HttpStatus.NOT_FOUND)
	@ExceptionHandler(BusNotFoundException.class)
	public Map<String,String> busNotFound(BusNotFoundException ex){
		Map<String,String> error = new HashMap<>();
		error.put("error", ex.getMessage());
		return error;
	}
	
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(BusAlreadyExistsException.class)
	public Map<String,String> busNotFound(BusAlreadyExistsException ex){
		Map<String,String> error = new HashMap<>();
		error.put("error", ex.getMessage());
		return error;
	}

}
