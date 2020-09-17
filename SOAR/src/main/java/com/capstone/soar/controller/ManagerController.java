package com.capstone.soar.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.capstone.soar.domain.projections.manager.PendingRequestsView;
import com.capstone.soar.domain.projections.manager.RespondedRequestsView;
import com.capstone.soar.service.RequestService;

@RestController
public class ManagerController {
	
	@Autowired
	RequestService requestService;
	
	@GetMapping("/pending-requests")
	@PreAuthorize("hasRole('MANAGER')")
	public List<PendingRequestsView> getAllPendingRequests() {
		return requestService.getPendingRequestsManager("PENDING");
	}
	
	@PostMapping("/respond/{id}")
	@PreAuthorize("hasRole('MANAGER')")
	public void respondToRequest(@PathVariable Long id,@RequestBody String status) {
		requestService.respondToRequest(id, status);
	}
	
	@GetMapping("/responded-requests")
	@PreAuthorize("hasRole('MANAGER')")
	public List<RespondedRequestsView> getAllPastRequests() {
		return requestService.getRespondedRequestsManager("PENDING");
	}
}
