package com.cjet.demo.exception;


@SuppressWarnings("serial")
public class MyJSonException extends Exception{
	public MyJSonException(String errorMessage) {
		super(errorMessage);
		System.out.println("New MyJSonException: " + errorMessage);
	}
}