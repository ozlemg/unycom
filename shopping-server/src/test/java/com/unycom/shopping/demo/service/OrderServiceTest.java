package com.unycom.shopping.demo.service;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderServiceTest {

	@Autowired
	OrderService orderService;

	@Test
	public void canThrowExceptionOnGetOrder() {
		assertThatThrownBy(() -> orderService.findById(new Integer(398523))).isInstanceOf(NotFoundException.class);
	}
}
