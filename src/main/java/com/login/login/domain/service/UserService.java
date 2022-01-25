package com.login.login.domain.service;

import java.util.Optional;

import com.login.login.domain.User;
import com.login.login.domain.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public Optional<User> findByUserName(String userName) {
        return userRepository.findByUserName(userName);
    }

    public void save(User user) {
        userRepository.save(user);
    }
}
