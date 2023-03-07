package com.example.usershopcart.controller;

import com.example.usershopcart.model.User;
import com.example.usershopcart.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1")
public class UserController {
    @Autowired
    UserService userService;
    @PostMapping("/users")
    public ResponseEntity<Object> createUserRegister(@RequestBody User user){
        return new ResponseEntity<>(userService.addUserRegister(user), HttpStatus.CREATED);
    }
    @PutMapping("/users/{id}")

    public ResponseEntity<User> updateUserProfileManagement(@RequestBody User user, @PathVariable Integer id){
        return  ResponseEntity.ok(userService.userProfileManagement(user,id));
    }
    @GetMapping("/users")
    public List<User> getUserDetail(){
        return userService.getUserDetails();
    }
//@GetMapping("/email/{email}")
//    public ResponseEntity<User> getUserByEmail(@PathVariable("id") String email,Integer id){
//        return ResponseEntity.ok().body(userService.getUserByEmail(email,id));
//    }



}
