package com.capstone.soar.service;

import java.util.List;

import javax.annotation.ManagedBean;

import org.springframework.beans.factory.annotation.Autowired;

import com.capstone.soar.domain.Employee;
import com.capstone.soar.domain.projections.employee_admin.AdminAllEmployeesView;
import com.capstone.soar.repository.EmployeeRepository;

@ManagedBean
public class EmployeeService {
	
	@Autowired
	EmployeeRepository employeeRepo;
	
	public List<AdminAllEmployeesView> getAllEmployeeDetails() {
		return employeeRepo.findAllProjectedBy();
	}
	
	public void addEmployee(Employee employee) {
		employeeRepo.save(employee);
	}
	
	public void updateEmployeeDetails(Long id, Employee employee) {
		if(employeeRepo.findById(id).isPresent())
			employeeRepo.save(employee);
	}
	
	public Employee getEmployeeDetails(Long id) {
		return employeeRepo.getOne(id);
	}
	
	public Employee getSelfDetails(String username) {
		return employeeRepo.getEmployeeByEmail(username);
	}
	
}
