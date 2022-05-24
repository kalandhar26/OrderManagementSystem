package com.onlineshoping.service;

import org.springframework.stereotype.Service;

import com.onlineshoping.exception.OrderNotFoundException;
import com.onlineshoping.model.OnlineShopping;
import com.onlineshoping.repos.OnlineShoppingRepository;

@Service
public class OrderServiceImpl implements OrderService {

	/*
	 * We are not required to annoate property with Autowired annotation. Spring
	 * data JPA knows it has only one bean
	 */

	private OnlineShoppingRepository repository;

	public OrderServiceImpl(OnlineShoppingRepository repository) {
		super();
		this.repository = repository;
	}

	@Override
	public OnlineShopping saveOrder(OnlineShopping order) {

		return repository.save(order);
	}

	@Override
	public Iterable<OnlineShopping> getAllOrders() {

		return repository.findAll();
	}

	@Override
	public OnlineShopping getOrderById(int id) {	

//		Optional<OnlineShopping> order = repository.findById(id);
//		
//		if(order.isPresent()) {
//			return order.get();
//		}else {
//			throw new OrderNotFoundException("Order", "Id", id);
//		}
// -----------------------------------or ---------------------------------
		 return repository.findById(id).orElseThrow(() -> new
		 OrderNotFoundException("Order", "Id", id));

	}

	@Override
	public OnlineShopping updateOrder(OnlineShopping order, int id) {

		// Checking Order existing in DB or Not
		OnlineShopping existingOrder = repository.findById(id)
				.orElseThrow(() -> new OrderNotFoundException("Order", "Id", id));

		existingOrder.setOrderName(order.getOrderName());
		existingOrder.setOrderPrice(order.getOrderPrice());
		existingOrder.setBrand(order.getBrand());

		// Saving existing order with modified data in DB
		return repository.save(existingOrder);
	}

	@Override
	public void removeOrderById(int id) {

		// checking whether id existing in DB or not
		repository.findById(id).orElseThrow(() -> new OrderNotFoundException("Order", "Id", id));
		// if present deleting the order
		repository.deleteById(id);

	}

}
