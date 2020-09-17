package com.capstone.soar.service;

import java.util.List;

import javax.annotation.ManagedBean;

import org.springframework.beans.factory.annotation.Autowired;

import com.capstone.soar.domain.Inventory;
import com.capstone.soar.domain.projections.dev.DevInventoryView;
import com.capstone.soar.repository.InventoryRepository;

@ManagedBean
public class InventoryService {
	
	@Autowired
	InventoryRepository inventoryRepo;
	
	public List<DevInventoryView> getDevItems() {
		return inventoryRepo.findAllProjectedBy();
	}
	
	public List<Inventory> getAllItems() {
		return inventoryRepo.findAll();
	}
}
