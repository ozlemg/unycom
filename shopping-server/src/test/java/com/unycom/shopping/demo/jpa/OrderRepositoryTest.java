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
		Optional<Order> order = orderRepository.findById(new Integer(75603));
		assertTrue(order.isPresent());
		assertTrue(new Integer(75603).equals(order.get().getId()));
	}

	@Test
	public void canFindCustomerFromOrder() {
		Optional<Order> order = orderRepository.findById(new Integer(75603));
		assertTrue(order.isPresent());
		assertNotNull(order.get().getCustomer());
		assertEquals("724282cab24a40d4", order.get().getCustomer().getCode());
	}

	@Test
	public void canGetFinalPrice() {
		Optional<Order> order = orderRepository.findById(new Integer(30520765));
		assertNotNull(order.get().getFinalPrice());
	}

	@Test
	public void canCalculateDiscountUnder1000() {
		Optional<Order> order = orderRepository.findById(new Integer(56055230));
		assertEquals(891.0, order.get().getFinalPrice(), 0.1);
	}

	@Test
	public void canCalculateDiscountUnder1000Ceiling() {
		Optional<Order> order = orderRepository.findById(new Integer(230586));
		assertNotEquals(990.0, order.get().getFinalPrice(), 0.1);
	}

	@Test
	public void canCalculateDiscountUnder5000Floor() {
		Optional<Order> order = orderRepository.findById(new Integer(230586));
		assertEquals(980.0, order.get().getFinalPrice(), 0.1);
	}

	@Test
	public void canCalculateDiscountUnder5000() {
		Optional<Order> order = orderRepository.findById(new Integer(75603));
		assertEquals(2940.0, order.get().getFinalPrice(), 0.1);
	}

	@Test
	public void canCalculateDiscountUnder5000Ceiling() {
		Optional<Order> order = orderRepository.findById(new Integer(987560));
		assertNotEquals(4900.0, order.get().getFinalPrice());
	}

	@Test
	public void canCalculateDiscountUnder20000Floor() {
		Optional<Order> order = orderRepository.findById(new Integer(987560));
		assertEquals(4750.0, order.get().getFinalPrice(), 0.1);
	}

	@Test
	public void canCalculateDiscountUnder20000() {
		Optional<Order> order = orderRepository.findById(new Integer(867605));
		assertEquals(8550.0, order.get().getFinalPrice(), 0.1);
	}

	@Test
	public void canCalculateDiscountUnder20000Ceiling() {
		Optional<Order> order = orderRepository.findById(new Integer(12302157));
		assertNotEquals(19000.0, order.get().getFinalPrice());
	}

	@Test
	public void canCalculateDiscountMaxEquals20000Floor() {
		Optional<Order> order = orderRepository.findById(new Integer(12302157));
		assertEquals(18000.0, order.get().getFinalPrice(), 0.1);
	}

	@Test
	public void canCalculateDiscountMaxEquals20000() {
		Optional<Order> order = orderRepository.findById(new Integer(2356765));
		assertEquals(90000.0, order.get().getFinalPrice(), 0.1);
	}

}
