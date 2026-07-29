package com.joysistvi.recordingapp.controller;

import com.joysistvi.recordingapp.model.User;
import com.joysistvi.recordingapp.service.UserService;

public class UserController {

    private final UserService userService;


    // Constructor Injection
    public UserController(UserService userService) {
        this.userService = userService;
    }


    // REGISTER USER
    public boolean registerUser(String username, String password, int playlistId) {

        User user = new User();

        user.setUsername(username);
        user.setPassword(password);
        user.setPlaylist_id(playlistId);

        return userService.registerUser(user);
    }



    //  LOGIN USER
    public boolean loginUser(String username, String password) {

        return userService.loginUser(username, password);
    }



    //  GET USER BY USERNAME
    public User getUserByUsername(String username) {

        return userService.getUserByUsername(username);
    }



    //  DELETE USER
    public boolean deleteUser(int id) {

        return userService.deleteUser(id);
    }

}