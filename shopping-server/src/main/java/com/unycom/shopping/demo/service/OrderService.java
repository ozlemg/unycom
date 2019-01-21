package com.unycom.shopping.demo.service;

import java.util.List;

import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.stereotype.Service;

import com.unycom.shopping.demo.entity.Order;
import com.unycom.shopping.demo.jpa.OrderRepository;

@Service
public class OrderService {

	private final OrderRepository orderRepository;

	public OrderService(final OrderRepository orderRepository) {
		this.orderRepository = orderRepository;
	}

	public List<Order> findAll() {
		return orderRepository.findAll();
	}

	public Order findById(Long id) throws NotFoundException {
		return orderRepository.findById(id).orElseThrow(NotFoundException::new);
	}
}
