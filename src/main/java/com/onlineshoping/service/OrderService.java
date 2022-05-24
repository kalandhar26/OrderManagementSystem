package com.onlineshoping.service;

import com.onlineshoping.model.OnlineShopping;

public interface OrderService {

	OnlineShopping saveOrder(OnlineShopping order);
	Iterable<OnlineShopping> getAllOrders();
	OnlineShopping getOrderById(int id);
	OnlineShopping updateOrder(OnlineShopping order, int id);
	void removeOrderById(int id);
	

}
