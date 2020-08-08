package com.cjet.demo.metric.impl;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
public class TrackProcessTimeAspect {
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Around("@annotation(com.cjet.demo.metric.TrackProcessTime)")
	public void around(ProceedingJoinPoint joinPoint) throws Throwable {
		long startTime = System.currentTimeMillis();

		joinPoint.proceed();

		long timeTaken = System.currentTimeMillis() - startTime;
		logger.info("Time Taken by {} is {} ms", joinPoint, timeTaken);
		logger.info("Total time by {} is {} s", joinPoint, (timeTaken/1000));
	}
}
