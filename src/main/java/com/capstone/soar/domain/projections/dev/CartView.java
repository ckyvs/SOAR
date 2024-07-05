package com.capstone.soar.domain.projections.dev;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;

public class CartView {
	@Value("#{target.inventories")
	private List<DevInventoryView> inventories;
	String remarks;
	
	
	public void setInventories(List<DevInventoryView> inventories) {
		this.inventories = inventories;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	
	List<DevInventoryView> getInventories(){
		return this.inventories;
	}
	String getRemarks() {
		return this.remarks;
	}
}

