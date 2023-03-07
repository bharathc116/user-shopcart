package com.example.usershopcart.service;

import com.example.usershopcart.exception.userNotFoundException;
import com.example.usershopcart.model.User;

import java.util.List;

public interface UserService {

 User addUserRegister(User user);
 User userProfileManagement(User user,Integer id);
 List<User> getUserDetails();
 User userAuthentication(User user,String email) throws userNotFoundException;
// User getUserByEmail(String email,Integer id);
}
