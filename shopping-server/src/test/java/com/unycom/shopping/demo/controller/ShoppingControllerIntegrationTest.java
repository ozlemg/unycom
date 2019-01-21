package com.unycom.shopping.demo.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.unycom.shopping.demo.entity.Customer;
import com.unycom.shopping.demo.entity.Order;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ShoppingControllerIntegrationTest {

	@Autowired
	private TestRestTemplate restTemplate;

	@Test
	public void getCustomer() {
		ResponseEntity<Customer> responseEntity = restTemplate.getForEntity("/api/customers/308ff29881164e9f",
				Customer.class);
		Customer customer = responseEntity.getBody();
		assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
		assertEquals("308ff29881164e9f", customer.getCode());
	}

	@Test
	public void getCustomers() {
		ResponseEntity<Customer[]> responseEntity = restTemplate.getForEntity("/api/customers", Customer[].class);
		Customer[] customers = responseEntity.getBody();
		assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
		assertTrue(customers.length > 0);
	}

	@Test
	public void getOrder() {
		ResponseEntity<Order> responseEntity = restTemplate.getForEntity("/api/orders/3023", Order.class);
		Order order = responseEntity.getBody();
		assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
		assertEquals("3023", order.getId().toString());
	}
	
	@Test
	public void getOrderNotFound() {
		ResponseEntity<Order> responseEntity = restTemplate.getForEntity("/api/orders/52342", Order.class);
		assertEquals(HttpStatus.NOT_FOUND, responseEntity.getStatusCode());
	}
}
