package com.example.velocerentalsspring.infrastructure.exceptions;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
  @ExceptionHandler(HttpException.class)
  public ResponseEntity<ExceptionResponseDTO> handleHttpException(HttpException e) {
    return new ResponseEntity<>(
            new ExceptionResponseDTO(e.getMessage()),
            e.getStatus());
  }
}
