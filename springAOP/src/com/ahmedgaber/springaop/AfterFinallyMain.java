package com.ahmedgaber.springaop;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ahmedgaber.springaop.dao.AccountDAO;

public class AfterFinallyMain {
	
	public static void main(String[] args) {
		

		// read spring config java class
		AnnotationConfigApplicationContext context =
				new AnnotationConfigApplicationContext(Config.class);
		
		// get the bean from the spring container
		AccountDAO theAccountDAO = context.getBean("accountDAO", AccountDAO.class);
		
		List<Account> theAccounts = new ArrayList<>();
		
		try {
			boolean tripWire = false;
			theAccounts = theAccountDAO.findAccountsException(tripWire);
			
		} catch (Exception e) {
			System.out.println("\n\nMain ... caught an exception " + e);
		}
		
		System.out.println("\n\nMain Program: AfterThrowingMain");
		System.out.println("----");
		
		System.out.println(theAccounts);
		System.out.println("\n");
		
		// close the context
		context.close();

		
		
	}

}
