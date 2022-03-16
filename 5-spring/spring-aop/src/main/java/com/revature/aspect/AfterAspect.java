package com.revature.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Aspect // Aspect
@Configuration // Annotate it so that Spring IoC understands this as a part of the ApplciationContext
public class AfterAspect {
	
	// logger
	private Logger log = LoggerFactory.getLogger(this.getClass());

	// 1. after any methods in the service layer have been executed, log some info about it
	@After("execution(* com.revature.service.*.*(..))")
	public void after(JoinPoint joinPoint) {
		
		log.info("after execution of {}", joinPoint);
		
	}
	
	
	// 2. log the return of a method in the service layer after it's executed
	@AfterReturning(
			value="execution(* com.revature.service.*.*(..))",
			returning="result")
	public void afterReturning(JoinPoint joinPoint, Object result) {
		
		log.info("{} returned value {}", joinPoint, result);
		
	}
	
	
	// 3. Intercept any EXCEPTIONS that were thrown by a method
	@AfterThrowing(
			value="execution(* com.revature.service.*.*(..))",
			throwing="exception")
	public void afterThrowing(JoinPoint joinPoint, Object exception) {
		
		log.info("{} throws exception {}", joinPoint, exception);
		
	}
	
	/**
	 * Weaving - the process of intercepting a method where we have specified the PointCut
	 * Weaver - the framework that does this (Spring AOP uses AspectJ)
	 */

}
