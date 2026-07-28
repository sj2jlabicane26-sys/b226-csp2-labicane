package com.joysistvi.recordingapp.controller;


import com.joysistvi.recordingapp.model.Admin;
import com.joysistvi.recordingapp.service.AdminService;


public class AdminController {


    private final AdminService adminService;



    public AdminController(AdminService adminService){

        this.adminService = adminService;

    }




    public boolean createAdmin(Admin admin){

        return adminService.createAdmin(admin);

    }




    public Admin login(String username,String password){

        return adminService.login(username,password);

    }


}