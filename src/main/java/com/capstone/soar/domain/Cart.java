package com.capstone.soar.domain;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

@Entity
public class Cart implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	private Long id;
	@OneToOne(fetch=FetchType.LAZY)
	private Employee employee;
	@ManyToMany(cascade = CascadeType.ALL)
	private Set<Inventory> inventories;
	private String remarks;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
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
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	@Override
	public String toString() {
		return "Cart [id=" + id + ", employee=" + employee + ", inventories=" + inventories + ", remarks=" + remarks
				+ "]";
	}
	

}
