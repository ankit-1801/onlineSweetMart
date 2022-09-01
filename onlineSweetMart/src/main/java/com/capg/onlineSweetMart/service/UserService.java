package com.capg.onlineSweetMart.service;

import java.util.List;

import com.capg.onlineSweetMart.dto.UserDto;

public interface UserService {
    public UserDto signUpUser(UserDto userDto);
    public UserDto signIn(UserDto userDto);
    public String updateUser(UserDto userDto, Integer id);
    public String deleteUser(Integer id);
    public UserDto readUser(Integer id);
    public List<UserDto> readAllUser();
	public UserDto loadUserByUsername(String username);
}
