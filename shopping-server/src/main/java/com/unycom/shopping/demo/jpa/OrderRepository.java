package com.unycom.shopping.demo.jpa;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.unycom.shopping.demo.entity.Order;

@Transactional
public interface OrderRepository extends JpaRepository<Order, Integer> {

}
