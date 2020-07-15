package com.ahmedgaber.springaop.aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(1)
public class LoggingAspect {
	
	@Before("com.ahmedgaber.springaop.aspects.AopPointcutExpressions.forDaoPackageExceptGetterAndSetter()")
	public void beforeAddAccountAdvice() {
		System.out.println("=====> Executing @Before advice on method ");
	}
}
