package com.andrelake.postscommentsmongodb.resources.exception;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.andrelake.postscommentsmongodb.services.exception.ObjectNotFoundException;

@ControllerAdvice
public class ResourceExceptionHandler{

	@ExceptionHandler(ObjectNotFoundException.class)
	public ResponseEntity<StandardError> handleObjectNotFoundException(ObjectNotFoundException ex, HttpServletRequest request) {
		
		HttpStatus status = HttpStatus.NOT_FOUND;
		StandardError error = new StandardError(System.currentTimeMillis(), status.value(), "Não encontrado", 
				ex.getMessage(), request.getRequestURI());
		
		return ResponseEntity.status(status).body(error);
	}
}
