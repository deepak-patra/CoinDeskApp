package com.test.test_app.exception;

public class RetryException extends RuntimeException {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -3387514353124229948L;

	public RetryException() {
		super();
	}
	public RetryException(String message) {
		 super(message);
	}
}
