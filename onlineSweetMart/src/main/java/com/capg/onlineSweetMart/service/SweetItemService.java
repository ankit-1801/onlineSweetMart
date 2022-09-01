package com.capg.onlineSweetMart.service;

import java.util.List;
import com.capg.onlineSweetMart.dto.SweetItemsDto;


public interface SweetItemService {
    public String addSweetItem(SweetItemsDto sweetItemsDto);
    public List<SweetItemsDto> getAllSweetItem();
    public String deleteSweetItem(int id);
    public String updateSweetItem(SweetItemsDto sweetItemsDto, int id);
    public SweetItemsDto getSweetItemById(int id);
	public Integer getQuantity(int id);
}
