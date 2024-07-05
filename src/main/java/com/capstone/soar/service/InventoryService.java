package com.capstone.soar.service;

import java.util.List;
import java.util.Optional;

import javax.annotation.ManagedBean;

import org.springframework.beans.factory.annotation.Autowired;

import com.capstone.soar.domain.Inventory;
import com.capstone.soar.domain.projections.dev.DevInventoryView;
import com.capstone.soar.domain.projections.infra_admin.AdminInventoryReadOnlyView;
import com.capstone.soar.domain.projections.infra_admin.AdminInventoryView;
import com.capstone.soar.repository.InventoryRepository;
import com.capstone.soar.repository.InventoryTypeRepository;

@ManagedBean
public class InventoryService {
	
	@Autowired
	InventoryRepository inventoryRepo;
	
	@Autowired
	InventoryTypeRepository inventoryTypeRepo;
	
	public List<DevInventoryView> getDevItems() {
		return inventoryRepo.findAllProjectedBy();
	}
	
	public List<AdminInventoryReadOnlyView> getAdminItems() {
		return inventoryRepo.findEachProjectedBy();
	}
	
	public AdminInventoryReadOnlyView getOneAdminItem(Long id) {
		return inventoryRepo.findOneProjectedById(id);
	}
	
	public void addInventory(AdminInventoryView inventory) {
		Inventory inv = new Inventory();
		inv.setName(inventory.getName());
		inv.setType(inventoryTypeRepo.findOneByType(inventory.getType()));
		inv.setItemsInStock(inventory.getItemsInStock());
		inv.setCost(inventory.getCost());
		inv.setImage(inventory.getImage());
		inventoryRepo.saveAndFlush(inv);
	}
	
	public void updateInventory(Long id, AdminInventoryView inventory) {
		Optional<Inventory> invOptional = inventoryRepo.findById(id);
		if(invOptional.isPresent()) {
			Inventory inv = invOptional.get();
			inv.setName(inventory.getName());
			inv.setType(inventoryTypeRepo.findOneByType(inventory.getType()));
			inv.setItemsInStock(inventory.getItemsInStock());
			inv.setCost(inventory.getCost());
			inv.setImage(inventory.getImage());
			inventoryRepo.saveAndFlush(inv);
		}
	}

}
