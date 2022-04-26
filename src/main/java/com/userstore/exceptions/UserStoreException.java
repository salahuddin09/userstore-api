package com.userstore.exceptions;


public class UserStoreException extends RuntimeException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public UserStoreException() {
		
	}

	public UserStoreException(String message, Throwable cause) {
		super(message, cause);
	}

	public UserStoreException(String message) {
		super(message);
	}

}
