package com.capstone.soar.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.capstone.soar.domain.projections.dev.PastRequestsView;
import com.capstone.soar.domain.projections.manager.ManagerResponse;
import com.capstone.soar.domain.projections.manager.PendingRequestsView;
import com.capstone.soar.domain.projections.manager.RespondedRequestsView;
import com.capstone.soar.service.RequestService;

@RestController
@CrossOrigin(origins="http://localhost:4200")
public class ManagerController {
	
	@Autowired
	RequestService requestService;
	
	@GetMapping("/pending-requests")
	@PreAuthorize("hasAuthority('MANAGER')")
	public List<PendingRequestsView> getAllPendingRequests() {
		return requestService.getPendingRequests("PENDING");
	}
	
	@PostMapping("/respond/{id}")
	@PreAuthorize("hasAuthority('MANAGER')")
	public void respondToRequest(@PathVariable Long id,@RequestBody ManagerResponse response) {
		requestService.respondToRequest(id, response);
	}
	
	@GetMapping("/responded-requests")
	@PreAuthorize("hasAuthority('MANAGER')")
	public List<RespondedRequestsView> getAllPastRequests() {
		return requestService.getRespondedRequests("PENDING");
	}
	
	@GetMapping("/responded-requests/{id}")
	@PreAuthorize("hasAuthority('MANAGER')")
	public RespondedRequestsView getPastRequestsBy(@PathVariable Long id) {
		return requestService.getRespondedRequestById(id);
	}
	
	@GetMapping("/pending-requests/{id}")
	@PreAuthorize("hasAuthority('MANAGER')")
	public PendingRequestsView getPendingRequestById(@PathVariable Long id) {
		return requestService.getPendingRequestById(id);
	}
}
