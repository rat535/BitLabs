package com.project.bitLabs.Exception;

public class CustomException extends RuntimeException {

	 public CustomException() {
		super();
		// TODO Auto-generated constructor stub
	}


	private String message;

	    public CustomException(String message) {
	        super();
	        this.message = message;
	    }

	    public String getMessage() {
	        return message;
	    }

	    public void setMessage(String message) {
	        this.message = message;
	    }
}
