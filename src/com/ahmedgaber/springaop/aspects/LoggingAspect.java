package com.ahmedgaber.springaop.aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {
	
	// this is where we add all of our related advices for logging
	// let's start with an @Before advice
	@Pointcut("execution(* com.ahmedgaber.springaop.dao.*.*(..))")
	private void forDaoPackage() {}
	
	@Pointcut("execution(* com.ahmedgaber.springaop.dao.*.get*(..))")
	private void getter() {}
	

	@Pointcut("execution(* com.ahmedgaber.springaop.dao.*.set*(..))")
	private void setter() {}
	
	

	@Pointcut("forDaoPackage() && !(getter() || setter())")
	private void forDaoPackageExceptGetterAndSetter() {}
	
	@Before("forDaoPackageExceptGetterAndSetter()")
	public void beforeAddAccountAdvice() {
		System.out.println("=====> Executing @Before advice on method ");
	}
	
	@Before("forDaoPackageExceptGetterAndSetter()")
	public void performApiAnalytics() {
		System.out.println("=====> Performing API analytics ");
	}
	
	
}
