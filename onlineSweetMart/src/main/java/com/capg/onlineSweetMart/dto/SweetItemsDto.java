package com.capg.onlineSweetMart.dto;

public class SweetItemsDto {
    private Integer sweetItemId;
	private String name;
	
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
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
