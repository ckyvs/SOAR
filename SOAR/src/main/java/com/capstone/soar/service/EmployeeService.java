package com.capstone.soar.service;

import java.util.List;

import javax.annotation.ManagedBean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.capstone.soar.domain.Employee;
import com.capstone.soar.domain.projections.SelfDetails;
import com.capstone.soar.domain.projections.SelfDetailsProjection;
import com.capstone.soar.domain.projections.employee_admin.AdminAllEmployeesView;
import com.capstone.soar.domain.projections.employee_admin.AdminEmployeeView;
import com.capstone.soar.repository.EmployeeRepository;
import com.capstone.soar.repository.EmployeeRoleRepository;

@ManagedBean
public class EmployeeService {
	
	@Autowired
	EmployeeRepository employeeRepo;
	
	@Autowired
	EmployeeRoleRepository employeeRoleRepo;

	@Autowired
	PasswordEncoder passwordEncoder;
	public List<AdminAllEmployeesView> getAllEmployeeDetails() {
		return employeeRepo.findAllProjectedBy();
	}
	
	public AdminAllEmployeesView getEmployeeDetails(Long id) {
		return employeeRepo.findProjectedById(id);
	}
	
	public void updateSelf(String username, SelfDetails self) {
		Employee emp = employeeRepo.getEmployeeByEmail(username);
		emp.setEmail(self.getEmail());
		emp.setName(self.getName());
		if(self.getPassword() != null)
			emp.setPassword(passwordEncoder.encode(self.getPassword()));
		employeeRepo.saveAndFlush(emp);
	}
	
	public void addEmployee(AdminEmployeeView employee) {
		Employee emp = new Employee();
		emp.setEmail(employee.getEmail());
		emp.setName(employee.getName());
		emp.setPassword(passwordEncoder.encode(employee.getPassword()));
		emp.setRole(employeeRoleRepo.findByRole(employee.getRole()));
		employeeRepo.save(emp);
	}
	
	public void updateEmployeeDetails(Long id, AdminEmployeeView employee) {
		if(employeeRepo.findById(id).isPresent()) {
			Employee emp = employeeRepo.getOne(id);
			emp.setEmail(employee.getEmail());
			emp.setName(employee.getName());
			if(employee.getPassword() != null)
				emp.setPassword(passwordEncoder.encode(employee.getPassword()));
			emp.setRole(employeeRoleRepo.findByRole(employee.getRole()));
			employeeRepo.save(emp);
		}
	}
	
	public void deleteEmployee(Long id) {
		employeeRepo.deleteById(id);
	}
	
	public SelfDetailsProjection getSelfDetails(String username) {
		return employeeRepo.findOneProjectedByEmail(username);
	}
	
	
}
