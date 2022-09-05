package com.capg.onlineSweetMart.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.capg.onlineSweetMart.dto.ResetPasswordRequestDto;
import com.capg.onlineSweetMart.dto.UserDto;
import com.capg.onlineSweetMart.service.EmailService;
import com.capg.onlineSweetMart.service.UserService;

import java.io.IOException;
import java.util.List;

import javax.validation.Valid;

@CrossOrigin("*")
@RestController
@RequestMapping(value = "user")
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private EmailService emailService;
    
    @PostMapping("/signUp")
    public ResponseEntity<UserDto> createUser(@Valid @RequestBody UserDto u) throws IOException {// changes
    	u.setRole("ROLE_USER");
    	u.setResetToken(0);
        return new ResponseEntity<>(userService.signUpUser(u), HttpStatus.CREATED);
    }
    
    @PostMapping("/signIn")
    public ResponseEntity<UserDto> signIn(@RequestBody UserDto u) throws IOException {// changes
    	return new ResponseEntity<>(userService.signIn(u), HttpStatus.OK);
    }
    
    @GetMapping("/readAll")
    public List<UserDto> fetchingUser()
    {
        return userService.readAllUser();
    }

    @DeleteMapping( "/del/{userId}")
    private ResponseEntity<String> deleteuser(@PathVariable("userId")Integer userId)
    {
        return new ResponseEntity<String>(userService.deleteUser(userId),HttpStatus.OK);
    }

    @GetMapping("/read/{userId}")
    public ResponseEntity<UserDto>readUser(@PathVariable("userId")Integer userId)
    {
        return new ResponseEntity<>(userService.readUser(userId),HttpStatus.OK);
    }
    @PatchMapping("/update/{userId}")
    public ResponseEntity<String>updateUser(@PathVariable("userId")Integer userId,@RequestBody UserDto userDto){
    	userDto.setRole("ROLE_USER");
        return new ResponseEntity<>(userService.updateUser(userDto,userId),HttpStatus.OK);
    }
    
    @GetMapping("/loadUserByUsername/{username}")
    public ResponseEntity<UserDto> loadUserByUsername(@PathVariable("username") String userName){
    	return new ResponseEntity<UserDto>(userService.loadUserByUsername(userName),HttpStatus.OK);
    }
    
    @PostMapping("/generateOtp/{email}")
    public ResponseEntity<String> generateOtp(@PathVariable("email")String email){
    	Integer min = 100000;  
    	Integer max = 999999;  
    	Integer resetToken = (int)(Math.random()*(max-min+1)+min);  
    	UserDto userDto = userService.loadUserByUsername(email);
    	userDto.setResetToken(resetToken);
    	userService.updateUser(userDto, userDto.getUserid());
    	
    	String message  = "Your OTP is : "+resetToken;
    	String subject = "OTP from Online Sweet Mart";
    	boolean f = emailService.sendMail(message, subject, "user_123@mailinator.com");
    	
		return null;
    }
    
    @PutMapping("/changePassword")
    public ResponseEntity<String> changePassword(@RequestBody ResetPasswordRequestDto requestDto){
    	UserDto userDto = userService.loadUserByUsername(requestDto.getEmail());	
    	if(userDto.getResetToken().compareTo(requestDto.getOtp()) ==0 ) {
    		userDto.setPassword(requestDto.getNewPassword());
    		userService.updateUser(userDto, userDto.getUserid());
    		return new ResponseEntity<String>("password updated successfully!",HttpStatus.OK);
    	}
    	
		 return new ResponseEntity<String>("Enter valid otp!",HttpStatus.NOT_FOUND);
    	
    }
}
