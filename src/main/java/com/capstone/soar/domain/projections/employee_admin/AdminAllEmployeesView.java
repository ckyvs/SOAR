package com.capstone.soar.domain.projections.employee_admin;

import org.springframework.beans.factory.annotation.Value;

public interface AdminAllEmployeesView {
	Long getId();
	String getName();
	String getEmail();
	@Value("#{target.role.role}")
	String getRole();
}
