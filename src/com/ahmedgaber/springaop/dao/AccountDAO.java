package com.ahmedgaber.springaop.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.ahmedgaber.springaop.Account;

@Component
public class AccountDAO {
	
	private String name;
	private String serviceCode;
	
	
	public List<Account> findAccounts() {
		List<Account> myAccounts = new ArrayList<>();
		
		Account temp1 = new Account("Sara", "Silver");
		Account temp2 = new Account("Ahmed", "Platinum");
		Account temp3 = new Account("xeon", "Gold");
		
		myAccounts.add(temp1);
		myAccounts.add(temp2);
		myAccounts.add(temp2);
		
		return myAccounts;
	}
	
	public List<Account> findAccountsException(boolean tripWire) {
		
		
		if(tripWire) {
			throw new RuntimeException("RuntimeException here");
		}
		
		List<Account> myAccounts = new ArrayList<>();
		
		Account temp1 = new Account("Sara", "Silver");
		Account temp2 = new Account("Ahmed", "Platinum");
		Account temp3 = new Account("xeon", "Gold");
		
		myAccounts.add(temp1);
		myAccounts.add(temp2);
		myAccounts.add(temp2);
		
		return myAccounts;
	}
	
	
	
	public String getName() {
		System.out.println(getClass() + ": getName");
		return name;
	}

	public void setName(String name) {
		System.out.println(getClass() + ": setName");
		this.name = name;
	}

	public String getServiceCode() {
		System.out.println(getClass() + ": getServiceCode");
		return serviceCode;
	}

	public void setServiceCode(String serviceCode) {
		System.out.println(getClass() + ": setServiceCode");

		this.serviceCode = serviceCode;
	}

	public void addAccount(Account theAccount, boolean flag) {
		System.out.println(getClass() + ": AccountDAO.addAccount()");
	}
	
	public void doWork() {
		System.out.println(getClass() + ": AccountDAO.doWork()");
	}


	
}
