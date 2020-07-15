package com.ahmedgaber.springaop.aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(3)
public class CloudLogAsyncAspect {
	
	@Before("com.ahmedgaber.springaop.aspects.AopPointcutExpressions.forDaoPackageExceptGetterAndSetter()")
	public void logToCloudAsync() {
		System.out.println("=====> Logging to Cloud in async fashion");
	}
}
