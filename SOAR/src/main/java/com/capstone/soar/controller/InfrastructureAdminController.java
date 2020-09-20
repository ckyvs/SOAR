package com.capstone.soar.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.capstone.soar.domain.projections.infra_admin.AdminInventoryReadOnlyView;
import com.capstone.soar.domain.projections.infra_admin.AdminInventoryView;
import com.capstone.soar.service.InventoryService;

@RestController
@CrossOrigin(origins="http://localhost:4200")
public class InfrastructureAdminController {
	
	@Autowired
	InventoryService inventoryService;

	@GetMapping("/infra-admin")
	@PreAuthorize("hasAuthority('INFRA_ADMIN')")
	public List<AdminInventoryReadOnlyView> getAllInventory() {
		return inventoryService.getAdminItems();
	}
	
	@PostMapping("/add-inventory")
	@PreAuthorize("hasAuthority('INFRA_ADMIN')")
	public void addInventory(@RequestBody AdminInventoryView inventory){
		inventoryService.addInventory(inventory);
	}
	
	@PutMapping("/update-inventory/{id}")
	@PreAuthorize("hasAuthority('INFRA_ADMIN')")
	public void updateInventory(@PathVariable Long id, @RequestBody AdminInventoryView inventory){
		inventoryService.updateInventory(id, inventory);
	}
	
	@GetMapping("/inventory/{id}")
	@PreAuthorize("hasAuthority('INFRA_ADMIN')")
	public AdminInventoryReadOnlyView getOneInventory(@PathVariable Long id) {
		return inventoryService.getOneAdminItem(id);
	}
}
