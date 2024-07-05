package com.capstone.soar.domain;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Request {
	@Id
	@GeneratedValue
	private Long id;
	@ManyToMany(cascade = CascadeType.ALL)
	private Set<Inventory> inventories;
	private Date createdDate;
	private Date responseDate;
	@ManyToOne
	private Employee employee;
	private String devRemarks;
	private String managerRemarks;
	@ManyToOne(cascade = CascadeType.ALL)
	private RequestStatus status;
	private int totalItems;
	private BigDecimal totalCost;
	
	public String getDevRemarks() {
		return devRemarks;
	}
	public void setDevRemarks(String devRemarks) {
		this.devRemarks = devRemarks;
	}
	public String getManagerRemarks() {
		return managerRemarks;
	}
	public void setManagerRemarks(String managerRemarks) {
		this.managerRemarks = managerRemarks;
	}
	public RequestStatus getStatus() {
		return status;
	}
	public void setStatus(RequestStatus status) {
		this.status = status;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public void addInventory(Inventory inventory) {
		this.inventories.add(inventory);
	}
	public void removeInventory(Inventory inventory) {
		this.inventories.remove(inventory);
	}
	public Employee getEmployee() {
		return employee;
	}
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	public Set<Inventory> getInventories() {
		return inventories;
	}
	public void setInventories(Set<Inventory> inventories) {
		this.inventories = inventories;
	}
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	public Date getResponseDate() {
		return responseDate;
	}
	public void setResponseDate(Date responseDate) {
		this.responseDate = responseDate;
	}
	public int getTotalItems() {
		return totalItems;
	}
	public void setTotalItems(int totalItems) {
		this.totalItems = totalItems;
	}
	public BigDecimal getTotalCost() {
		return totalCost;
	}
	public void setTotalCost(BigDecimal totalCost) {
		this.totalCost = totalCost;
	}

}
