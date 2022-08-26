package com.capg.onlineSweetMart.entity;

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
}
