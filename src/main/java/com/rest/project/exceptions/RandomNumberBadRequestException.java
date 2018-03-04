package com.rest.project.exceptions;

public class RandomNumberBadRequestException extends Exception{
	
	/**
	 * Default serialVersionUID
	 */
	private static final long serialVersionUID = 1L;

	public RandomNumberBadRequestException(String message) {
		super(message);
	}

}
