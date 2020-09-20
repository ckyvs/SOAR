package com.capstone.soar.service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.ManagedBean;

import org.springframework.beans.factory.annotation.Autowired;

import com.capstone.soar.domain.Cart;
import com.capstone.soar.domain.Employee;
import com.capstone.soar.domain.Inventory;
import com.capstone.soar.repository.CartRepository;
import com.capstone.soar.repository.EmployeeRepository;
import com.capstone.soar.repository.InventoryRepository;

@ManagedBean
public class CartService {
	
	@Autowired
	CartRepository cartRepo;
	
	@Autowired
	EmployeeRepository employeeRepo;
	
	@Autowired
	InventoryRepository inventoryRepo;
	
	public Cart getCart(String username) {
		Employee employee = employeeRepo.getEmployeeByEmail(username);
		System.out.println(cartRepo.findByEmployee(employee));
		return cartRepo.findByEmployee(employee);
	}
	
	public void addToCart(String username, String inventoryName) {
		Inventory inventory = inventoryRepo.findByName(inventoryName);
		inventory.setItemsInStock(inventory.getItemsInStock()-1);
		inventoryRepo.saveAndFlush(inventory);
		System.out.println(inventory);
		Employee employee = employeeRepo.getEmployeeByEmail(username);
		Cart cart = cartRepo.findByEmployee(employee);
		if(cart == null) {
			cart = new Cart();
			cart.setEmployee(employee);
			cart.setInventories(new HashSet<Inventory>());
		}
		Set<Inventory> updated = cart.getInventories();
		updated.add(inventory);
		cart.setInventories(updated);
		cartRepo.saveAndFlush(cart);
	}
	
	public void removeFromCart(String username, String inventoryName) {
		Inventory inventory = inventoryRepo.findByName(inventoryName);
		inventory.setItemsInStock(inventory.getItemsInStock()+1);
		inventoryRepo.saveAndFlush(inventory);
		System.out.println(inventory);
		Employee employee = employeeRepo.getEmployeeByEmail(username);
		Cart cart = cartRepo.findByEmployee(employee);
		Set<Inventory> updated = cart.getInventories();
		updated.remove(inventory);
		cart.setInventories(updated);
		cartRepo.saveAndFlush(cart);
	}
	
	public void clearCart(String username) {
		Employee employee = employeeRepo.getEmployeeByEmail(username);
		Cart cart = cartRepo.findByEmployee(employee);
		if(cart != null) {
			cart.setInventories(null);
			cartRepo.delete(cart);
		}
		cartRepo.flush();
	}
}
