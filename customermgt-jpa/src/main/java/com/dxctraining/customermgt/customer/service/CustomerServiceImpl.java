package com.dxctraining.customermgt.customer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dxctraining.customermgt.customer.dao.ICustomerDao;
import com.dxctraining.customermgt.customer.entities.Customer;
import com.dxctraining.customermgt.customer.exceptions.CustomerNotFoundException;
import com.dxctraining.customermgt.customer.exceptions.InvalidArgumentException;

import java.util.List;
import java.util.Optional;

@Transactional
@Service
public class CustomerServiceImpl implements ICustomerService{

    @Autowired
    private ICustomerDao dao;

    @Override
    public Customer findCustomerById(int id) {
       Optional<Customer> optional= dao.findById(id);
       if(!optional.isPresent()){
           throw new CustomerNotFoundException("customer not found ");
       }
        Customer customer=optional.get();
        return customer;
    }
    
    @Override
    public List<Customer> findByName(String name) {
       List<Customer> list =dao.findByName(name);
       return list;
    }

    @Override
    public Customer save(Customer customer) {
        validate(customer);
       Customer result=dao.save(customer);
        return result;
    }

    private void validate(Customer customer) {
		if(customer == null) {
			throw new InvalidArgumentException("customer is null");
		}
		
	}
    @Override
    public List<Customer> findAllCustomers(){
        List<Customer>list = dao.findAll();
        return list;
    }

}
