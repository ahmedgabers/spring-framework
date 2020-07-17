package org.ahmedgaber.springrest.dao;

import java.util.List;

import org.ahmedgaber.springrest.entity.Customer;

public interface CustomerDAO {

	public List<Customer> getCustomers();

	public void saveCustomer(Customer theCustomer);

	public Customer getCustomer(int theId);

	public void deleteCustomer(int theId);
	
}
