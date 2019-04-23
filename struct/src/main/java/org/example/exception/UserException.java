package org.example.exception;

public class UserException extends Exception{
	
	private static final long serialVersionUID = 1L;
	public UserException(){
		super();
	}
	public UserException(String msg){
		super(msg);
	}
	public UserException(String msg, Throwable cause){
		super(msg, cause);
	}
	public UserException(Throwable cause){
		super(cause);
	}
}
