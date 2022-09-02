package com.capg.onlineSweetMart.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.capg.onlineSweetMart.dto.UserDto;
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


    @PostMapping("/signUp")
    public ResponseEntity<UserDto> createUser(@Valid @RequestBody UserDto u) throws IOException {// changes
    	u.setRole("ROLE_USER");
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
}
