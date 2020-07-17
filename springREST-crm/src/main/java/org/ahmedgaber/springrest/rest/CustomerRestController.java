package org.ahmedgaber.springrest.rest;

import java.util.List;

import org.ahmedgaber.springrest.entity.Customer;
import org.ahmedgaber.springrest.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class CustomerRestController {

		@Autowired
		private CustomerService customerService;
		
		@GetMapping("/customers")
		public List<Customer> getCustomers() {
			return customerService.getCustomers();
		}

}
