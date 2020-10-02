package com.capstone.soar.domain.projections.infra_admin;

import java.math.BigDecimal;

public class AdminInventoryView {
	private Long id;
	private String name;
	private String type;
	private int itemsInStock;
	private BigDecimal cost;
	private String image;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getItemsInStock() {
		return itemsInStock;
	}
	public void setItemsInStock(int itemsInStock) {
		this.itemsInStock = itemsInStock;
	}
	public BigDecimal getCost() {
		return cost;
	}
	public void setCost(BigDecimal cost) {
		this.cost = cost;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	
	
}
