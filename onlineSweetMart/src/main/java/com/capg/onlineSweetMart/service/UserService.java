package com.capg.onlineSweetMart.service;

import java.util.List;
import com.capg.onlineSweetMart.entity.User;

public interface UserService {
    public User signUpUser(User user);
    public User signIn(User user);
    public String updateUser(User user, Integer id);
    public String deleteUser(Integer id);
    public User readUser(Integer id);
    public List<User> readAllUser();
}
