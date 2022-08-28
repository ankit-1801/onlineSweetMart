package com.capg.onlineSweetMart.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capg.onlineSweetMart.entity.SweetItem;
import com.capg.onlineSweetMart.exception.SweetItemNotFoundException;
import com.capg.onlineSweetMart.repository.SweetItemRepository;
import com.capg.onlineSweetMart.service.SweetItemService;

@Service
public class SweetItemServiceImpl implements SweetItemService {
	
	@Autowired
	private SweetItemRepository sweetItemRepository;
	

	@Override
	public String addSweetItem(SweetItem sweetItem) {
		sweetItemRepository.save(sweetItem);
		return "Order Created";
		
	}

	@Override
	public List<SweetItem> getAllSweetItem() {
		List<SweetItem> li  = sweetItemRepository.findAll();
		return li;
	}

	@Override
	public String deleteSweetItem(int id) {
		SweetItem sweetItem = sweetItemRepository.findById(id).orElseThrow(()->new SweetItemNotFoundException("Sweet Item with id "+id+" is not found"));
	    sweetItemRepository.deleteById(id);
		return "Item Deleted!";
	}

	@Override
	public String updateSweetItem(SweetItem sweetItem, int id) {
		SweetItem sweetItem1 = sweetItemRepository.findById(id).orElseThrow(()->new SweetItemNotFoundException("Sweet Item with id "+id+" is not found"));
		if(sweetItem.getQuantity()!=0) {
			sweetItem1.setQuantity(sweetItem.getQuantity());
		}
		if(sweetItem.getImage()!=null) {
			sweetItem1.setImage(sweetItem.getImage());
		}
		if(sweetItem.getDescription()!=null) {
			sweetItem1.setDescription(sweetItem.getDescription());
		}
		if(sweetItem.getPrice()> 0) {
			sweetItem1.setPrice(sweetItem.getPrice());
		}
		sweetItemRepository.save(sweetItem1);
		return "Item Updated";
	}

	@Override
	public SweetItem getSweetItemById(int id) {
		SweetItem sweetItem = sweetItemRepository.findById(id).orElseThrow(()->new SweetItemNotFoundException("Sweet Item with id "+id+" is not found"));
		return sweetItem;
	}

	@Override
	public Integer getQuantity(int id) {
		SweetItem sweetItem = sweetItemRepository.findById(id).orElseThrow(()->new SweetItemNotFoundException("Sweet Item with id "+id+" is not found"));
		return sweetItem.getQuantity();
	}

}
