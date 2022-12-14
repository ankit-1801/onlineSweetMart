package com.capg.onlineSweetMart.entity;
import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name="Orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer orderId;

    private LocalDate orderDate;
    
    private LocalDate dispatchDate;

    private float totalCost;
    
    private int userId;
    
    private String status;
    
    @OneToMany(cascade=CascadeType.ALL,fetch=FetchType.LAZY)
    private List<OrderItem> sweetItemList;

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

	public List<OrderItem> getSweetItemList() {
		return sweetItemList;
	}

	public void setSweetItemList(List<OrderItem> sweetItemList) {
		this.sweetItemList = sweetItemList;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}