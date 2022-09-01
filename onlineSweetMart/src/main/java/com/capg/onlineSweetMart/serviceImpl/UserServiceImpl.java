package com.capg.onlineSweetMart.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.capg.onlineSweetMart.exception.UserNotFoundException;
import com.capg.onlineSweetMart.helper.Converter;
import com.capg.onlineSweetMart.dto.UserDto;
import com.capg.onlineSweetMart.entity.User;
import com.capg.onlineSweetMart.repository.UserRepository;
import com.capg.onlineSweetMart.service.UserService;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;
    
	@Autowired
	public Converter converter;
    
	@Override
	public UserDto signUpUser(UserDto userDto) {
		return converter.convertUserToUserDto(userRepository.save(converter.convertUserDtoToUser(userDto)));
	}



	@Override
	public String updateUser(UserDto userDto, Integer id) {
		User u = userRepository.findById(id).orElseThrow(() -> new UserNotFoundException("user with id " + id + " is mot found"));
		User user = converter.convertUserDtoToUser(userDto);
        if (StringUtils.hasLength(user.getName())) {
            u.setName(user.getName());
        }
        if (StringUtils.hasLength(user.getPassword())) {
            u.setPassword(user.getPassword());
        }
        if (StringUtils.hasLength(user.getRole())) {
            u.setRole(user.getRole());
        }
        if (StringUtils.hasLength(user.getEmail())) {
        	u.setEmail(user.getRole());
        }
        if (StringUtils.hasLength(user.getStreet())) {
        	u.setStreet(user.getStreet());
        }
        if (StringUtils.hasLength(user.getState())) {
        	u.setState(user.getState());
        }
        if (StringUtils.hasLength(user.getPincode())) {
        	u.setPincode(user.getPincode());
        }
        if (StringUtils.hasLength(user.getCity())) {
        	u.setCity(user.getCity());
        }
        userRepository.save(u);
       return "User updated successfully";
	}

	@Override
	public String deleteUser(Integer id) {
		userRepository.findById(id).orElseThrow(() -> new UserNotFoundException("user with id " + id + " is not found"));
        userRepository.deleteById(id);
        return "user deleted";
	}

	@Override
	public UserDto readUser(Integer id) {
		User user = userRepository.findById(id).orElseThrow(() -> new UserNotFoundException("user with this id " + id + " is not available"));
        return converter.convertUserToUserDto(user);
	}

	@Override
	public List<UserDto> readAllUser() {
		List<User> userList = new ArrayList<User>();
        userRepository.findAll().forEach(user -> userList.add(user));
        List<UserDto> li = new ArrayList<UserDto>();
        for(User user : userList) {
        	li.add(converter.convertUserToUserDto(user));
        }
        return li;
	}
	
	@Override
	public UserDto loadUserByUsername(String username) {
		User user = new User();
		try {
			user = userRepository.loadUserByUsername(username);
		}
		catch (Exception e) {
			// TODO: handle exception
			throw new UserNotFoundException("user with username (" + username + ") not found");
		}
		return converter.convertUserToUserDto(user);
	}



	@Override
	public UserDto signIn(UserDto userDto) {
		// TODO Auto-generated method stub
		return null;
	}

}
