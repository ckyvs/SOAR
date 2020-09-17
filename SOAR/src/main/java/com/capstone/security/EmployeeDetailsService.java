package com.capstone.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.capstone.soar.domain.Employee;
import com.capstone.soar.repository.EmployeeRepository;

@Service
public class EmployeeDetailsService implements UserDetailsService{

	@Autowired
	EmployeeRepository employeeRepo;
	@Override
	public UserDetails loadUserByUsername(String username){
		Employee employee = employeeRepo.getEmployeeByEmail(username);
		if(employee == null)
			throw new UsernameNotFoundException("User not found");
		return new EmployeeDetails(employee);
	}

}
