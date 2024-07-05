package com.capstone.soar.domain.projections.manager;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Value;

public interface ManagerInventoryView {
	String getName();
	@Value("#{target.type.type}")
	String getType();
	BigDecimal getCost();
	byte[] getImage();
}