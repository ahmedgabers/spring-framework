package com.ahmedgaber.springaop.aspects;

import java.util.List;
import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.ahmedgaber.springaop.Account;

@Aspect
@Component
@Order(1)
public class LoggingAspect {
	
	private Logger myLogger = Logger.getLogger(LoggingAspect.class.getName());
	
	@Around("execution(* com.ahmedgaber.springaop.service.*.get*(..))")
	public Object aroundGet(
			ProceedingJoinPoint theProceedingJoinPoint) throws Throwable {
		
		myLogger.info("=====> Executing @Around advice on method ");
		MethodSignature method = (MethodSignature) theProceedingJoinPoint.getSignature();
		myLogger.info("Method: " + method);
		
		
		long begin = System.currentTimeMillis();
		
		Object result = null;
		
		
		try {
			
			result = theProceedingJoinPoint.proceed();
		
		} catch (Throwable e) {
			
			myLogger.info("Advice: Something wrong happened here, "
					+ "I caught it and throwing it back to client to handle.");
			
			throw e;
		}
		
		
		long end = System.currentTimeMillis();
		
		long duration = end - begin;
		
		myLogger.info("\n====> Duration: " + duration / 1000.0 + " seconds");
		
		
		return result;
	}
	
	
	
	
	@Before("com.ahmedgaber.springaop.aspects.AopPointcutExpressions.forDaoPackageExceptGetterAndSetter()")
	public void beforeAddAccountAdvice(JoinPoint theJoinPoint) {
		
		myLogger.info("=====> Executing @Before advice on method ");
		
		MethodSignature methoSig = (MethodSignature) theJoinPoint.getSignature();
		myLogger.info("Method: " + methoSig);
		
		// display method arguments
		// set args
		
		Object[] args = theJoinPoint.getArgs();
		
		// loop thru args
		for(Object tempArg : args) {
			myLogger.info(tempArg.toString());
			if(tempArg instanceof Account) {
				// downcast and print Account
				Account theAccount = (Account) tempArg;
				
				myLogger.info("Account Name: " + theAccount.getName());
				myLogger.info("Level: " + theAccount.getLevel());
			}
		}
		
	}
	

	@AfterReturning(
			pointcut="execution(* com.ahmedgaber.springaop.dao.AccountDAO.*(..))",
			returning="result")
	public void afterReturningFindAccountAdvice(
			JoinPoint theJoinPoint, List<Account> result) {
		
		
		String method = theJoinPoint.getSignature().toShortString();
		myLogger.info("\n=====>>> Executing @AfterReturning on method: " + method);
		
		myLogger.info("\n=====>>> result is: " + result);
		
		// post-process the data and modify it
		
		convertAccountNamesToUpperCase(result);
		
		myLogger.info("\n=====>>> result is: " + result);
		
		
	}
	
	private void convertAccountNamesToUpperCase(List<Account> result) {
		if(!result.isEmpty()) {
			result.stream().forEach(e -> e.setName(e.getName().toUpperCase()));
		}
	} 
	
	@AfterThrowing(
			pointcut="execution(* com.ahmedgaber.springaop.dao.AccountDAO.findAccountsException(..))",
			throwing="theExc")
	public void afterThrowingFindAccountsAdvice(
					JoinPoint theJoinPoint, Throwable theExc) {
		
		String method = theJoinPoint.getSignature().toShortString();
		myLogger.info("\n=====>>> Executing @AfterThrowing on method: " + method);
		
		myLogger.info("\n=====>>> the Exception is: " + theExc);
		
	}
	
	@After("execution(* com.ahmedgaber.springaop.dao.AccountDAO.findAccountsException(..))")
	public void afterFinallyFindAccountsAdvice(JoinPoint theJoinPoint) {
		
		
		String method = theJoinPoint.getSignature().toShortString();
		myLogger.info("\n=====>>> Executing @AfterFinally on method: " + method);
	}
	
	
	
	
	
}
