package com.unycom.shopping.demo.entity;

import com.fasterxml.jackson.annotation.JsonValue;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum OrderStatus {
	ORDERED("Ordered"), CONFIRMED("Confirmed"), IN_PROGRESS("In Progress"), DELIVERED("Delivered");

	@Getter
	@JsonValue
	private final String name;

}
