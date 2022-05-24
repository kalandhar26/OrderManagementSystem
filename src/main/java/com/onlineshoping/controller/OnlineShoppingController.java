package com.onlineshoping.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.onlineshoping.model.OnlineShopping;
import com.onlineshoping.service.OrderService;

@RestController
@RequestMapping("/api")
public class OnlineShoppingController {

	private OrderService orderService;

	public OnlineShoppingController(OrderService orderService) {
		super();
		this.orderService = orderService;
	}

	// build create an Order REST API
    // http://localhost:8081/api/order
	@PostMapping("/order")
	public ResponseEntity<OnlineShopping> createAnOrder(@RequestBody OnlineShopping order) {
		return new ResponseEntity<OnlineShopping>(orderService.saveOrder(order), HttpStatus.CREATED);
	}

	// build to retrieve all order from DB using REST API
	// http://localhost:8081/api/order
	@GetMapping("/order")
	public Iterable<OnlineShopping> getAllOrders() {
		return orderService.getAllOrders();
	}

	// Rest API to get Order by ID
	// http://localhost:8081/api/order/1
	@GetMapping("/order/{id}")
	public ResponseEntity<OnlineShopping> getOrderById(@PathVariable("id") int id) {
		return new ResponseEntity<OnlineShopping>(orderService.getOrderById(id), HttpStatus.OK);
	}

	// Rest API to update Order by ID
	// http://localhost:8081/api/order/1
	@PutMapping("/order/{id}")
	public ResponseEntity<OnlineShopping> updateOrderById(@PathVariable("id") int id, @RequestBody OnlineShopping order) {
		return new ResponseEntity<OnlineShopping>(orderService.updateOrder(order, id), HttpStatus.OK);
	}
	
	// Rest API to delete Order by ID
	// http://localhost:8081/api/order/1
	@DeleteMapping("/order/{id}")
	public ResponseEntity<String> deleteOrderById(@PathVariable("id") int id) {
		orderService.removeOrderById(id);
		return new ResponseEntity<String>("Employee deleted Successfully.!", HttpStatus.OK);
	}

}
