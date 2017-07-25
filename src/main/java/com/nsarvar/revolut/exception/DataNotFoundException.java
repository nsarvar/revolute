package com.nsarvar.revolut.exception;

public class DataNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6103775932598157674L;

	public DataNotFoundException(String message){
		super(message);
	}
}
