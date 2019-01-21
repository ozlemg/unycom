package com.unycom.shopping.demo.entity;

import java.io.Serializable;
import java.util.UUID;

import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

public class CodeGenerator implements IdentifierGenerator {

	@Override
	public Serializable generate(SharedSessionContractImplementor session, Object object) {
		UUID uuid = UUID.randomUUID();
		return Long.toHexString(uuid.getMostSignificantBits());
	}

}
