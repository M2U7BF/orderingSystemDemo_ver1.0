package com.example.ordering.domain.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.ordering.form.OrderForm;

public interface OrderRepository  extends CrudRepository<OrderForm, Integer> {

}
