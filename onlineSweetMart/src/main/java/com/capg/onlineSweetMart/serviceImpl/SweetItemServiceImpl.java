package com.capg.onlineSweetMart.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capg.onlineSweetMart.dto.SweetItemsDto;
import com.capg.onlineSweetMart.entity.SweetItems;
import com.capg.onlineSweetMart.exception.SweetItemNotFoundException;
import com.capg.onlineSweetMart.helper.Converter;
import com.capg.onlineSweetMart.repository.SweetItemRepository;
import com.capg.onlineSweetMart.service.SweetItemService;

@Service
public class SweetItemServiceImpl implements SweetItemService {
	
	@Autowired
	private SweetItemRepository sweetItemRepository;
	
	
	@Autowired
	public Converter converter;

	@Override
	public String addSweetItem(SweetItemsDto sweetItemsDto) {
		SweetItems sweetItems = converter.convertSweetItemsDtoToSweetItems(sweetItemsDto); 
		sweetItemRepository.save(sweetItems);
		return "Sweet Item added!";
		
	}

	@Override
	public List<SweetItemsDto> getAllSweetItem() {
		List<SweetItems> li  = sweetItemRepository.findAll();
		List<SweetItemsDto> list = new ArrayList<SweetItemsDto>();
		for(SweetItems sweetItems:li) {
			list.add(converter.convertSweetItemsToSweetItemsDto(sweetItems));
		}
		return list;
	}

	@Override
	public String deleteSweetItem(int id) {
		sweetItemRepository.findById(id).orElseThrow(()->new SweetItemNotFoundException("Sweet Item with id "+id+" is not found"));
	    sweetItemRepository.deleteById(id);
		return "Item Deleted!";
	}

	@Override
	public String updateSweetItem(SweetItemsDto sweetItemsDto, int id) {
		SweetItems sweetItem1 = sweetItemRepository.findById(id).orElseThrow(()->new SweetItemNotFoundException("Sweet Item with id "+id+" is not found"));
		SweetItems sweetItems = converter.convertSweetItemsDtoToSweetItems(sweetItemsDto);
		if(sweetItems.getQuantity()!=0) {
			sweetItem1.setQuantity(sweetItems.getQuantity());
		}
		if(sweetItems.getImage()!=null) {
			sweetItem1.setImage(sweetItems.getImage());
		}
		if(sweetItems.getDescription()!=null) {
			sweetItem1.setDescription(sweetItems.getDescription());
		}
		if(sweetItems.getName()!=null) {
			sweetItem1.setName(sweetItems.getName());
		}
		if(sweetItems.getPrice()> 0) {
			sweetItem1.setPrice(sweetItems.getPrice());
		}
		sweetItemRepository.save(sweetItem1);
		return "Item Updated";
	}

	@Override
	public SweetItemsDto getSweetItemById(int id) {
		SweetItems sweetItems = sweetItemRepository.findById(id).orElseThrow(()->new SweetItemNotFoundException("Sweet Item with id "+id+" is not found"));	
		return converter.convertSweetItemsToSweetItemsDto(sweetItems);
	}

	@Override
	public Integer getQuantity(int id) {
		SweetItems sweetItems = sweetItemRepository.findById(id).orElseThrow(()->new SweetItemNotFoundException("Sweet Item with id "+id+" is not found"));
		return sweetItems.getQuantity();
	}

}
