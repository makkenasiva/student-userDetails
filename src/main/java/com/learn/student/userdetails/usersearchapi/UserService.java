package com.learn.student.userdetails.usersearchapi;

import org.springframework.stereotype.Service;

@Service
public class UserService {
    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User searchUser(String query) {
        User user = userRepository.findByFirstname(query);
        if (user != null) {
            return user;
        }

        user = userRepository.findByUsername(query);
        if (user != null) {
            return user;
        }

        user = userRepository.findByEmail(query);
        if (user != null) {
            return user;
        }

        return null; // No user found
    }
}


