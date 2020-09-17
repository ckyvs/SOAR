package com.capstone.soar.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.capstone.soar.domain.Employee;
import com.capstone.soar.domain.projections.employee_admin.AdminAllEmployeesView;
import com.capstone.soar.service.EmployeeService;


@RestController

public class EmployeeAdminController {
	
	@Autowired
	EmployeeService employeeService;
	
	@GetMapping("/employee-admin")
	@PreAuthorize("hasRole('EMPLOYEE_ADMIN')")
	public List<AdminAllEmployeesView> getAllEmployees() {
		return employeeService.getAllEmployeeDetails();
	}
	
	@GetMapping("/employee/{id}")
	@PreAuthorize("hasRole('EMPLOYEE_ADMIN')")
	public Employee getEmployee(@PathVariable Long id) {
		return employeeService.getEmployeeDetails(id);
	}
	
	@PostMapping("/employee")
	@PreAuthorize("hasRole('EMPLOYEE_ADMIN')")
	public void addEmployee(@RequestBody Employee employee) {
		employeeService.addEmployee(employee);
	}
	
	@PutMapping("/employee/{id}")
	@PreAuthorize("hasRole('EMPLOYEE_ADMIN')")
	public void updateEmployee(@PathVariable Long id,@RequestBody Employee employee) {
		employeeService.updateEmployeeDetails(id, employee);
	}
}
