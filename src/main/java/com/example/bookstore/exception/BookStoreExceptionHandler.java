package com.example.bookstore.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class BookStoreExceptionHandler {

	/**
	 * Method to handle when user Id not found
	 * 
	 * @param exception
	 * @return : Response Entity of Exception
	 */
	@ExceptionHandler(BookStoreException.class)
	public ResponseEntity<Object> exception(BookStoreException exception) {
		return new ResponseEntity<>(exception.getMessage(), HttpStatus.NOT_FOUND);
	}
}
