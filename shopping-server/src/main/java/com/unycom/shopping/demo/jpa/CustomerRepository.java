package com.unycom.shopping.demo.jpa;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.unycom.shopping.demo.entity.Customer;

@Transactional
public interface CustomerRepository extends JpaRepository<Customer, Long> {

	Customer findByCode(@Param("code") String code);
}
