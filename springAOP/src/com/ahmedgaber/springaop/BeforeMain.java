package com.ahmedgaber.springaop;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ahmedgaber.springaop.dao.AccountDAO;
import com.ahmedgaber.springaop.dao.MembershipDAO;

public class BeforeMain {

	public static void main(String[] args) {
		
		// read spring config java class
		AnnotationConfigApplicationContext context =
				new AnnotationConfigApplicationContext(Config.class);
		
		// get the bean from the spring container
		AccountDAO theAccountDAO = context.getBean("accountDAO", AccountDAO.class);
		
		MembershipDAO theMembershipDAO = context.getBean("membershipDAO", MembershipDAO.class);
		
		Account myAccount = new Account();
		myAccount.setName("Ahmed");
		myAccount.setLevel("Platinum");
	
		// call the business methods
		theAccountDAO.addAccount(myAccount, true);
		System.out.println();
		theAccountDAO.doWork();
		System.out.println();
		
		theMembershipDAO.addAccount();
		System.out.println();
		theMembershipDAO.goToSleep();
		System.out.println();
		
		// call the getter/setters
		
		theAccountDAO.setName("foobar");
		theAccountDAO.setServiceCode("silver");
		
		String name = theAccountDAO.getName();
		String code = theAccountDAO.getServiceCode();

		
		// close the context
		context.close();

	}

}
