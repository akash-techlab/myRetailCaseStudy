
package com.casestudy.myRetail.domain;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "products")
public class Products {

    private int id;
    private String name;
    private CurrentPrice currentPrice;
    
    
    public Products() {
    }
    
    public Products(int id, String name, CurrentPrice currentPrice) {
       this.id = id;
       this.name = name;
       this.currentPrice = currentPrice;
    }

    public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}


   public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CurrentPrice getCurrentPrice() {
        return currentPrice;
    }

    public void setCurrentPrice(CurrentPrice currentPrice) {
        this.currentPrice = currentPrice;
    }
    
    


}
