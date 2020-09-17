package com.capstone.soar.domain.projections.dev;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;

interface PastInventoryView {
	String getName();
	@Value("#{target.type.type}")
	String getType();
}


public interface PastRequestsView {
	Date getCreatedDate();
	String getDevRemarks();
	@Value("#{target.inventories}")
	List<PastInventoryView> getInventories();
	@Value("#{target.status.status}")
	String getStatus();
	String getManagerRemarks();
}
