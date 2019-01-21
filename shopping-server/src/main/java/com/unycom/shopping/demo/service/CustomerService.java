package com.unycom.shopping.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.unycom.shopping.demo.entity.Customer;
import com.unycom.shopping.demo.jpa.CustomerRepository;

@Service
public class CustomerService {

	private final CustomerRepository customerRepository;

	public CustomerService(final CustomerRepository customerRepository) {
		this.customerRepository = customerRepository;
	}

	public List<Customer> findAll() {
		return customerRepository.findAll();
	}

	public Optional<Customer> findById(Long id) {
		return customerRepository.findById(id);
	}

	public Customer findByCode(String code) {
		return customerRepository.findByCode(code);
	}

}
