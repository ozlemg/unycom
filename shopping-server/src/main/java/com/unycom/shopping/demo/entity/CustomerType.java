package com.unycom.shopping.demo.entity;

import com.fasterxml.jackson.annotation.JsonValue;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum CustomerType {
	POOR("Poor"), MINOR("Minor"), MAJOR("Major"), VIP("VIP");

	@Getter
	@JsonValue
	private final String name;

}
