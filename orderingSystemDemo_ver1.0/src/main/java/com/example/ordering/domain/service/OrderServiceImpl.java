package com.example.ordering.domain.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ordering.domain.entity.Food;
import com.example.ordering.domain.repository.OrderRepository;
import com.example.ordering.form.OrderForm;

@Service
public class OrderServiceImpl implements OrderService{
	@Autowired
	OrderRepository repository;
	
	@Override
	public List<Food> findAll(){
		return List.of(
			new Food(11, "芽キャベツ1", "1kg", 700),
			new Food(12, "芽キャベツ2", "1束", 80),
			new Food(13, "芽キャベツ3", "1個", 30),
			new Food(14, "芽キャベツ4", "1kg", 550),
			new Food(15, "芽キャベツ5", "1kg", 630),
			new Food(16, "芽キャベツ6", "1kg", 410),
			new Food(17, "芽キャベツ7", "1kg", 312),
			new Food(18, "芽キャベツ8", "1kg", 520),
			new Food(19, "芽キャベツ9", "1kg", 633),
			new Food(110, "芽キャベツ10", "1kg", 610),
			new Food(21, "ポンカン1", "1kg", 1200),
			new Food(22, "ポンカン2", "1袋", 420),
			new Food(23, "ポンカン3", "1個", 130),
			new Food(24, "ポンカン4", "1kg", 450),
			new Food(25, "ポンカン5", "1kg", 830),
			new Food(26, "ポンカン6", "1kg", 910),
			new Food(27, "ポンカン7", "1kg", 1012),
			new Food(28, "ポンカン8", "1kg", 920),
			new Food(29, "ポンカン9", "1kg", 733),
			new Food(210, "ポンカン10", "1kg", 510)
		);
	}

	@Override
	public int logincheck() {
		// TODO 自動生成されたメソッド・スタブ
		return 0;
	}

	@Override
	public void insertOrder(OrderForm orderform) {
		List<String> idList = orderform.getId();
		List<String> nameList = orderform.getName();
		List<String> salesUnitList = orderform.getSalesUnit();
		List<String> priceList = orderform.getPrice();
		List<String> numPurchaseList = orderform.getNumPurchase();
		List<String> totalList = orderform.getTotal();
		Integer grandTotal = orderform.getGrandTotal();
		
		for(String id: idList) {
			repository.save(id);
		}
//			repository.save(order);
	}
}
