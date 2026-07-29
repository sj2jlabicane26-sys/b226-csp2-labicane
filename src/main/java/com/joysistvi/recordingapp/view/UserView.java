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

    // SER MANAGEMENT MENU
    public void showMenu() {
        int choice;

        do {
            System.out.println("\n========== MANAGE USERS ==========");
            System.out.println("1. Register User");
            System.out.println("2. Search User by Username");
            System.out.println("3. Delete User");
            System.out.println("0. Back to Admin Dashboard");
            System.out.print("Enter choice: ");

            if (!scanner.hasNextInt()) {
                System.out.println("Invalid input! Please enter a number.");
                scanner.nextLine(); // clear invalid input
                choice = -1;
                continue;
            }

            choice = scanner.nextInt();
            scanner.nextLine(); // Clear buffer

            switch (choice) {
                case 1:
                    registerUser();
                    break;
                case 2:
                    getUserByUsername();
                    break;
                case 3:
                    deleteUser();
                    break;
                case 0:
                    System.out.println("Returning to Admin Dashboard...");
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }

        } while (choice != 0);
    }

    //  REGISTER USER
    public void registerUser() {

        System.out.println("\n========== REGISTER USER ==========");

        System.out.print("Enter Username: ");
        String username = scanner.nextLine();

        System.out.print("Enter Password: ");
        String password = scanner.nextLine();

        System.out.print("Enter Playlist ID: ");
        while (!scanner.hasNextInt()) {
            System.out.println("Invalid ID! Please enter a number.");
            scanner.next();
        }
        int playlistId = scanner.nextInt();
        scanner.nextLine();

        boolean success = userController.registerUser(username, password, playlistId);

        if (success) {
            System.out.println("User registered successfully!");
        } else {
            System.out.println("Failed to register user.");
        }
    }

    //  LOGIN USER
    public void loginUser() {

        System.out.println("\n========== USER LOGIN ==========");

        System.out.print("Username: ");
        String username = scanner.nextLine();

        System.out.print("Password: ");
        String password = scanner.nextLine();

        boolean success = userController.loginUser(username, password);

        if (success) {
            System.out.println("Login Successful!");
        } else {
            System.out.println("Invalid Username or Password.");
        }
    }

    // SEARCH USER
    public void getUserByUsername() {

        System.out.println("\n========== SEARCH USER ==========");

        System.out.print("Enter Username: ");
        String username = scanner.nextLine();

        User user = userController.getUserByUsername(username);

        if (user != null) {

            System.out.println("\n===== USER INFORMATION =====");
            System.out.println("ID          : " + user.getId());
            System.out.println("Username    : " + user.getUsername());
            System.out.println("Password    : " + user.getPassword());
            System.out.println("Playlist ID : " + user.getPlaylist_id());

        } else {

            System.out.println("User not found.");
        }
    }

    //  DELETE USER
    public void deleteUser() {

        System.out.println("\n========== DELETE USER ==========");

        System.out.print("Enter User ID: ");
        while (!scanner.hasNextInt()) {
            System.out.println("Invalid ID! Please enter a number.");
            scanner.next();
        }
        int id = scanner.nextInt();
        scanner.nextLine();

        boolean success = userController.deleteUser(id);

        if (success) {
            System.out.println("User deleted successfully!");
        } else {
            System.out.println("Failed to delete user.");
        }
    }
}