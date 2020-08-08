package com.cjet.demo.exception;

@SuppressWarnings("serial")
public class GeneralException extends Exception {
	public GeneralException(String errorMessage) {
		super(errorMessage);
		System.out.println("New GeneralException: " + errorMessage);
	}
}
