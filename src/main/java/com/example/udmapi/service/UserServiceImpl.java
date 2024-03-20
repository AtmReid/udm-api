package com.example.udmapi.service;

import com.example.udmapi.repository.UserRepository;
import com.example.udmapi.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public void saveUser(User user) {
        userRepository.saveUser(user);
    }

    @Override
    public User getUser(int id) {
        User user = null;

        Optional<User> optional = userRepository.findById(id);
        if (optional.isPresent()){
            user = optional.get();
        }
        return user;
    }
}
