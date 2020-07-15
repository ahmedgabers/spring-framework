package com.ahmedgaber.springaop.dao;

import org.springframework.stereotype.Component;

@Component
public class MembershipDAO {

	public void addAccount() {
		System.out.println(getClass() + ": MembershipDAO.addAccount()");
	}
	
	public void goToSleep() {
		System.out.println(getClass() + ": MembershipDAO.goToSleep()");
	}
	
	
	
	
}
