package com.test.test_app.exception;

/**
 * Gets the errors.
 *
 * @return the errors
 */
public class RequestValidationException extends RuntimeException {

	   /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -3387514353124229948L;


  
    public RequestValidationException(String string) {
        super(string);
    }

}
