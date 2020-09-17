package com.capstone.soar.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.capstone.soar.domain.projections.dev.DevInventoryView;
import com.capstone.soar.domain.projections.dev.PastRequestsView;
import com.capstone.soar.service.CartService;
import com.capstone.soar.service.InventoryService;
import com.capstone.soar.service.RequestService;

@RestController
public class DeveloperController {
	
	
	@Autowired
	InventoryService inventoryService;
	
	@Autowired
	RequestService requestService;
	
	@Autowired
	CartService cartService;
	
	
	//Get the inventory items which can be requested
	@GetMapping("/get-inventory")
	@PreAuthorize("hasRole('DEVELOPER')")
	public List<DevInventoryView> getAllInventory() {
		return inventoryService.getDevItems();
	}
	
	//Get all the past requests put by the developer
	@GetMapping("/past-requests")
	@PreAuthorize("hasRole('DEVELOPER')")
	public List<PastRequestsView> getPastRequests() {
		return requestService.getPastRequestsDev();
	}
	
	//Add items to cart
	@PostMapping("/add-cart")
	@PreAuthorize("hasRole('DEVELOPER')")
	public void addToCart(@RequestBody String inventoryName) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String username = auth.getName();
		cartService.addToCart(username, inventoryName);
	}
	
	//Remove items from cart
	@PostMapping("/remove-cart")
	@PreAuthorize("hasRole('DEVELOPER')")
	public void removeFromCart(@RequestBody String inventoryName) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String username = auth.getName();
		cartService.removeFromCart(username, inventoryName);
	}
	
	//request items in cart
	@PostMapping("/request")
	@PreAuthorize("hasRole('DEVELOPER')")
	public void addRequest() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String username = auth.getName();
		requestService.addRequest(username);
		cartService.clearCart(username);
	}
}
