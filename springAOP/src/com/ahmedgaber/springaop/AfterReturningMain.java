package com.ahmedgaber.springaop;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ahmedgaber.springaop.dao.AccountDAO;

public class AfterReturningMain {

	public static void main(String[] args) {
		
		// read spring config java class
		AnnotationConfigApplicationContext context =
				new AnnotationConfigApplicationContext(Config.class);
		
		// get the bean from the spring container
		AccountDAO theAccountDAO = context.getBean("accountDAO", AccountDAO.class);
		
		List<Account> theAccounts = theAccountDAO.findAccounts();
		
		System.out.println("\n\nMain Program: AfterReturningMain");
		System.out.println("----");
		
		System.out.println(theAccounts);
		System.out.println("\n");
		

		
		// close the context
		context.close();

	}

}
