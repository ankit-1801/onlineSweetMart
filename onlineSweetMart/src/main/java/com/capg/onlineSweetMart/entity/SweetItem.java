package com.capg.onlineSweetMart.entity;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "sweet_item")
public class SweetItem {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    private Integer sweetItemId;
	
    private double price;

    private int quantity;

    private String description;

    private String image;

	public Integer getSweetItemId() {
		return sweetItemId;
	}

	public void setSweetItemId(Integer sweetItemId) {
		this.sweetItemId = sweetItemId;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	@Override
	public int hashCode() {
		return Objects.hash(description, image, price, quantity, sweetItemId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SweetItem other = (SweetItem) obj;
		return Objects.equals(description, other.description) && Objects.equals(image, other.image)
				&& Double.doubleToLongBits(price) == Double.doubleToLongBits(other.price) && quantity == other.quantity
				&& Objects.equals(sweetItemId, other.sweetItemId);
	}
	
    
    
}
