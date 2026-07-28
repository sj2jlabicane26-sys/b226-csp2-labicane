package com.joysistvi.recordingapp.view;


import com.joysistvi.recordingapp.controller.AdminController;
import com.joysistvi.recordingapp.model.Admin;

import java.util.Scanner;



public class AdminView {


    private final AdminController adminController;

    private final Scanner scanner =
            new Scanner(System.in);



    public AdminView(AdminController adminController){

        this.adminController = adminController;

    }





    public void createAdmin(){


        System.out.println("\n===== CREATE ADMIN =====");


        System.out.print("Username: ");
        String username = scanner.nextLine();


        System.out.print("Password: ");
        String password = scanner.nextLine();



        Admin admin = new Admin();


        admin.setUsername(username);
        admin.setPassword(password);



        if(adminController.createAdmin(admin)){


            System.out.println(
                    "Admin Created Successfully!");

        }
        else{

            System.out.println(
                    "Failed creating admin.");

        }


    }





    public boolean login(){


        System.out.println("\n===== ADMIN LOGIN =====");


        System.out.print("Username: ");
        String username=scanner.nextLine();


        System.out.print("Password: ");
        String password=scanner.nextLine();



        Admin admin =
                adminController.login(username,password);



        return admin != null;

    }


}