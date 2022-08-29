package com.capg.onlineSweetMart.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capg.onlineSweetMart.entity.SweetItem;
import com.capg.onlineSweetMart.service.SweetItemService;

@CrossOrigin("*")
@RestController
@RequestMapping("item")
public class SweetItemController {
	@Autowired
	private SweetItemService sweetItemService;
	
	
	//need updated 
	@PostMapping("/addSweetItem")
	public ResponseEntity<String> addSweetItem(@RequestBody SweetItem sweetItem){
		return new ResponseEntity<String>(sweetItemService.addSweetItem(sweetItem),HttpStatus.CREATED);
	}
	
    @GetMapping("/getAllSweetItem")
    public ResponseEntity<List<SweetItem>> getAllSweetItem(){
    return new ResponseEntity<>(sweetItemService.getAllSweetItem(),HttpStatus.FOUND);
    }
	
	@DeleteMapping("/deleteSweetItem/{id}")
	public ResponseEntity<String> deleteSweetItem(@PathVariable("id") int id){
        return new ResponseEntity<>(sweetItemService.deleteSweetItem(id),HttpStatus.OK);
	}
	
    @PatchMapping("/updateSweetItem/{id}")
    public ResponseEntity<String> updateSweetItem(@RequestBody SweetItem sweetItem, @PathVariable("id") int id){
    	return new ResponseEntity<>(sweetItemService.updateSweetItem(sweetItem,id),HttpStatus.ACCEPTED);
    }
    
    @GetMapping("/getSweetItemById/{id}")
    public ResponseEntity<SweetItem> getSweetItemById(@PathVariable("id") int id){
    	return new ResponseEntity<>(sweetItemService.getSweetItemById(id),HttpStatus.FOUND);
    }
    
    @GetMapping("/getQuantity/{id}")
    public ResponseEntity<Integer> getQuantity(@PathVariable("id") int id){
    	return new ResponseEntity<>(sweetItemService.getQuantity(id),HttpStatus.FOUND);
    }
    
}
