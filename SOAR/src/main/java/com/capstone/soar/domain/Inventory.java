package com.capstone.soar.domain;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;


@Entity
public class Inventory implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	private Long id;
	private String name;
	@ManyToOne
	private InventoryType type;
	private BigDecimal cost;
	private int itemsInStock;
	private String image;
	
	public String getImage(){
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public BigDecimal getCost() {
		return cost;
	}
	public void setCost(BigDecimal cost) {
		this.cost = cost;
	}
	public int getItemsInStock() {
		return itemsInStock;
	}
	public void setItemsInStock(int itemsInStock) {
		this.itemsInStock = itemsInStock;
	}
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
	public InventoryType getType() {
		return type;
	}
	public void setType(InventoryType type) {
		this.type = type;
	}
	@Override
	public String toString() {
		return "Inventory [id=" + id + ", name=" + name + ", type=" + type + ", price=" + cost + ", itemsInStock="
				+ itemsInStock + ", image=" + image + "]";
	}
	
}
