package com.capg.onlineSweetMart.dto;

import java.util.Objects;

import com.capg.onlineSweetMart.entity.OrderItem;

public class OrderItemDto {
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
	@Override
	public String toString() {
		return "OrderItemDto [id=" + id + ", SweetItemId=" + sweetItemId + "]";
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
