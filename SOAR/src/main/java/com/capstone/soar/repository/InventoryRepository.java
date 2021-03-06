package com.capstone.soar.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capstone.soar.domain.Inventory;
import com.capstone.soar.domain.projections.dev.DevInventoryView;
import com.capstone.soar.domain.projections.infra_admin.AdminInventoryReadOnlyView;

@Repository
public interface InventoryRepository extends JpaRepository<Inventory, Long> {
	
	public List<DevInventoryView> findAllProjectedBy();
	
	public Inventory findByName(String name);
	
	public List<AdminInventoryReadOnlyView> findEachProjectedBy();
	
	public AdminInventoryReadOnlyView findOneProjectedById(Long id);

}
