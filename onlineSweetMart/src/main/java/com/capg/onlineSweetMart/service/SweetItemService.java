package com.capg.onlineSweetMart.service;

import java.util.List;
import com.capg.onlineSweetMart.entity.SweetItem;


public interface SweetItemService {
    public String addSweetItem(SweetItem sweetItem);
    public List<SweetItem> getAllSweetItem();
    public String deleteSweetItem(int id);
    public String updateSweetItem(SweetItem sweetItem, int id);
    public SweetItem getSweetItemById(int id);
	public Integer getQuantity(int id);
}
