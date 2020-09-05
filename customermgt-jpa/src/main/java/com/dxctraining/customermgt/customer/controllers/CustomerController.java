package com.dxctraining.customermgt.customer.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import com.dxctraining.customermgt.customer.dto.CreateCustomerRequest;
import com.dxctraining.customermgt.customer.dto.CustomerDto;
import com.dxctraining.customermgt.customer.entities.Customer;
import com.dxctraining.customermgt.customer.service.ICustomerService;
import com.dxctraining.customermgt.customer.util.CustomerUtil;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    @Autowired
    private ICustomerService customerservice;

    @Autowired
    private CustomerUtil customerUtil;
    
    @PostMapping("/add")
	@ResponseStatus(HttpStatus.CREATED)
	public CustomerDto addCustomer(@RequestBody CreateCustomerRequest requestData) {
		Customer customer = new Customer(requestData.getName());
		customer = customerservice.save(customer);
		CustomerDto response = customerUtil.customerDto(customer);
		return response;
	}
    
    @GetMapping("/get/{id}")
	@ResponseStatus(HttpStatus.OK)
	public CustomerDto findCustomerById(@PathVariable("id")int id) {
		Customer customer = customerservice.findCustomerById(id);
		CustomerDto response = customerUtil.customerDto(customer);
		return response;
	}
    
    @GetMapping("/allcustomers")
	@ResponseStatus(HttpStatus.CREATED)
	public List<CustomerDto> fetchAll(){
		List<Customer>list=customerservice.findAllCustomers();
		List<CustomerDto> response=new ArrayList<>();
		for(Customer customer:list) {
			CustomerDto dto=customerUtil.customerDto(customer);
			response.add(dto);
		}
		return response;
	}
    
}




