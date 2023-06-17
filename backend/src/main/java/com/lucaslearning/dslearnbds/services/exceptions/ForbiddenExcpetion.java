package com.lucaslearning.dslearnbds.services.exceptions;

public class ForbiddenExcpetion extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ForbiddenExcpetion(String msg) {
		super(msg);
	}
}
