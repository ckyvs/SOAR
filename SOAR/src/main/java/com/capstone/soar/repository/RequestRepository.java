package com.capstone.soar.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capstone.soar.domain.Request;
import com.capstone.soar.domain.RequestStatus;
import com.capstone.soar.domain.projections.dev.PastRequestsView;
import com.capstone.soar.domain.projections.manager.PendingRequestsView;
import com.capstone.soar.domain.projections.manager.RespondedRequestsView;

@Repository
public interface RequestRepository extends JpaRepository<Request, Long> {

	public List<PastRequestsView> findAllProjectedBy();
	
	public List<PendingRequestsView> findAllProjectedByStatus(RequestStatus status);
	
	public List<RespondedRequestsView> findAllProjectedByStatusNot(RequestStatus status);
	
}
