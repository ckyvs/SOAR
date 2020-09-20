package com.capstone.soar.domain.projections.infra_admin;

import java.math.BigDecimal;

import org.springframework.web.multipart.MultipartFile;

public class AdminInventoryView {
	private Long id;
	private String name;
	private String type;
	private int itemsInStock;
	private BigDecimal cost;
	private byte[] image;
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
	public byte[] getImage() {
		return image;
	}
	public void setImage(byte[] image) {
		this.image = image;
	}
	
	
}
