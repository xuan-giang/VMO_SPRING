package com.example.springsecurityexample.service;

import com.example.springsecurityexample.model.User;

import java.util.List;

public interface UserService {

    public User createUser(User user);

    public boolean isExistUserByUsername(User user);

    public User findByUsername(String username);


    public List<User> getAllUser();

    public void processOAuthPostLogin(String username);

    public boolean isGoogleAccount(String username);
}
