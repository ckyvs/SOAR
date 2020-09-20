package com.capstone.soar.controller;

import java.util.HashSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.capstone.soar.domain.Cart;
import com.capstone.soar.domain.projections.dev.DevInventoryView;
import com.capstone.soar.domain.projections.dev.PastRequestsView;
import com.capstone.soar.service.CartService;
import com.capstone.soar.service.InventoryService;
import com.capstone.soar.service.RequestService;

@RestController
@CrossOrigin(origins="http://localhost:4200")
public class DeveloperController {
	
	
	@Autowired
	InventoryService inventoryService;
	
	@Autowired
	RequestService requestService;
	
	@Autowired
	CartService cartService;
	
	
	//Get the inventory items which can be requested
	@GetMapping("/get-inventory")
	@PreAuthorize("hasAuthority('DEVELOPER')")
	public List<DevInventoryView> getAllInventory() {
		return inventoryService.getDevItems();
	}
	
	//Get all the past requests put by the developer
	@GetMapping("/past-requests")
	@PreAuthorize("hasAuthority('DEVELOPER')")
	public List<PastRequestsView> getPastRequests() {
		return requestService.getPastRequestsDev();
	}
	
	//Get single request by developer
	@GetMapping("/past-requests/{id}")
	@PreAuthorize("hasAuthority('DEVELOPER')")
	public PastRequestsView getPastRequestById(@PathVariable Long id) {
		return requestService.getPastRequestByIdDev(id);
	}
	
	//Add items to cart
	@PostMapping("/add-cart")
	@PreAuthorize("hasAuthority('DEVELOPER')")
	public ResponseEntity<Void> addToCart(@RequestBody String inventoryName) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String username = auth.getName();
		cartService.addToCart(username, inventoryName);
		return ResponseEntity.ok().build();
	}
	
	//Get Cart items
	@GetMapping("/cart")
	@PreAuthorize("hasAuthority('DEVELOPER')")
	public Cart getCartItems() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String username = auth.getName();
		Cart cart = cartService.getCart(username);
		if(cart == null) {
			cart = new Cart();
			cart.setInventories(new HashSet<>());
			return cart;
		}
		return cart;
	}
	
	//Remove items from cart
	@PostMapping("/remove-cart")
	@PreAuthorize("hasAuthority('DEVELOPER')")
	public void removeFromCart(@RequestBody String inventoryName) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String username = auth.getName();
		cartService.removeFromCart(username, inventoryName);
	}
	
	//request items in cart
	@PostMapping("/request")
	@PreAuthorize("hasAuthority('DEVELOPER')")
	public void addRequest(@RequestBody String remarks) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String username = auth.getName();
		requestService.addRequest(remarks, username);
		cartService.clearCart(username);
	}
}
