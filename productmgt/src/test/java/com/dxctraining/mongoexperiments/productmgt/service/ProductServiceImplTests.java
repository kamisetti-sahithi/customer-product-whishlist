package com.dxctraining.mongoexperiments.productmgt.service;

import com.dxctraining.mongoexperiments.productmgt.entities.Product;
import com.dxctraining.mongoexperiments.productmgt.exceptions.InvalidArgumentException;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.function.Executable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@DataMongoTest
@Import(ProductServiceImpl.class)
public class ProductServiceImplTests {

	@Autowired
	private IProductService service;

	@Test
	public void testAdd_1() {
		Executable execute = () -> service.save(null);
		Assertions.assertThrows(InvalidArgumentException.class, execute);
	}

	@Test
	public void testAdd_2() {
		String name = "laptop";
		Product product = new Product(name);
		product = service.save(product);
		Product fetched = service.findById(product.getId());
		Assertions.assertEquals(product.getId(), fetched.getId());
		Assertions.assertEquals(name, fetched.getName());
	}

}
