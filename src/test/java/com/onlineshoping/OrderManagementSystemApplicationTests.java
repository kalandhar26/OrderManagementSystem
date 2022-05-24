package com.onlineshoping;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.onlineshoping.model.OnlineShopping;
import com.onlineshoping.repos.OnlineShoppingRepository;

@SpringBootTest
class OrderManagementSystemApplicationTests {

	@Autowired
	OnlineShoppingRepository repository;

	@Test
	void contextLoads() {
	}

	@Test
	public void testCreateOrder() {
		OnlineShopping order = new OnlineShopping();
		order.setOrderName("Hair Dyer");
		order.setOrderPrice(45000d);
		order.setBrand("WAHL");

		repository.save(order);
	}

	@Test
	public void testUpdateOrder() {
		OnlineShopping order = repository.findById(7).get();
		order.setOrderName("Laptop");
		order.setOrderPrice(70000d);
		order.setBrand("Lenovo Legion");

		repository.save(order);

	}

	@Test
	public void testviewOrderById() {
		OnlineShopping order = repository.findById(1).get();
		assertNotNull(order);
		assertEquals("Mobile", order.getOrderName());
		assertEquals("Apple", order.getBrand());
		assertEquals(115000, order.getOrderPrice());
	}

	@Test
	public void testdeleteOrderById() {
		OnlineShopping order = repository.findById(5).get();
		repository.delete(order);
	}

}
