package com.capstone.soar.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capstone.soar.domain.RequestStatus;

public interface RequestStatusRepository extends JpaRepository<RequestStatus, Long> {

	public RequestStatus findByStatus(String status);
}
