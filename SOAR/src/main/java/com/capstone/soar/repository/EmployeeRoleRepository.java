package com.capstone.soar.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capstone.soar.domain.EmployeeRole;

public interface EmployeeRoleRepository extends JpaRepository<EmployeeRole, Long> {
	EmployeeRole findByRole(String role);
}
