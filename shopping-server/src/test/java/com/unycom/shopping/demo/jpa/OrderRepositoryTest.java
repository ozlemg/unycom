package com.unycom.shopping.demo.jpa;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.Collection;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.unycom.shopping.demo.entity.Order;

@RunWith(SpringRunner.class)
@DataJpaTest
public class OrderRepositoryTest {

	@Autowired
	private OrderRepository orderRepository;

	@Test
	public void givenImportFileWhenFindAllShouldReturnAllOrders() {
		Collection<Order> orders = orderRepository.findAll();
		assertThat(orders.size()).isEqualTo(12);
	}

	@Test
	public void canFindOrder() {
		Optional<Order> order = orderRepository.findById(75603L);
		assertTrue(order.isPresent());
		assertTrue(order.get().getId().equals(75603L));
	}

	@Test
	public void canFindCustomerFromOrder() {
		Optional<Order> order = orderRepository.findById(75603L);
		assertTrue(order.isPresent());
		assertNotNull(order.get().getCustomer());
		assertEquals("724282cab24a40d4", order.get().getCustomer().getCode());
	}

	@Test
	public void canGetFinalPrice() {
		Optional<Order> order = orderRepository.findById(30520765L);
		assertNotNull(order.get().getFinalPrice());
	}

	@Test
	public void canCalculateDiscountUnder1000() {
		Optional<Order> order = orderRepository.findById(56055230L);
		assertEquals(891.0, order.get().getFinalPrice(), 0.1);
	}

	@Test
	public void canCalculateDiscountUnder1000Ceiling() {
		Optional<Order> order = orderRepository.findById(230586L);
		assertNotEquals(990.0, order.get().getFinalPrice(), 0.1);
	}

	@Test
	public void canCalculateDiscountUnder5000Floor() {
		Optional<Order> order = orderRepository.findById(230586L);
		assertEquals(980.0, order.get().getFinalPrice(), 0.1);
	}

	@Test
	public void canCalculateDiscountUnder5000() {
		Optional<Order> order = orderRepository.findById(75603L);
		assertEquals(2940.0, order.get().getFinalPrice(), 0.1);
	}

	@Test
	public void canCalculateDiscountUnder5000Ceiling() {
		Optional<Order> order = orderRepository.findById(987560L);
		assertNotEquals(4900.0, order.get().getFinalPrice());
	}

	@Test
	public void canCalculateDiscountUnder20000Floor() {
		Optional<Order> order = orderRepository.findById(987560L);
		assertEquals(4750.0, order.get().getFinalPrice(), 0.1);
	}

	@Test
	public void canCalculateDiscountUnder20000() {
		Optional<Order> order = orderRepository.findById(867605L);
		assertEquals(8550.0, order.get().getFinalPrice(), 0.1);
	}

	@Test
	public void canCalculateDiscountUnder20000Ceiling() {
		Optional<Order> order = orderRepository.findById(12302157L);
		assertNotEquals(19000.0, order.get().getFinalPrice());
	}

	@Test
	public void canCalculateDiscountMaxEquals20000Floor() {
		Optional<Order> order = orderRepository.findById(12302157L);
		assertEquals(18000.0, order.get().getFinalPrice(), 0.1);
	}

	@Test
	public void canCalculateDiscountMaxEquals20000() {
		Optional<Order> order = orderRepository.findById(2356765L);
		assertEquals(90000.0, order.get().getFinalPrice(), 0.1);
	}

}
