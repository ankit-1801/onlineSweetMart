package com.capg.onlineSweetMart.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.capg.onlineSweetMart.entity.User;
import com.capg.onlineSweetMart.service.UserService;

import java.io.IOException;
import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping(value = "user")
public class UserController {
    @Autowired
    private UserService userService;


    @PostMapping("/signUp")
    public ResponseEntity<User> createUser(@RequestBody User u) throws IOException {// changes
        return new ResponseEntity<>(userService.signUpUser(u), HttpStatus.CREATED);
    }
    @PostMapping("/signIn")
    public ResponseEntity<User> signIn(@RequestBody User u) throws IOException {// changes
    	return new ResponseEntity<>(userService.signIn(u), HttpStatus.OK);
    }
    @GetMapping("/readAll")
    public List<User> fetchingUser()
    {
        return userService.readAllUser();
    }

    @DeleteMapping( "/del/{userId}")
    private ResponseEntity<String> deleteuser(@PathVariable("userId")Integer userId)
    {
        return new ResponseEntity<String>(userService.deleteUser(userId),HttpStatus.OK);
    }

    @GetMapping("/read/{userId}")
    public ResponseEntity<User>readuser(@PathVariable("userId")Integer userId)
    {
        return new ResponseEntity<>(userService.readUser(userId),HttpStatus.OK);
    }
    @PatchMapping("/update/{userId}")
    public ResponseEntity<String>updateUser(@PathVariable("userId")Integer userId,@RequestBody User user){
        return new ResponseEntity<>(userService.updateUser(user,userId),HttpStatus.OK);
    }
    
}
