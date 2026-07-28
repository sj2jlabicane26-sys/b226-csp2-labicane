package com.joysistvi.recordingapp.repository;

import com.joysistvi.recordingapp.model.User;

public interface UserRepository {

    boolean registerUser(User user);

    boolean loginUser(String username, String password);

    User getUserByUsername(String username);

    boolean deleteUser(int id);

}