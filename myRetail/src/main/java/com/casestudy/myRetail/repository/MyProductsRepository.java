package com.casestudy.myRetail.repository;


import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.casestudy.myRetail.domain.Products;


@Repository
public interface MyProductsRepository extends MongoRepository<Products, Integer> {
	
	
}
