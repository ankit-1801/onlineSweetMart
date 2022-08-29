package com.capg.onlineSweetMart.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.capg.onlineSweetMart.exception.UserNotFoundException;
import com.capg.onlineSweetMart.entity.User;
import com.capg.onlineSweetMart.repository.UserRepository;
import com.capg.onlineSweetMart.service.UserService;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;
    
	@Override
	public User signUpUser(User user) {
		return userRepository.save(user);
	}



	@Override
	public String updateUser(User user, Integer id) {
		User u = userRepository.findById(id).orElseThrow(() -> new UserNotFoundException("user with id " + id + " is mot found"));
        boolean needUpdate = false;
        if (StringUtils.hasLength(user.getName())) {
            u.setName(user.getName());
            needUpdate = true;
        }
        if (StringUtils.hasLength(user.getPassword())) {
            u.setPassword(user.getPassword());
            needUpdate = true;
        }
        if (StringUtils.hasLength(user.getRole())) {
            u.setRole(user.getRole());
            needUpdate = true;
        }
        if (StringUtils.hasLength(user.getEmail())) {
        	u.setEmail(user.getRole());
        	needUpdate = true;
        }
        
        if (needUpdate) {
            userRepository.save(u);
            return "User updated successfully";
        }
        return "nothing to update";
	}

	@Override
	public String deleteUser(Integer id) {
		userRepository.findById(id).orElseThrow(() -> new UserNotFoundException("user with id " + id + " is not found"));
        userRepository.deleteById(id);
        return "user deleted";
	}

	@Override
	public User readUser(Integer id) {
		User user = userRepository.findById(id).orElseThrow(() -> new UserNotFoundException("user with this id " + id + " is not available"));
        return user;
	}

	@Override
	public List<User> readAllUser() {
		List<User> userList = new ArrayList<User>();
        userRepository.findAll().forEach(user -> userList.add(user));
        return userList;
	}
	
	@Override
	public User loadUserByUsername(String username) {
		
		return userRepository.loadUserByUsername(username);
	}



	@Override
	public User signIn(User user) {
		// TODO Auto-generated method stub
		return null;
	}

}
