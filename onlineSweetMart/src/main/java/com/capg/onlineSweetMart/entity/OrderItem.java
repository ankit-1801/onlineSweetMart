package com.capg.onlineSweetMart.entity;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "order_item")
 public class OrderItem {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
	private Integer sweetItemId;
	private String sweetItemName;
	private Integer purchaseQuantity;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getSweetItemId() {
		return sweetItemId;
	}
	public void setSweetItemId(Integer sweetItemId) {
		this.sweetItemId = sweetItemId;
	}
	public Integer getPurchaseQuantity() {
		return purchaseQuantity;
	}
	public void setPurchaseQuantity(Integer purchaseQuantity) {
		this.purchaseQuantity = purchaseQuantity;
	}
	public String getSweetItemName() {
		return sweetItemName;
	}
	public void setSweetItemName(String sweetItemName) {
		this.sweetItemName = sweetItemName;
	}
	
	
}