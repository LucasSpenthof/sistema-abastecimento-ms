package com.abastecimento.resource.exceptions;

import java.time.Instant;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.abastecimento.services.exceptions.DataBaseException;
import com.abastecimento.services.exceptions.ResourceNotFoundException;

@ControllerAdvice
public class ResourceExceptionHandler {
 public ResponseEntity<StandardError> entityNotFound(ResourceNotFoundException e, HttpServletRequest request){
  HttpStatus status = HttpStatus.NOT_FOUND;
  StandardError error = new StandardError();
  error.setTimestamp(Instant.now());
  error.setStatus(status.value());
  error.setError("Resource not found");
  error.setMessage(e.getMessage());
  error.setPath(request.getRequestURI());
  return ResponseEntity.status(status).body(error);
 }
 @ExceptionHandler(MethodArgumentNotValidException.class)
 public ResponseEntity<ValidationError> dataBase(MethodArgumentNotValidException e, HttpServletRequest request){
  HttpStatus status = HttpStatus.UNPROCESSABLE_ENTITY;
  ValidationError err = new ValidationError();
  err.setTimestamp(Instant.now());
  err.setStatus(status.value());
  err.setError("Validation Exception");
  err.setMessage(e.getMessage());
  err.setPath(request.getRequestURI());
  for(FieldError fe : e.getBindingResult().getFieldErrors()) {
	  err.addError(fe.getField(), fe.getDefaultMessage());
  }
  return ResponseEntity.status(status).body(err);
}
 @ExceptionHandler(DataBaseException.class)
 public ResponseEntity<StandardError> dataBase(DataBaseException e, HttpServletRequest request){
  HttpStatus status = HttpStatus.BAD_REQUEST;
  StandardError err = new StandardError();
  err.setTimestamp(Instant.now());
  err.setStatus(status.value());
  err.setError("Database exception");
  err.setMessage(e.getMessage());
  err.setPath(request.getRequestURI());
  return ResponseEntity.status(status).body(err);
}
}
