package com.dxctraining.mongoexperiments.productmgt.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.dxctraining.mongoexperiments.productmgt.dto.CreateProductRequest;
import com.dxctraining.mongoexperiments.productmgt.dto.ProductDto;
import com.dxctraining.mongoexperiments.productmgt.entities.Product;
import com.dxctraining.mongoexperiments.productmgt.service.IProductService;
import com.dxctraining.mongoexperiments.productmgt.util.ProductUtil;

@RestController
@RequestMapping("/products")
public class ProductController {
	
	@Autowired
	private IProductService service;
	
	@Autowired
	private ProductUtil productUtil; 
	
	@PostMapping("/add")
	@ResponseStatus(HttpStatus.CREATED)
	public ProductDto addSupplier(@RequestBody CreateProductRequest requestData) {
		Product product = new Product(requestData.getName());
		product = service.save(product);
		ProductDto response = productUtil.productDto(product);
		return response;
	}
	
	@GetMapping("/get/{id}")
	@ResponseStatus(HttpStatus.OK)
	public ProductDto findSupplierById(@PathVariable("id")String id) {
		Product product = service.findById(id);
		ProductDto response = productUtil.productDto(product);
		return response;
	}
    
	@GetMapping("/get/product/{name}")
	@ResponseStatus(HttpStatus.OK)
	public List<ProductDto> findProductByName(@PathVariable("name")String name) 
	{   
		List<ProductDto> toreturn=new ArrayList<>();
		List<Product>list = service.findByName(name);
		for(Product variable:list)
		{	
		ProductDto response = productUtil.productDto(variable);
		toreturn.add(response);
		}
		return toreturn;
	}

}