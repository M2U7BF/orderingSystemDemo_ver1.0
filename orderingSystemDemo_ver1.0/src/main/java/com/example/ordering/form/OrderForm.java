package com.example.ordering.form;

import java.util.List;

import lombok.Data;

@Data
public class OrderForm {
	private List<String> id;
	private List<String> name;
	private List<String> salesUnit;
	private List<String> price;
	private List<String> numPurchase;
	private List<String> total;
	private Integer grandTotal;
}
