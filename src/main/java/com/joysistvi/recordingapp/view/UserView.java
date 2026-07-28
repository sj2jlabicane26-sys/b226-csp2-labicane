package com.joysistvi.recordingapp.view;

import com.joysistvi.recordingapp.controller.UserController;
import com.joysistvi.recordingapp.model.User;

import java.util.Scanner;

public class UserView {

    private final UserController userController;
    private final Scanner scanner;


    public UserView(UserController userController) {
        this.userController = userController;
        this.scanner = new Scanner(System.in);
    }



    public void showMenu() {

        int choice;


        do {

            System.out.println("\n===== USER MENU =====");
            System.out.println("1. Register User");
            System.out.println("2. Login User");
            System.out.println("3. Search User");
            System.out.println("4. Delete User");
            System.out.println("0. Back");
            System.out.print("Enter Choice: ");


            choice = scanner.nextInt();
            scanner.nextLine();


            switch (choice) {


                case 1:
                    registerUser();
                    break;


                case 2:
                    loginUser();
                    break;


                case 3:
                    searchUser();
                    break;


                case 4:
                    deleteUser();
                    break;


                case 0:
                    System.out.println("Returning to Dashboard...");
                    break;


                default:
                    System.out.println("Invalid Choice!");

            }


        } while (choice != 0);

    }




    //  REGISTER USER

    private void registerUser() {


        System.out.print("Enter Username: ");
        String username = scanner.nextLine();


        System.out.print("Enter Password: ");
        String password = scanner.nextLine();


        System.out.print("Enter Playlist ID: ");
        int playlistId = scanner.nextInt();
        scanner.nextLine();



        boolean result = userController.registerUser(
                username,
                password,
                playlistId
        );


        if (result) {

            System.out.println("User registered successfully!");

        } else {

            System.out.println("Failed to register user.");
        }

    }





    //  LOGIN USER

    private void loginUser() {


        System.out.print("Enter Username: ");
        String username = scanner.nextLine();


        System.out.print("Enter Password: ");
        String password = scanner.nextLine();



        boolean result = userController.loginUser(
                username,
                password
        );


        if (result) {

            System.out.println("Login successful!");

        } else {

            System.out.println("Invalid username or password.");

        }

    }





    //  SEARCH USER

    private void searchUser() {


        System.out.print("Enter Username: ");
        String username = scanner.nextLine();



        User user = userController.getUserByUsername(username);



        if (user != null) {


            System.out.println("\n===== USER INFORMATION =====");
            System.out.println("ID: " + user.getId());
            System.out.println("Username: " + user.getUsername());
            System.out.println("Playlist ID: " + user.getPlaylist_id());


        } else {


            System.out.println("User not found.");

        }

    }





    // DELETE USER

    private void deleteUser() {


        System.out.print("Enter User ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();



        if (userController.deleteUser(id)) {


            System.out.println("User deleted successfully!");


        } else {


            System.out.println("Failed to delete user.");

        }

    }

}