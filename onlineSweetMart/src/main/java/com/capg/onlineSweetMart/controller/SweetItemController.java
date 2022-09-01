package com.capg.onlineSweetMart.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.engine.jdbc.StreamUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import com.capg.onlineSweetMart.dto.SweetItemsDto;
import com.capg.onlineSweetMart.helper.ImageUploadHelper;
import com.capg.onlineSweetMart.service.SweetItemService;
import com.fasterxml.jackson.databind.ObjectMapper;

@CrossOrigin("*")
@RestController
@RequestMapping
public class SweetItemController {
	@Autowired
	private SweetItemService sweetItemService;
	
    @Autowired
    public ImageUploadHelper imageUploadHelper;
    
    @Value("${project.image}")
    private String path;
//	//need updated 
//	@PostMapping("/addSweetItem")
//	public ResponseEntity<String> addSweetItem(@RequestBody SweetItem sweetItem){
//		return new ResponseEntity<String>(sweetItemService.addSweetItem(sweetItem),HttpStatus.CREATED);
//	}
	
	
	@PostMapping("item/addSweetItem")
	public ResponseEntity<String> addSweetItem(@RequestParam("sweetItems") String jsonStringFoodDto , @RequestParam("file") MultipartFile  file)throws IOException {

		try {
    		if(file.isEmpty()) {
    			return new ResponseEntity<String>("File is empty!!!",HttpStatus.INTERNAL_SERVER_ERROR);
    		}
    		String filename = imageUploadHelper.uploadFile(file);
    		if(filename != null) {
    			
    			SweetItemsDto sweetItemsDto = new ObjectMapper().readValue(jsonStringFoodDto, SweetItemsDto.class);
    			sweetItemsDto.setImage(filename);
    			sweetItemService.addSweetItem(sweetItemsDto);
    		    return  new  ResponseEntity<>("Item added!!",HttpStatus.OK );
    		}
    	}catch (Exception e) {
    		e.printStackTrace();
		}
    	return new ResponseEntity<>("Something went wrong!!",HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@GetMapping("item/images/{image}")
    public void showImage(@PathVariable("image") String image,HttpServletResponse response) throws ServletException, IOException {
		String fullPath = path+File.separator+image;
		InputStream resource = new FileInputStream(fullPath);
		
		response.setContentType(MediaType.IMAGE_JPEG_VALUE);
		StreamUtils.copy(resource, response.getOutputStream());
    }
	
    @GetMapping("item/getAllSweetItem")
    public ResponseEntity<List<SweetItemsDto>> getAllSweetItem(){
    return new ResponseEntity<>(sweetItemService.getAllSweetItem(),HttpStatus.OK);
    }
	
	@DeleteMapping("item/deleteSweetItem/{id}")
	public ResponseEntity<String> deleteSweetItem(@PathVariable("id") int id){
        return new ResponseEntity<>(sweetItemService.deleteSweetItem(id),HttpStatus.OK);
	}
	
    @PatchMapping("item/updateSweetItem/{id}")
    public ResponseEntity<String> updateSweetItem(@RequestBody SweetItemsDto sweetItemsDto, @PathVariable("id") int id){
    	return new ResponseEntity<>(sweetItemService.updateSweetItem(sweetItemsDto,id),HttpStatus.ACCEPTED);
    }
    
    @GetMapping("item/getSweetItemById/{id}")
    public ResponseEntity<SweetItemsDto> getSweetItemById(@PathVariable("id") int id){
    	return new ResponseEntity<>(sweetItemService.getSweetItemById(id),HttpStatus.OK);
    }
    
    @GetMapping("item/getQuantity/{id}")
    public ResponseEntity<Integer> getQuantity(@PathVariable("id") int id){
    	return new ResponseEntity<>(sweetItemService.getQuantity(id),HttpStatus.OK);
    }
    
}
