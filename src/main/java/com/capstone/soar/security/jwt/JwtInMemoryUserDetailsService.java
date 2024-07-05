package com.capstone.soar.security.jwt;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.capstone.soar.domain.Employee;
import com.capstone.soar.repository.EmployeeRepository;

@Service
public class JwtInMemoryUserDetailsService implements UserDetailsService {
	
	@Autowired
	EmployeeRepository employeeRepo;

  static List<JwtUserDetails> inMemoryUserList = new ArrayList<>();

  static {
    inMemoryUserList.add(new JwtUserDetails(1L, "in28minutes",
        "$2a$10$3zHzb.Npv1hfZbLEU5qsdOju/tk2je6W6PnNnY.c1ujWPcZh4PL6e", "ROLE_USER_2"));
  }

  @Override
  public UserDetails loadUserByUsername(String username) {
    Employee employee = employeeRepo.getEmployeeByEmail(username);
    if (employee == null) {
      throw new UsernameNotFoundException(String.format("USER_NOT_FOUND '%s'.", username));
    }

    return new JwtUserDetails(employee.getId(), employee.getEmail(), employee.getPassword(), employee.getRole().getRole());
  }

}


