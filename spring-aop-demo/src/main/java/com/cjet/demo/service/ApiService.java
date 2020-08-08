package com.cjet.demo.service;

import org.springframework.stereotype.Service;

import com.cjet.demo.exception.MyJSonException;
import com.cjet.demo.processor.ApiDataProcessor;

@Service
public class ApiService {
	private ApiDataProcessor dataProcessor;
	
	public void start() {
		System.out.println("Start the service.");
		dataProcessor = new ApiDataProcessor();
	}
	
	public void beginDataProcessing() throws InterruptedException {
		System.out.println("Calling data processor to process.");
		dataProcessor.process();
	}
	
	public void throwJsonException() throws MyJSonException {
		System.out.println("Calling data processor to process.");
		throw new MyJSonException("This is a json exception.");
	}
}
