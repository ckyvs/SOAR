package com.capstone.soar.service;

import java.util.List;

import javax.annotation.ManagedBean;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.capstone.soar.domain.Employee;
import com.capstone.soar.domain.projections.SelfDetails;
import com.capstone.soar.domain.projections.SelfDetailsProjection;
import com.capstone.soar.domain.projections.employee_admin.AdminAllEmployeesView;
import com.capstone.soar.domain.projections.employee_admin.AdminEmployeeView;
import com.capstone.soar.exception.UserExistsException;
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
	
	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	String empExists = "Employee with this email exists";
	
	public List<AdminAllEmployeesView> getAllEmployeeDetails() {
		return employeeRepo.findAllProjectedBy();
	}
	
	public AdminAllEmployeesView getEmployeeDetails(Long id) {
		return employeeRepo.findProjectedById(id);
	}
	
	public void updateSelf(String username, SelfDetails self) {
		Employee emp = employeeRepo.getEmployeeByEmail(username);
		if(!emp.getEmail().equals(self.getEmail())) {
			if(employeeRepo.getEmployeeByEmail(self.getEmail()) != null) {
				logger.warn(empExists);
				throw new UserExistsException();
			}
			emp.setEmail(self.getEmail());
		}
		emp.setName(self.getName());
		if(self.getPassword() != null)
			emp.setPassword(passwordEncoder.encode(self.getPassword()));
		employeeRepo.saveAndFlush(emp);
	}
	
	public void addEmployee(AdminEmployeeView employee){
		if(employeeRepo.getEmployeeByEmail(employee.getEmail()) != null) {
			logger.warn(empExists);
			throw new UserExistsException();
		}
		Employee emp = new Employee();
		emp.setId(null);
		emp.setEmail(employee.getEmail());
		emp.setName(employee.getName());
		emp.setPassword(passwordEncoder.encode(employee.getPassword()));
		emp.setRole(employeeRoleRepo.findByRole(employee.getRole()));
		logger.info("Employee :{} Registered", employee);
		employeeRepo.saveAndFlush(emp);
	}
	
	public void updateEmployeeDetails(Long id, AdminEmployeeView employee) {
		if(employeeRepo.findById(id).isPresent()) {
			Employee emp = employeeRepo.getOne(id);
			if(!emp.getEmail().equals(employee.getEmail())) {
				if(employeeRepo.getEmployeeByEmail(employee.getEmail()) != null) {
					logger.warn(empExists);
					throw new UserExistsException();
				}
				emp.setEmail(employee.getEmail());
			}
			emp.setName(employee.getName());
			if(employee.getPassword() != null)
				emp.setPassword(passwordEncoder.encode(employee.getPassword()));
			emp.setRole(employeeRoleRepo.findByRole(employee.getRole()));
			employeeRepo.saveAndFlush(emp);
		}
	}
	
	public void deleteEmployee(Long id) {
		employeeRepo.deleteById(id);
	}
	
	public SelfDetailsProjection getSelfDetails(String username) {
		return employeeRepo.findOneProjectedByEmail(username);
	}
	
	
}
