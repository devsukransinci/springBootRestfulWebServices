package com.devsukran.spring_boot_restful_webservices.service;

import com.devsukran.spring_boot_restful_webservices.entity.User;

import java.util.List;

public interface UserService {
    User createUser(User user);
    User getUserById(Long userId);
    List<User>getAllUsers();
}
