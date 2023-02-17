package com.security.securitydemo.service;

import com.security.securitydemo.models.User;

import java.util.List;

public interface UserService {
    User saveUser(User user);

    User findUser(String email);

    List<User> getUsers();

}
