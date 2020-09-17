package com.capstone.security;

import java.util.Arrays;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.capstone.soar.domain.Employee;
import com.capstone.soar.domain.EmployeeRole;

public class EmployeeDetails implements UserDetails{
	private static final long serialVersionUID = 1L;
	private Employee employee;
	
	public EmployeeDetails(Employee employee) {
		this.employee = employee;
	}
	
	public EmployeeDetails() {
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		EmployeeRole role=employee.getRole();
		return Arrays.asList(new SimpleGrantedAuthority(role.getRole()));
	}

	@Override
	public String getPassword() {
		return employee.getPassword();
	}

	@Override
	public String getUsername() {
		return employee.getEmail();
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

}
