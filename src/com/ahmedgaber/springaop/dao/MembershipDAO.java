package com.ahmedgaber.springaop.dao;

import org.springframework.stereotype.Component;

@Component
public class MembershipDAO {

	public void addAccount() {
		System.out.println(getClass() + ": ADDING A MEMBERSHIP ACCOUNT addAccount()");
	}
	
	
	
	
}
