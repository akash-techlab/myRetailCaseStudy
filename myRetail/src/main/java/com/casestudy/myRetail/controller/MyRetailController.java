package com.casestudy.myRetail.controller;

import java.util.Optional;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.casestudy.myRetail.domain.CurrentPrice;
import com.casestudy.myRetail.domain.ProductDetails;
import com.casestudy.myRetail.domain.Products;
import com.casestudy.myRetail.exception.ExceptionHandler;
import com.casestudy.myRetail.repository.MyProductsRepository;
import com.casestudy.myRetail.service.RetailService;

@RestController
public class MyRetailController {
    
	private Logger logger = Logger.getLogger(MyRetailController.class.getName());

	@Autowired
	RetailService service;
	
	@Autowired
	MyProductsRepository repository;
	

	@GetMapping("/products/{productId}")
	public ProductDetails getProductInfo(@PathVariable("productId") Integer productId) throws ExceptionHandler {
		logger.info("MyRetailController getProductInfo invoked: ");
		String title = service.fetchProductTitle(productId); // Get the Product Title from Red SKY External service
		CurrentPrice price =null;
		if(title==null) {
			throw new ExceptionHandler(":::::Product not found in the RED SKY Reponse::::: ");
		}
	    Optional<Products> mongoData = repository.findById(productId); // Get the Document from DB for the product Id
	    if(mongoData==null) {
	    	throw new ExceptionHandler(":::::Product not found in the DB::::: ");
	    }
	    else {
	    	price = mongoData.get().getCurrentPrice();
	    }
	    logger.info("MyRetailController getProductInfo exit: ");
		return new ProductDetails(productId, title,price);
	}
	
	
	  @PutMapping(value = "/products/{id}")
	    public Products updateItemPrice(@PathVariable Integer id, @RequestBody Products product) throws ExceptionHandler {
		  logger.info("MyRetailController updateItemPrice invoked: ");
	        if (!(repository.existsById(id))) {
	            throw new ExceptionHandler("Item for Price update not found");
	        }
	        logger.info("MyRetailController updateItemPrice exit: ");
	        return repository.save(product);
	    }

}
