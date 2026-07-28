package com.joysistvi.recordingapp.service;

import com.joysistvi.recordingapp.model.User;

public interface UserService {

    boolean registerUser(User user);

    boolean loginUser(String username, String password);

    User getUserByUsername(String username);

    boolean deleteUser(int id);

}