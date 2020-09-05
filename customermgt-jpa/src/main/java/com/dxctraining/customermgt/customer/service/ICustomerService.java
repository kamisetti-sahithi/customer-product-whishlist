package com.dxctraining.customermgt.customer.service;


import java.util.List;

import com.dxctraining.customermgt.customer.entities.*;

public interface ICustomerService {

	Customer findCustomerById(int id);
	
	List<Customer> findByName(String name);
	
	Customer save(Customer customer);

	List<Customer> findAllCustomers();

}
