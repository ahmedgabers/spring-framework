package org.ahmedgaber.springrest.service;

import java.util.List;

import org.ahmedgaber.springrest.entity.Customer;

public interface CustomerService {

	public List<Customer> getCustomers();

	public void saveCustomer(Customer theCustomer);

	public Customer getCustomer(int theId);

	public void deleteCustomer(int theId);
	
}
