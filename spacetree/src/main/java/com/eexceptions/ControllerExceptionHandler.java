package com.eexceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class ControllerExceptionHandler {
  
//  @ExceptionHandler(value = {ResourceNotFoundException.class, CertainException.class})
//  public ResponseEntity<ErrorMessage> resourceNotFoundException(ResourceNotFoundException ex, WebRequest request) {
//    ErrorMessage message = new ErrorMessage(
//        status,
//        date,
//        ex.getMessage(),
//        description);
//    
//    return new ResponseEntity<ErrorMessage>(message, HttpStatus.NOT_FOUND);
//  }
}
