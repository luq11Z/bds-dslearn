package com.lucaslearning.dslearnbds.resources.exceptions;

import java.time.Instant;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.lucaslearning.dslearnbds.services.exceptions.DatabaseExcpetion;
import com.lucaslearning.dslearnbds.services.exceptions.ForbiddenExcpetion;
import com.lucaslearning.dslearnbds.services.exceptions.ResourceNotFoundExcpetion;
import com.lucaslearning.dslearnbds.services.exceptions.UnauthorizedExcpetion;

@ControllerAdvice
public class ResourceExceptionHandler {
	
	@ExceptionHandler(ResourceNotFoundExcpetion.class)
	public ResponseEntity<StandardError> objectNotFoundExcpetion(ResourceNotFoundExcpetion e, HttpServletRequest request){
		StandardError err = new StandardError();
		
		HttpStatus status = HttpStatus.NOT_FOUND;
		err.setTimestamp(Instant.now());
		err.setStatus(status.value());
		err.setError("Resource not found");
		err.setMessage(e.getMessage());
		err.setPath(request.getRequestURI());
		
		return ResponseEntity.status(status).body(err);
	}
	
	@ExceptionHandler(DatabaseExcpetion.class)
	public ResponseEntity<StandardError> databaseException(DatabaseExcpetion e, HttpServletRequest request){
		StandardError err = new StandardError();
		
		HttpStatus status = HttpStatus.BAD_REQUEST;
		err.setTimestamp(Instant.now());
		err.setStatus(status.value());
		err.setError("Database exception");
		err.setMessage(e.getMessage());
		err.setPath(request.getRequestURI());
		
		return ResponseEntity.status(status).body(err);
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ValidationError> methodArgumentNotValidException(MethodArgumentNotValidException e, HttpServletRequest request){
		ValidationError err = new ValidationError();
		
		HttpStatus status = HttpStatus.UNPROCESSABLE_ENTITY;
		err.setTimestamp(Instant.now());
		err.setStatus(status.value());
		err.setError("Validation exception");
		err.setMessage(e.getMessage());
		err.setPath(request.getRequestURI());
		
		for (FieldError f : e.getFieldErrors()) {
			err.addError(f.getField(), f.getDefaultMessage());
		}
		
		return ResponseEntity.status(status).body(err);
	}
	
	@ExceptionHandler(IllegalArgumentException.class)
	public ResponseEntity<StandardError> illegalArgumentException(IllegalArgumentException e, HttpServletRequest request){
		StandardError err = new StandardError();
		
		HttpStatus status = HttpStatus.BAD_REQUEST;
		err.setTimestamp(Instant.now());
		err.setStatus(status.value());
		err.setError("Bad Request");
		err.setMessage(e.getMessage());
		err.setPath(request.getRequestURI());
		
		return ResponseEntity.status(status).body(err);
	}
	
	@ExceptionHandler(ForbiddenExcpetion.class)
	public ResponseEntity<OAuthCustomError> forbiddenExcpetion(ForbiddenExcpetion e, HttpServletRequest request){
		OAuthCustomError err = new OAuthCustomError("Forbidden", e.getMessage());
		
		return ResponseEntity.status(HttpStatus.FORBIDDEN).body(err);
	}
	
	@ExceptionHandler(UnauthorizedExcpetion.class)
	public ResponseEntity<OAuthCustomError> unauthorizedExcpetion(UnauthorizedExcpetion e, HttpServletRequest request){
		OAuthCustomError err = new OAuthCustomError("Unauthorized", e.getMessage());
		
		return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(err);
	}
	
}
