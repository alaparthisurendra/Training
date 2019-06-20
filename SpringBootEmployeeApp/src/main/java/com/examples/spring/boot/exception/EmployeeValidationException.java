package com.examples.spring.boot.exception;

public class EmployeeValidationException extends Exception {

	private static final long serialVersionUID = -3283952245361895887L;

	public EmployeeValidationException() {
		super();
	}

	public EmployeeValidationException(String message) {
		super(message);
	}

	public EmployeeValidationException(String message, Throwable cause) {
		super(message, cause);
	}

}
