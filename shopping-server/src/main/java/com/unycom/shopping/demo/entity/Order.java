package com.unycom.shopping.demo.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PostLoad;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
@Entity
@Table(name = "orders")
public class Order {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", nullable = false, columnDefinition = "INT(10)")
	private Integer id;

	@Column(name = "order_date")
	@Temporal(TemporalType.TIMESTAMP)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm:ss")
	private Date orderDate;

	@Column(name = "confirm_date")
	@Temporal(TemporalType.TIMESTAMP)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm:ss")
	private Date confirmDate;

	@Column(name = "complete_date")
	@Temporal(TemporalType.TIMESTAMP)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm:ss")
	private Date completeDate;

	@Column(name = "product", length = 256)
	private String product;

	@Column(name = "price", columnDefinition = "NUMBER(10)")
	private Double originalPrice;

	@Transient
	private Double finalPrice;

	@Enumerated(EnumType.ORDINAL)
	private OrderStatus status;

	@ManyToOne
	@JoinColumn(name = "customer_code", referencedColumnName = "code", nullable = false)
	@JsonIgnore
	private Customer customer;

	@PostLoad
	private void calculateFinalPrice() {
		if (null != this.getOriginalPrice()) {
			Double price = this.getOriginalPrice();
			if (price < 1000) {
				price = price - 0.01 * price;
			} else if (price < 5000) {
				price = price - 0.02 * price;
			} else if (price < 20000) {
				price = price - 0.05 * price;
			} else {
				price = price - 0.1 * price;
			}
			this.setFinalPrice(price);
		}
	}

}
