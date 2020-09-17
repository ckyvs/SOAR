package com.capstone.soar.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capstone.soar.domain.Inventory;
import com.capstone.soar.service.InventoryService;

@RestController
public class InfrastructureAdminController {
	
	@Autowired
	InventoryService inventoryService;

	@GetMapping("/infra-admin")
	@PreAuthorize("hasRole('INFRA_ADMIN')")
	public List<Inventory> getAllInventory() {
		return inventoryService.getAllItems();
	}
}
