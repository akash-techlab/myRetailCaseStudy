package com.casestudy.myRetail.service;

import java.util.Map;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.casestudy.myRetail.exception.ExceptionHandler;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class RetailService {
	
	@Value("${REDSKY_SERVICE_URL}")
	String redsky_service_url;
	@Value("${REDSKY_EXCLUDED_PARAMS}")
	String redsky_excluded_params;
	
	@Autowired
	RestTemplate restTemplate;

	
	private Logger logger = Logger.getLogger(RetailService.class.getName());

	public String fetchProductTitle(Integer id) throws ExceptionHandler {
		ObjectMapper mapper = new ObjectMapper();
		
		StringBuffer endpoint = new StringBuffer(redsky_service_url);
		endpoint.append(id);
		endpoint.append(redsky_excluded_params);
		
		try {
			ResponseEntity<String> responseFromService = restTemplate.getForEntity(endpoint.toString(), String.class);
			Map<String, Map> responseData = mapper.readValue(responseFromService.getBody(), Map.class);
			Map<String, Map> product = responseData.get("product");
			Map<String, Map> item = product.get("item");
			Map<String, String> prodDesc= item.get("product_description");
			String title = prodDesc.get("title");
			return title;
		} catch (Exception e) { 
			throw new ExceptionHandler("product not found");// catch/throw exception when product is not found
		}

	}

}
