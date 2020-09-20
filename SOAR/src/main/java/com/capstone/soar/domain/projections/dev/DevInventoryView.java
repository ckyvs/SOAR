package com.capstone.soar.domain.projections.dev;

import org.springframework.beans.factory.annotation.Value;

public interface DevInventoryView {
	String getName();
	int getItemsInStock();
	@Value("#{target.type.type}")
	String getType();
	byte[] getImage();
}