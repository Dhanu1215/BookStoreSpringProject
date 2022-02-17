package com.example.bookstore.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Respond https status message and data
 * 
 * @author praja
 */
@AllArgsConstructor
public @Data class ResponseDTO {

	private String message;
	private Object data;
}
