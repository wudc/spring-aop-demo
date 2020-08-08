package com.cjet.demo.metric.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.context.annotation.Configuration;

import com.cjet.demo.processor.ApiDataProcessor;

@Aspect
@Configuration
public class TotalCountsAspect {
	private static final Logger LOGGER = LogManager.getLogger(TotalCountsAspect.class);
	private int jsonError;
	
	@AfterReturning(value = "execution(* com.cjet.demo.processor.ApiDataProcessor.getJsonErrorCount(..))", 
			returning = "result")
	public void afterReturning(JoinPoint joinPoint, Object result) {
		LOGGER.info("{} returned with value {}", joinPoint, result);
	}
	
	@After(value = "execution(* com.cjet.demo.processor.ApiDataProcessor.process(..))")
	public void after(JoinPoint joinPoint) {
		LOGGER.info("after execution of {}", joinPoint);
		ApiDataProcessor instance = (ApiDataProcessor) joinPoint.getThis();
		jsonError = instance.getJsonErrorCount();
		LOGGER.info("Total json error count is: " + jsonError);
	}
	
	public int getJSonError() {
		return jsonError;
	}
}
