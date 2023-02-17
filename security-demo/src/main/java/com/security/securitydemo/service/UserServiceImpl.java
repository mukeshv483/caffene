package com.security.securitydemo.service;

import com.security.securitydemo.models.Address;
import com.security.securitydemo.models.User;
import com.security.securitydemo.repository.AddressRepository;
import com.security.securitydemo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements  UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private AddressRepository addressRepository;

    public User saveUser(User user){
        addressRepository.save(user.getAddress());
        return userRepository.save(user);
    }
    @Cacheable(value = "user_cache")
    public User findUser(String email){
       return userRepository.findByEmail(email);
    }
    public List<User> getUsers(){
        return userRepository.findAll();
    }


    public User updateUser(User user) {
        User existingUser=userRepository.findByEmail(user.getEmail());
        existingUser.setUserName(user.getUserName());
        user.getAddress().setId(existingUser.getId());
        addressRepository.save(user.getAddress());
        userRepository.save(existingUser);
        return user;
    }



}
