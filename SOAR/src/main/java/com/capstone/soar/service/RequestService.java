package com.capstone.soar.service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.ManagedBean;

import org.springframework.beans.factory.annotation.Autowired;

import com.capstone.soar.domain.Cart;
import com.capstone.soar.domain.Employee;
import com.capstone.soar.domain.Inventory;
import com.capstone.soar.domain.Request;
import com.capstone.soar.domain.RequestStatus;
import com.capstone.soar.domain.projections.dev.PastRequestsView;
import com.capstone.soar.domain.projections.manager.PendingRequestsView;
import com.capstone.soar.domain.projections.manager.RespondedRequestsView;
import com.capstone.soar.repository.CartRepository;
import com.capstone.soar.repository.EmployeeRepository;
import com.capstone.soar.repository.RequestRepository;
import com.capstone.soar.repository.RequestStatusRepository;

@ManagedBean
public class RequestService {
	@Autowired
	RequestRepository requestRepo;
	
	@Autowired
	EmployeeRepository employeeRepo;
	
	@Autowired
	CartRepository cartRepo;
	
	@Autowired
	RequestStatusRepository requestStatusRepo;
	public List<PastRequestsView> getPastRequestsDev() {
		return requestRepo.findAllProjectedBy();
	}
	
	public void addRequest(String username) {
		Request request = new Request();
		Employee employee = employeeRepo.getEmployeeByEmail(username);
		Cart cart = cartRepo.findByEmployee(employee);
		RequestStatus status = new RequestStatus();
		BigDecimal totalCost = BigDecimal.ZERO;
		int totalItems;
		status.setId(1L);
		status.setStatus("PENDING");
		Set<Inventory> inventories = new HashSet<>(cart.getInventories());
		totalItems = inventories.size();
		for(Inventory i:inventories) {
			totalCost = totalCost.add(i.getCost());
		}
		request.setInventories(inventories);
		request.setCreatedDate(new Date());
		request.setDevRemarks(cart.getRemarks());
		request.setEmployee(employee);
		request.setStatus(status);
		request.setTotalItems(totalItems);
		request.setTotalCost(totalCost);
		requestRepo.saveAndFlush(request);
	}
	
	public List<PendingRequestsView> getPendingRequestsManager(String statusText) {
		RequestStatus status = requestStatusRepo.findByStatus(statusText);
		return requestRepo.findAllProjectedByStatus(status);
	}
	
	public List<RespondedRequestsView> getRespondedRequestsManager(String statusText) {
		RequestStatus status = requestStatusRepo.findByStatus(statusText);
		return requestRepo.findAllProjectedByStatusNot(status);
	}
	
	public void respondToRequest(Long id, String status) {
		Request request = requestRepo.getOne(id);
		RequestStatus statusObj = requestStatusRepo.findByStatus(status);
		request.setStatus(statusObj);
		requestRepo.saveAndFlush(request);
	}
}
