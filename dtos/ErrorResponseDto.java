package com.dhernandez.nomina.dtos;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ErrorResponseDto implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int statusCode;
	private String message;
	private String path;
}
