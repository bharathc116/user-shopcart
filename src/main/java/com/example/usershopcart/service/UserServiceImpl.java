package com.example.usershopcart.service;

import com.example.usershopcart.exception.userNotFoundException;
import com.example.usershopcart.model.Address;
import com.example.usershopcart.model.User;
import com.example.usershopcart.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    UserRepo userRepo;
    @Override
    public User addUserRegister(User user) {
        return userRepo.save(user);

    }

    @Override
    public User userProfileManagement(User user, Integer id) {
        User user1=userRepo.findById(id).orElseThrow(
                ()->new RuntimeException()
        );
        user1.setEmail(user.getEmail());
        user1.setPassword(user.getPassword());
        user1.setName(user.getName());
        user1.setAddress(user.getAddress());
        user1.setDob(user.getDob());
        user1.setGenderType(user.getGenderType());
        user1.setPhone_number(user.getPhone_number());
        user1.setAccountCreationDate(user.getAccountCreationDate());
        user1.setUserRoleType(user.getUserRoleType());
        user1.setAccountStatus(user.getAccountStatus());
        return userRepo.save(user1);
    }

    @Override
    public List<User> getUserDetails() {
        return userRepo.findAll();
    }

    @Override
    public User userAuthentication(User user, String email) throws userNotFoundException {
        Optional<User> optionalUser=userRepo.findByEmail(email);
        if(!user.isPresent()){
            User user1=optionalUser.orElseThrow(
                    ()->new userNotFoundException(" User not found with this Email:"+email)
            ) ;
        }
        return new User(user.getId(), user.getEmail());
    }

//    public User getUserByEmail(String email,Integer id)
//    {
//        User user=userRepo.getUserByEmail(email);
//        return user;
//    }


    }

