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
	private Integer SweetItemId;
	public OrderItem(Integer id, Integer sweetItemId) {
		super();
		this.id = id;
		SweetItemId = sweetItemId;
	}
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
	public int hashCode() {
		return Objects.hash(SweetItemId, id);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OrderItem other = (OrderItem) obj;
		return Objects.equals(SweetItemId, other.SweetItemId) && Objects.equals(id, other.id);
	}
	
}