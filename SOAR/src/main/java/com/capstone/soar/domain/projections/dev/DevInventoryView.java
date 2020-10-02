package com.capstone.soar.domain.projections.dev;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;


import com.capstone.soar.domain.InventoryType;

public class DevInventoryView {
	private String name;
	private int itemsInStock;
	private String type;
	private byte[] image;	
	
	public DevInventoryView(String name, int itemsInStock, InventoryType type, String image) throws IOException {
		super();
		this.name = name;
		this.itemsInStock = itemsInStock;
		this.type = type.getType();
		//System.out.println(image);
		this.image = Files.readAllBytes(Paths.get(image));
	}
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getItemsInStock() {
		return itemsInStock;
	}
	public void setItemsInStock(int itemsInStock) {
		this.itemsInStock = itemsInStock;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public byte[] getImage() {
		return image;
	}
	public void setImage(String image) throws IOException {
		//this.image = Files.readAllBytes(Paths.get(image));
	}
	
	
}

//public interface DevInventoryView {
//	String getName();
//	int getItemsInStock();
//	@Value("#{target.type.type}")
//	String getType();
//	byte[] getImage();
//}