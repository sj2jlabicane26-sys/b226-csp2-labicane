package com.joysistvi.recordingapp.view;

import java.util.Scanner;

public class AdminDashboard {

    private final Scanner scanner = new Scanner(System.in);

    // Declare the fields
    private final SongView songView;
    private final ArtistView artistView;
    private final AlbumView albumView;
    private final UserDashboard userDashboard;
    private final AdminView adminView;

    public AdminDashboard(
            SongView songView,
            ArtistView artistView,
            AlbumView albumView,
            UserDashboard userDashboard,
            AdminView adminView) {

        this.songView = songView;
        this.artistView = artistView;
        this.albumView = albumView;
        this.userDashboard = userDashboard;
        this.adminView = adminView;
    }

    public void mainMenu() {

        int choice;

        do {

            System.out.println("\n===== ADMIN DASHBOARD =====");
            System.out.println("1. Manage Songs");
            System.out.println("2. Manage Albums");
            System.out.println("3. Manage Artists");
            System.out.println("4. Manage Users");
            System.out.println("0. Logout");
            System.out.print("Enter Choice: ");

            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {

                case 1:
                    songView.showMenu();
                    break;

                case 2:
                    albumView.showMenu();
                    break;

                case 3:
                    artistView.showMenu();
                    break;

                case 4:
                    userDashboard.showMenu();
                    break;

                case 0:
                    System.out.println("Admin Logout...");
                    break;

                default:
                    System.out.println("Invalid Choice!");
            }

        } while (choice != 0);
    }
}