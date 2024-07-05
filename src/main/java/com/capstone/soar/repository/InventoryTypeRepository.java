package com.capstone.soar.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capstone.soar.domain.InventoryType;

public interface InventoryTypeRepository extends JpaRepository<InventoryType, Long> {

	InventoryType findOneByType(String type);
}
