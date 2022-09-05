package com.capg.onlineSweetMart.dto;

import java.time.LocalDate;
import java.util.List;

import javax.validation.constraints.NotNull;

public class OrderDto {
    private Integer orderId;

    private LocalDate orderDate;
    
    private LocalDate dispatchDate;

    private float totalCost;
    private int userId;
    
    private String status;
    
    
    private List<OrderItemDto> sweetItemList;

	public Integer getOrderId() {
		return orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	public LocalDate getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(LocalDate orderDate) {
		this.orderDate = orderDate;
	}

	public LocalDate getDispatchDate() {
		return dispatchDate;
	}

	public void setDispatchDate(LocalDate dispatchDate) {
		this.dispatchDate = dispatchDate;
	}

	public float getTotalCost() {
		return totalCost;
	}

	public void setTotalCost(float totalCost) {
		this.totalCost = totalCost;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public List<OrderItemDto> getSweetItemList() {
		return sweetItemList;
	}

	public void setSweetItemList(List<OrderItemDto> sweetItemList) {
		this.sweetItemList = sweetItemList;
	}

	@Override
	public String toString() {
		return "OrderDto [orderId=" + orderId + ", orderDate=" + orderDate + ", dispatchDate=" + dispatchDate
				+ ", totalCost=" + totalCost + ", userId=" + userId + ", status=" + status + ", sweetItemList="
				+ sweetItemList + "]";
	}
	
	

}
