package com.ahmedgaber.springaop.aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class AopPointcutExpressions {

	@Pointcut("execution(* com.ahmedgaber.springaop.dao.*.*(..))")
	public void forDaoPackage() {}
	
	@Pointcut("execution(* com.ahmedgaber.springaop.dao.*.get*(..))")
	public void getter() {}
	

	@Pointcut("execution(* com.ahmedgaber.springaop.dao.*.set*(..))")
	public void setter() {}
	
	
	@Pointcut("forDaoPackage() && !(getter() || setter())")
	public void forDaoPackageExceptGetterAndSetter() {}
	
	
}
