package com.test.test_app.exception;

/**
 * Gets the errors.
 */
public class BusinessException extends RuntimeException {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -3387514353124229948L;

  
    public BusinessException() {
        super();
    }


	public BusinessException(String message) {
		 super(message);
	}

   
}
