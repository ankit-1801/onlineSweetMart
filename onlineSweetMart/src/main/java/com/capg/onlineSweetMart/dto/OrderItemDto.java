package com.capg.onlineSweetMart.dto;

public class OrderItemDto {
    private Integer id;
	private Integer SweetItemId;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getSweetItemId() {
		return SweetItemId;
	}
	public void setSweetItemId(Integer sweetItemId) {
		SweetItemId = sweetItemId;
	}
	@Override
	public String toString() {
		return "OrderItemDto [id=" + id + ", SweetItemId=" + SweetItemId + "]";
	}
    
}
