package com.dxctraining.mongoexperiments.productmgt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories
public class ProductmgtApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductmgtApplication.class, args);

	}

}
