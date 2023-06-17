package com.lucaslearning.dslearnbds.services.exceptions;

public class DatabaseExcpetion extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	public DatabaseExcpetion(String msg) {
		super(msg);
	}
}
