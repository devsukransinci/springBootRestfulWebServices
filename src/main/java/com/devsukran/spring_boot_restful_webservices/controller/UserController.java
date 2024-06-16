package com.devsukran.spring_boot_restful_webservices.controller;

import com.devsukran.spring_boot_restful_webservices.entity.User;
import com.devsukran.spring_boot_restful_webservices.service.UserService;
import com.devsukran.spring_boot_restful_webservices.service.impl.UserServiceImpl;
import lombok.AllArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/users")
public class UserController {

    private UserService userService;

    //build create user REST API
    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user){
       User savedUser= userService.createUser(user);
       return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
    }

    //build get user by id REST API
    // http://localhost:8080/api/users/1
    @GetMapping("{id}")
    public ResponseEntity<User >getUserbyId(@PathVariable ("id") Long userId){
        User user =userService.getUserById(userId);
        return new ResponseEntity<>(user,HttpStatus.OK);

    }
   //build Get All Users REST API
    @GetMapping
    public ResponseEntity<List<User>> getAllUsers(){
        List<User> users=userService.getAllUsers();
        return new ResponseEntity<>(users,HttpStatus.OK);
    }

    // Build Update User REST API
    @PutMapping("{id}")
    // http://localhost:8080/api/users/1
    public ResponseEntity <User> updateUser(@PathVariable("id") Long userId,
                                           @RequestBody User user){
        user.setId(userId);
      User updateUser= userService.updateUser(user);
      return new ResponseEntity<>(updateUser,HttpStatus.OK);

    }

    //Build Delete User REST API
    @DeleteMapping("{id}")
    public ResponseEntity<String>deleteUser(@PathVariable ("id") Long userId){
        userService.deleteUser(userId);
        return new ResponseEntity<>("User Successfully deleted!",HttpStatus.OK);
    }



}
