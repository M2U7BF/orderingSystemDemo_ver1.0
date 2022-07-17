package com.example.ordering.form;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Form {
	private List<String> name;
	private List<String> salesUnit;
	private List<String> price;
	private List<String> numPurchase;
	private List<String> total;
	private String grandTotal;
}
