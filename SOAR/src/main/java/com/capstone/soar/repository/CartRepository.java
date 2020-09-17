package com.capstone.soar.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capstone.soar.domain.Cart;
import com.capstone.soar.domain.Employee;

@Repository
@Transactional
public interface CartRepository extends JpaRepository<Cart, Long> {
	
	public Cart findByEmployee(Employee employee);

}
