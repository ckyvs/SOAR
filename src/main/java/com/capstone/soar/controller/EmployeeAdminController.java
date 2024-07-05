package com.capstone.soar.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.capstone.soar.domain.projections.employee_admin.AdminAllEmployeesView;
import com.capstone.soar.domain.projections.employee_admin.AdminEmployeeView;
import com.capstone.soar.service.EmployeeService;


@RestController
@CrossOrigin(origins="http://localhost:4200")
public class EmployeeAdminController {
	
	@Autowired
	EmployeeService employeeService;
	
	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@GetMapping("/api/employee-admin")
	@PreAuthorize("hasAuthority('EMPLOYEE_ADMIN')")
	public List<AdminAllEmployeesView> getAllEmployees() {
		return employeeService.getAllEmployeeDetails();
	}
	
	@GetMapping("/api/employee/{id}")
	@PreAuthorize("hasAuthority('EMPLOYEE_ADMIN')")
	public AdminAllEmployeesView getEmployee(@PathVariable Long id) {
		return employeeService.getEmployeeDetails(id);
	}
	
	@PostMapping("/api/employee")
	@PreAuthorize("hasAuthority('EMPLOYEE_ADMIN')")
	public void addEmployee(@RequestBody AdminEmployeeView employee) {
		employeeService.addEmployee(employee);
	}
	
	@DeleteMapping("/api/employee/{id}")
	@PreAuthorize("hasAuthority('EMPLOYEE_ADMIN')")
	public void deleteEmployee(@PathVariable Long id) {
		employeeService.deleteEmployee(id);
	}
	
	@PutMapping("/api/employee/{id}")
	@PreAuthorize("hasAuthority('EMPLOYEE_ADMIN')")
	public void updateEmployee(@PathVariable Long id,@RequestBody AdminEmployeeView employee) {
		employeeService.updateEmployeeDetails(id, employee);
	}
}
