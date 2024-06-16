package com.devsukran.spring_boot_restful_webservices.service.impl;

import com.devsukran.spring_boot_restful_webservices.entity.User;
import com.devsukran.spring_boot_restful_webservices.repository.UserRepository;
import com.devsukran.spring_boot_restful_webservices.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;
    @Override
    public User createUser(User user) {

        return userRepository.save(user);

    }

    @Override
    public User getUserById(Long userId) {
        Optional<User> optionalUser =userRepository.findById(userId);
        return optionalUser.get();
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }


}