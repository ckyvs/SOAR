package com.capstone.soar.domain.projections.infra_admin;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Value;

public interface AdminInventoryReadOnlyView {
	Long getId();
	String getName();
	@Value("#{target.type.type}")
	String getType();
	int getItemsInStock();
	BigDecimal getCost();
	byte[] getImage();
}
