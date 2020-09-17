package com.capstone.soar.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capstone.soar.domain.Employee;
import com.capstone.soar.domain.projections.employee_admin.AdminAllEmployeesView;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
	
	Employee getEmployeeByEmail(String email);
	
	List<AdminAllEmployeesView> findAllProjectedBy();
}
