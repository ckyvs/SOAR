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
import com.capstone.soar.domain.projections.manager.ManagerResponse;
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
	RequestStatusRepository statusRepo;
	
	@Autowired
	CartRepository cartRepo;
	
	@Autowired
	RequestStatusRepository requestStatusRepo;
	
	public List<PastRequestsView> getPastRequestsDev() {
		return requestRepo.findAllProjectedBy();
	}
	
	public PastRequestsView getPastRequestByIdDev(Long id) {
		return requestRepo.findProjectedById(id);
	}
	
	public RespondedRequestsView getRespondedRequestById(Long id) {
		return requestRepo.findManProjectedById(id);
	}
	
	public void addRequest(String remarks, String username) {
		Request request = new Request();
		Employee employee = employeeRepo.getEmployeeByEmail(username);
		Cart cart = cartRepo.findByEmployee(employee);
		RequestStatus status = statusRepo.findByStatus("PENDING");
		BigDecimal totalCost = BigDecimal.ZERO;
		int totalItems;
		Set<Inventory> inventories = new HashSet<>(cart.getInventories());
		totalItems = inventories.size();
		for(Inventory i:inventories) {
			totalCost = totalCost.add(i.getCost());
		}
		request.setInventories(inventories);
		request.setCreatedDate(new Date());
		request.setDevRemarks(remarks);
		request.setEmployee(employee);
		request.setStatus(status);
		request.setTotalItems(totalItems);
		request.setTotalCost(totalCost);
		requestRepo.saveAndFlush(request);
	}
	
	public List<PendingRequestsView> getPendingRequests(String statusText) {
		RequestStatus status = requestStatusRepo.findByStatus(statusText);
		return requestRepo.findAllProjectedByStatus(status);
	}
	
	public List<RespondedRequestsView> getRespondedRequests(String statusText) {
		RequestStatus status = requestStatusRepo.findByStatus(statusText);
		return requestRepo.findAllProjectedByStatusNot(status);
	}
	
	public void respondToRequest(Long id, ManagerResponse response) {
		Request request = requestRepo.getOne(id);
		request.setManagerRemarks(response.getRemarks());
		request.setResponseDate(new Date());
		RequestStatus statusObj = requestStatusRepo.findByStatus(response.getStatus());
		request.setStatus(statusObj);
		requestRepo.saveAndFlush(request);
	}
	
	public PendingRequestsView getPendingRequestById(Long id) {
		return requestRepo.findOneProjectedById(id);
	}
}
