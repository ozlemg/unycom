package com.unycom.shopping.demo.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
@Entity
@Table(name = "customers")
public class Customer {

	@Id
	@GenericGenerator(name = "code", strategy = "com.unycom.shopping.demo.entity.CodeGenerator")
	@GeneratedValue(generator = "code")
	@Column(name = "code", length = 20)
	private String code;

	@Column(name = "name", length = 256)
	private String name;

	@Column(name = "location", length = 256)
	private String location;

	@Column(name = "registration_date")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm:ss")
	@Temporal(TemporalType.TIMESTAMP)
	private Date registrationDate;

	@Column(name = "is_active")
	private boolean active;

	@Enumerated(EnumType.ORDINAL)
	private CustomerType type;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "customer")
	public List<Order> orders = new ArrayList<>();
}
