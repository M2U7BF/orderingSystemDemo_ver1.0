package com.example.ordering.domain.service;

import java.util.List;

import com.example.ordering.domain.entity.Food;
import com.example.ordering.form.OrderForm;

public interface OrderService {
	//取り扱い食材の取得
	List<Food> findAll();
	
	//注文の登録 = crudRepository標準
	void insertOrder(OrderForm orderform);
	
	int logincheck();
}
