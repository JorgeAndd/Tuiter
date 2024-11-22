package com.me.tuiter.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.me.tuiter.dto.UserDTO;
import com.me.tuiter.model.User;
import com.me.tuiter.repository.UserRepository;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User registerUser(User user) {
        if (userRepository.existsByUsername(user.getUsername())) {
            throw new RuntimeException("Username is already taken");
        }

        if (userRepository.existsByEmail(user.getEmail())) {
            throw new RuntimeException("Email is already in use");
        }

        return userRepository.save(user);
    }

    public UserDTO findUserByUsername(String username) {
        User user =  userRepository.findByUsername(username)
                        .orElseThrow(() -> new RuntimeException("User not found"));

        return new UserDTO(user);
    }
}
