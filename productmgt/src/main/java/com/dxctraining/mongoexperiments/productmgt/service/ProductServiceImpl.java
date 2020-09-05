package com.dxctraining.mongoexperiments.productmgt.service;

import com.dxctraining.mongoexperiments.productmgt.dao.IProductDao;
import com.dxctraining.mongoexperiments.productmgt.entities.Product;
import com.dxctraining.mongoexperiments.productmgt.exceptions.InvalidArgumentException;
import com.dxctraining.mongoexperiments.productmgt.exceptions.ProductNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements IProductService {

	@Autowired
	private IProductDao dao;

	@Override
	public Product save(Product product) {
		Product prod = validate(product);
		prod = dao.save(prod);
		return prod;
	}

	public Product validate(Product product) {
		if (product == null) {
			throw new InvalidArgumentException("product can't be null");
		}
		return product;
	}

	@Override
	public Product findById(String id) {
		Optional<Product> optional = dao.findById(id);
		boolean exist = optional.isPresent();
		if (!exist) {
			throw new ProductNotFoundException("product not found for id=" + id);
		}
		Product product = optional.get();
		return product;
	}

	@Override
	public List<Product> findByName(String name) {
		List<Product> list = dao.findByName(name);
		return list;
	}

}
