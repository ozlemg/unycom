package com.unycom.shopping.demo.jpa;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.unycom.shopping.demo.entity.Customer;

@RunWith(SpringRunner.class)
@DataJpaTest
public class CustomerRepositoryTest {

	@Autowired
	private CustomerRepository customerRepository;

	@Test
	public void givenImportFileWhenFindAllShouldReturnAllCustomers() {
		Collection<Customer> customers = customerRepository.findAll();
		assertThat(customers.size()).isEqualTo(4);
	}

	@Test
	public void canFindCustomer() {
		Customer customer = customerRepository.findByCode("308ff29881164e9f");
		assertEquals("308ff29881164e9f", customer.getCode());
		assertEquals("Luke Skywalker", customer.getName());
	}

	@Test
	public void canFindCustomerOrders() {
		Customer customer = customerRepository.findByCode("bb6f6222517c46c1");
		assertEquals("bb6f6222517c46c1", customer.getCode());
		assertNotNull(customer.getOrders());
	}

}
