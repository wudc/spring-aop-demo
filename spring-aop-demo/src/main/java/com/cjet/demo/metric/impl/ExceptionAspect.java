package com.cjet.demo.metric.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import com.cjet.demo.exception.MyJSonException;

@Aspect
@Component
public class ExceptionAspect {
	private static final Logger LOGGER = LogManager.getLogger(ExceptionAspect.class);
	private boolean jsonError;
	
	@AfterThrowing (pointcut = "execution(* com.cjet.demo..*(..)))" , throwing = "ex")
    public void logAfterThrowingMyJSonException(JoinPoint joinPoint, MyJSonException ex) throws Throwable {
		LOGGER.info("Caught a MyJSonException: " + ex);
		jsonError = true;
	}
	
	@AfterThrowing ("execution(* com.cjet.demo..*(..)))")
    public void logAfterThrowingAllMethods() throws Throwable {
		LOGGER.info("Caught an Exception");
	}

	public boolean isJsonError() {
		return jsonError;
	}
	
	public void resetFlags() {
		jsonError = false;
	}
}
