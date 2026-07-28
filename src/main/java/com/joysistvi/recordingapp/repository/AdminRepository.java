package com.joysistvi.recordingapp.repository;

import com.joysistvi.recordingapp.model.Admin;

public interface AdminRepository {


    boolean createAdmin(Admin admin);


    Admin login(String username, String password);


}