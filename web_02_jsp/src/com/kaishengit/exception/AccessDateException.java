package com.kaishengit.exception;

public class AccessDateException extends RuntimeException {


	private static final long serialVersionUID = 1L;

	public AccessDateException(){};
	
	public AccessDateException(String message){
		super(message);
	}
	
	public AccessDateException(Throwable th){
		super(th);
		
	}
	public AccessDateException (String message,Throwable th ){
		super(message, th);
	}
}
