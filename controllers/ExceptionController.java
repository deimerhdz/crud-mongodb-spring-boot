package com.dhernandez.nomina.controllers;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.dhernandez.nomina.dtos.ErrorResponseDto;
import com.mongodb.MongoWriteException;

import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ExceptionController {
	
	@ExceptionHandler({MongoWriteException.class})
	ResponseEntity<ErrorResponseDto> uniqueException( HttpServletRequest request, MongoWriteException e ){
		ErrorResponseDto response = ErrorResponseDto
				.builder()
				.message("Ya existe un registro con el email o identificacion ingresado.")
				.statusCode(HttpStatus.INTERNAL_SERVER_ERROR.value())
				.path(request.getRequestURI())
				.build();
		
		return new ResponseEntity<ErrorResponseDto>(response,HttpStatus.INTERNAL_SERVER_ERROR);
				
	}
}
