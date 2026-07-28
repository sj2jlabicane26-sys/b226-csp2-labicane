package com.joysistvi.recordingapp.service;

import com.joysistvi.recordingapp.model.Admin;

public interface AdminService {


    boolean createAdmin(Admin admin);


    Admin login(String username,String password);

}