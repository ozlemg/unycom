package com.unycom.shopping.demo.controller;

import java.util.List;

import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.unycom.shopping.demo.entity.Customer;
import com.unycom.shopping.demo.entity.Order;
import com.unycom.shopping.demo.service.CustomerService;
import com.unycom.shopping.demo.service.OrderService;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ShoppingController {

	private final CustomerService customerService;
	private final OrderService orderService;

	public ShoppingController(final CustomerService customerService, final OrderService orderService) {
		this.customerService = customerService;
		this.orderService = orderService;
	}

	@RequestMapping("/customers")
	public ResponseEntity<List<Customer>> getCustomers() {
		return new ResponseEntity<>(customerService.findAll(), HttpStatus.OK);
	}

	@RequestMapping("/orders/{order_id}")
	public ResponseEntity<Order> getOrder(@PathVariable("order_id") Integer orderId) {
		Order order;
		try {
			order = orderService.findById(orderId);
		} catch (NotFoundException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(order, HttpStatus.OK);

	}

	@GetMapping(value = "/customers/{customer_code}")
	public ResponseEntity<Customer> getCustomer(@PathVariable("customer_code") String customerCode) {
		return new ResponseEntity<>(customerService.findByCode(customerCode), HttpStatus.OK);
	}

}
