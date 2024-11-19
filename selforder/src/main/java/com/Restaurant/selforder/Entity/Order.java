package com.Restaurant.selforder.Entity;

import jakarta.annotation.Generated;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity(name = "orders")
public class Order {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO) 
	long itemId;
	String itemName, itemStatus, itemCode;
	int itemPrice, tableNo, itemQuantity;
	
	 public Order() {}
	
	public Order(long itemId, String itemName, String itemStatus, String itemCode, int itemPrice, int tableNo,
			int itemQuantity) {
		super();
		this.itemId = itemId;
		this.itemName = itemName;
		this.itemStatus = itemStatus;
		this.itemCode = itemCode;
		this.itemPrice = itemPrice;
		this.tableNo = tableNo;
		this.itemQuantity = itemQuantity;
	}
	public long getItemId() {
		return itemId;
	}
	public void setItemId(long itemId) {
		this.itemId = itemId;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public String getItemStatus() {
		return itemStatus;
	}
	public void setItemStatus(String itemStatus) {
		this.itemStatus = itemStatus;
	}
	public String getItemCode() {
		return itemCode;
	}
	public void setItemCode(String itemCode) {
		this.itemCode = itemCode;
	}
	public int getItemPrice() {
		return itemPrice;
	}
	public void setItemPrice(int itemPrice) {
		this.itemPrice = itemPrice;
	}
	public int getTableNo() {
		return tableNo;
	}
	public void setTableNo(int tableNo) {
		this.tableNo = tableNo;
	}
	public int getItemQuantity() {
		return itemQuantity;
	}
	public void setItemQuantity(int itemQuantity) {
		this.itemQuantity = itemQuantity;
	}
	
	
	
	
	
	
	
}
