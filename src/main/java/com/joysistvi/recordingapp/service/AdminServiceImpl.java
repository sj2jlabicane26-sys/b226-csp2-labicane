package com.joysistvi.recordingapp.service;


import com.joysistvi.recordingapp.model.Admin;
import com.joysistvi.recordingapp.repository.AdminRepository;



public class AdminServiceImpl implements AdminService {


    private final AdminRepository adminRepository;



    public AdminServiceImpl(AdminRepository adminRepository){

        this.adminRepository = adminRepository;

    }




    @Override
    public boolean createAdmin(Admin admin){

        return adminRepository.createAdmin(admin);

    }



    @Override
    public Admin login(String username,String password){

        return adminRepository.login(username,password);

    }


}