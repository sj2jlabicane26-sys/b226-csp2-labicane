package com.joysistvi.recordingapp.service;

import com.joysistvi.recordingapp.model.User;
import com.joysistvi.recordingapp.repository.UserRepository;

public class UserServiceImpl implements UserService {


    private final UserRepository userRepository;


    // Constructor Injection
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }



    // REGISTER USER
    @Override
    public boolean registerUser(User user) {

        if (user == null) {
            return false;
        }

        // Validation
        if (user.getUsername() == null || user.getUsername().isEmpty()) {
            return false;
        }

        if (user.getPassword() == null || user.getPassword().isEmpty()) {
            return false;
        }


        return userRepository.registerUser(user);
    }





    //  LOGIN USER
    @Override
    public boolean loginUser(String username, String password) {


        if (username == null || username.isEmpty()) {
            return false;
        }


        if (password == null || password.isEmpty()) {
            return false;
        }


        return userRepository.loginUser(username, password);
    }





    // GET USER BY USERNAME
    @Override
    public User getUserByUsername(String username) {


        if (username == null || username.isEmpty()) {
            return null;
        }


        return userRepository.getUserByUsername(username);
    }





    //  DELETE USER
    @Override
    public boolean deleteUser(int id) {


        if (id <= 0) {
            return false;
        }


        return userRepository.deleteUser(id);
    }

}