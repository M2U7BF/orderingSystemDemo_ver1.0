package com.example.ordering.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Food {
	private Integer id;
	private String name;
	private String salesUnit;
	private Integer price;
}
