package com.capg.onlineSweetMart.helper;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.UUID;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class ImageUploadHelper {
	public ImageUploadHelper() throws IOException {
		
	}
	    public String getUPLOAD_DIR() {
		return UPLOAD_DIR;
     	}
	    
		public final String UPLOAD_DIR ="C:\\Users\\negia\\git\\onlineSweetMart\\onlineSweetMart\\src\\main\\resources\\static\\images";
	
	//making it dyamic 
//	 public final String UPLOAD_DIR = new ClassPathResource("src/main/resources/static/images/").getFile().getAbsolutePath();
    public String uploadFile(MultipartFile multipartFile) {
    	try {
    		
    	 String name = multipartFile.getOriginalFilename();
    	 String randomId = UUID.randomUUID().toString();
         String filename = randomId.concat(name.substring(name.lastIndexOf('.')));
         Files.copy(multipartFile.getInputStream(),Paths.get( UPLOAD_DIR+File.separator + filename ), StandardCopyOption.REPLACE_EXISTING);
    	 return filename;
    	}catch(Exception e) {
    		e.printStackTrace();
    	} 
		return null;  	
    }
}
