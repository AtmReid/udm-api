package com.example.udmapi.service;



import com.example.udmapi.entity.User;

import java.util.List;

public interface UserService {

    List<User> getAllUsers();

    void saveUser(User user);

    User getUser(int id);


}
