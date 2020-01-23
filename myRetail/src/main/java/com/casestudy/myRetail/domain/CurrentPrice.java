package com.casestudy.myRetail.domain;

import java.math.BigDecimal;

public class CurrentPrice {

	private BigDecimal value;
	private String currency_code;

	public CurrentPrice() {
	}

	public CurrentPrice(BigDecimal value, String currency_code) {
		this.value = value;
		this.currency_code = currency_code;
	}

	public BigDecimal getValue() {
		return value;
	}

	public void setValue(BigDecimal value) {
		this.value = value;
	}

	public String getCurrency_code() {
		return currency_code;
	}

	public void setCurrency_code(String currency_code) {
		this.currency_code = currency_code;
	}



}
