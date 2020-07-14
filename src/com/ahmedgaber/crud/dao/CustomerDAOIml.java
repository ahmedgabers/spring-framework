package com.ahmedgaber.crud.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.ahmedgaber.crud.entity.Customer;

public class CustomerDAOIml implements CustomerDAO {

	
	@Autowired
	private SessionFactory sessionFactory;
	
	
	@Override
	@Transactional
	public List<Customer> getCustomers() {
		// get the current hibernate session
		// create a query and get result list
		
		return null;
	}

}
