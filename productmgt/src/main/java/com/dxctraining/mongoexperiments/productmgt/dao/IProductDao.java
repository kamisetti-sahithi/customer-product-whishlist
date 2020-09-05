package com.dxctraining.mongoexperiments.productmgt.dao;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.dxctraining.mongoexperiments.productmgt.entities.Product;

public interface IProductDao extends MongoRepository<Product, String> 
{
	List<Product> findByName(String name);
}
