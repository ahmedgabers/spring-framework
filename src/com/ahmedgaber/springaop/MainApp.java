package com.ahmedgaber.springaop;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ahmedgaber.springaop.dao.AccountDAO;
import com.ahmedgaber.springaop.dao.MembershipDAO;

public class MainApp {

	public static void main(String[] args) {
		
		// read spring config java class
		AnnotationConfigApplicationContext context =
				new AnnotationConfigApplicationContext(Config.class);
		
		// get the bean from the spring container
		AccountDAO theAccountDAO = context.getBean("accountDAO", AccountDAO.class);
		
		MembershipDAO theMembershipDAO = context.getBean("membershipDAO", MembershipDAO.class);
		
		// call the business methods
		theAccountDAO.addAccount();
		theMembershipDAO.addAccount();
		
		// close the context
		context.close();

	}

}
