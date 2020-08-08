package com.cjet.demo.exception;

@SuppressWarnings("serial")
public class MySQLException  extends Exception{
	public MySQLException(String errorMessage) {
		super(errorMessage);
		System.out.println("New MySQLException: " + errorMessage);
	}
}

