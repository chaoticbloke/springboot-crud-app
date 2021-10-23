package com.example.post.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class RecordNotFoundException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public RecordNotFoundException(String message) {
		super(message);
	}

	private String message;
	private Object id;

	public RecordNotFoundException(String message, Object id) {
		super(String.format("%s: '%s'", message, id));
		this.message = message;
		this.id = id;
	}

}
