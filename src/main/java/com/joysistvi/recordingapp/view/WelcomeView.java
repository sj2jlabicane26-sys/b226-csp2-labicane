package com.joysistvi.recordingapp.view;

import com.joysistvi.recordingapp.controller.UserController;

import java.util.Scanner;


public class WelcomeView {


    private final UserController userController;
    private final AdminDashboard adminDashboard;
    private final UserDashboard userDashboard;

    private final Scanner scanner = new Scanner(System.in);



    public WelcomeView(
            UserController userController,
            AdminDashboard adminDashboard,
            UserDashboard userDashboard) {

        this.userController = userController;
        this.adminDashboard = adminDashboard;
        this.userDashboard = userDashboard;

    }



    // ==========================
    // MAIN MENU
    // ==========================

    public boolean showMenu() {


        int choice;


        do {


            System.out.println("\n=================================");
            System.out.println("     RECORDING STUDIO APP");
            System.out.println("=================================");
            System.out.println("1. Admin Login");
            System.out.println("2. User Login");
            System.out.println("3. Register User");
            System.out.println("0. Exit");
            System.out.print("Enter Choice: ");


            choice = scanner.nextInt();
            scanner.nextLine();



            switch(choice) {


                case 1:

                    adminLogin();

                    break;



                case 2:

                    userLogin();

                    break;



                case 3:

                    registerUser();

                    break;



                case 0:

                    System.out.println(
                            "Closing Recording Studio App..."
                    );

                    return false;



                default:

                    System.out.println(
                            "Invalid Choice!"
                    );

            }


        } while(choice != 0);



        return false;

    }





    // ==========================
    // ADMIN LOGIN
    // ==========================

    private void adminLogin() {


        System.out.println("\n========== ADMIN LOGIN ==========");


        System.out.print("Username: ");
        String username = scanner.nextLine();


        System.out.print("Password: ");
        String password = scanner.nextLine();



        /*
          Temporary Admin Login

          Pwede mo palitan kapag
          naka-connect na ang Admin table
        */

        if(username.equals("admin")
                && password.equals("admin123")) {


            System.out.println(
                    "\nAdmin Login Successful!"
            );


            adminDashboard.mainMenu();



        } else {


            System.out.println(
                    "Invalid Admin Account!"
            );


        }

    }





    // ==========================
    // USER LOGIN
    // ==========================

    private void userLogin() {


        System.out.println("\n========== USER LOGIN ==========");


        System.out.print("Username: ");
        String username = scanner.nextLine();



        System.out.print("Password: ");
        String password = scanner.nextLine();




        boolean login =
                userController.loginUser(
                        username,
                        password
                );




        if(login) {


            System.out.println(
                    "\nUser Login Successful!"
            );


            // PUNTA SA USER DASHBOARD

            userDashboard.showMenu();



        } else {


            System.out.println(
                    "Invalid Username or Password!"
            );


        }


    }





    // ==========================
    // REGISTER USER
    // ==========================

    private void registerUser() {


        System.out.println("\n========== USER REGISTRATION ==========");



        System.out.print("Username: ");
        String username = scanner.nextLine();



        System.out.print("Password: ");
        String password = scanner.nextLine();



        System.out.print("Playlist ID: ");
        int playlistId = scanner.nextInt();
        scanner.nextLine();




        boolean result =
                userController.registerUser(
                        username,
                        password,
                        playlistId
                );




        if(result) {


            System.out.println(
                    "Registration Successful!"
            );


        } else {


            System.out.println(
                    "Registration Failed!"
            );


        }


    }


}