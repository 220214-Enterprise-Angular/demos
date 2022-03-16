package com.revature.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

/**
 * Cross Cutting Concern
 * 
 * A concern is a term that refers to a part of the system divided by functionality.
 *
 * A CROSS-CUTTING concern is a concern that is applicable throughout the entire application,
 * and it affects the entire application.
 * 
 * Examples:
 * - logging
 * - security
 * - data transfer
 */

@Aspect
@Configuration
public class MethodExecutionCalculationAspect {
	
	// Goal: Intercept the the service layer's methods and calculate how long it takes it to execute
	// in milliseconds using @Around 
	
	private Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Around("execution(* com.revature.service.*.*(..))")
	public void around(ProceedingJoinPoint joinPoint) throws Throwable {
		
		// proceeding Join Point allows us to track the method as it's executing
		
		//  capture the start time of the method
		long start = System.currentTimeMillis();
		
		// give the method permission to continue executing
		joinPoint.proceed();
		
		// capture the end time of the method
		long end = System.currentTimeMillis();
		
		// log.info the difference between the end point and the start point
		long timeTaken = end - start;
		log.info("The time taken for {} to execute is {} milliseconds", joinPoint, timeTaken);
		
	}
	

}








