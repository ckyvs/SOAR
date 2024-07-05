package com.capstone.soar.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.capstone.soar.domain.projections.SelfDetails;
import com.capstone.soar.domain.projections.SelfDetailsProjection;
import com.capstone.soar.service.EmployeeService;

@RestController
@CrossOrigin(origins="http://localhost:4200")
public class EmployeeController {
	
	@Autowired
	EmployeeService employeeService;
	
	@GetMapping("/api/profile")
	public SelfDetailsProjection getSelf() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String username = auth.getName();
		return employeeService.getSelfDetails(username);
	}
	
	@PostMapping("/api/profile")
	public void updateSelf(@RequestBody SelfDetails self) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String username = auth.getName();
		employeeService.updateSelf(username, self);
	}
	
}
