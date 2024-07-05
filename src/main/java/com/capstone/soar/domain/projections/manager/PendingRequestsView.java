package com.capstone.soar.domain.projections.manager;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;



public interface PendingRequestsView {
	Long getId();
	@Value("#{target.employee}")
	ManagerEmployeeView getEmployee();
	Date createdDate();
	@Value("#{target.inventories}")
	List<ManagerInventoryView> getInventories();
	String getDevRemarks();
	int getTotalItems();
	BigDecimal getTotalCost();
}