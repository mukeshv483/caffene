package com.security.securitydemo.controller;


import com.security.securitydemo.models.User;
import com.security.securitydemo.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserServiceImpl userService;

    @GetMapping(value = "/{email}",produces = MediaType.APPLICATION_JSON_VALUE)
  public User findUser(@PathVariable("email") String email){
        return userService.findUser(email);
    }
    @GetMapping(value = "/",produces = MediaType.APPLICATION_JSON_VALUE)
    public List<User> getUsers(){
        return userService.getUsers();
    }
    @PostMapping(value = "/register",produces = MediaType.APPLICATION_JSON_VALUE)
    public User addUsers(@RequestBody  User user){
        return userService.saveUser(user);
    }
    @PostMapping(value = "/update",produces = MediaType.APPLICATION_JSON_VALUE)
    public User updateUsers(@RequestBody  User user){
        return userService.updateUser(user);
    }
}
