package com.ahmedgaber.crud.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.jboss.logging.Logger;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class CRMLoggingAspect {
	
	
	// setup logger
	
	private Logger myLogger = Logger.getLogger(getClass().getName());
	
	// setup pointcut declarations
	
	@Pointcut("execution(* com.ahmedgaber.crud.controller.*.*(..))")
	private void forControllerPackage() {
		
	}
	
	@Pointcut("execution(* com.ahmedgaber.crud.service.*.*(..))")
	private void forServicePackage() {
		
	}
	
	@Pointcut("execution(* com.ahmedgaber.crud.dao.*.*(..))")
	private void forDaoPackage() {
		
	}
	
	@Pointcut("forControllerPackage() || forServicePackage() || forDaoPackage()")
	private void forAppFlow() {}
	
	// add @Before advice
	
	
	@Before("forAppFlow()")
	public void before(JoinPoint theJoinPoint) {
		
		String method = theJoinPoint.getSignature().toShortString();
		myLogger.info("=====>> in @Before: calling method " + method);
		
		
		Object[] args = theJoinPoint.getArgs();
		
		
		for(Object a: args) {
			myLogger.info("=====>> argument: " + a);
		}
	}

	
	// add @AfterReturning advice
	
	@AfterReturning(
			pointcut="forAppFlow()",
			returning="theResult")
	public void afterReturning(JoinPoint theJoinPoint, Object theResult) {
		
		String method = theJoinPoint.getSignature().toShortString();
		myLogger.info("=====>> in @AfterReturn: from method " + method);
		
		
		myLogger.info("=====>>> Result: " + theResult);

		
	}
	
	
	
	
	
	
	
	
	
	
	
}
