package com.joysistvi.recordingapp.view;

import java.util.Scanner;

public class Dashboard {

    private final Scanner scanner = new Scanner(System.in);

    private final SongView songView;
    private final ArtistView artistView;
    private final AlbumView albumView;
    private final UserView userView;

    public Dashboard(SongView songView, ArtistView artistView, AlbumView albumView, UserView userView) {
        this.songView = songView;
        this.artistView = artistView;
        this.albumView = albumView;
        this.userView = userView;
    }

//    public Dashboard(SongView songView, ArtistView artistView, AlbumView albumView) {
//        this.songView = songView;
//        this.artistView = artistView;
//        this.albumView = albumView;
//    }

    public void mainMenu() {

        int choice;

        do {
            System.out.println("\n===== Recording Studio App =====");
            System.out.println("1. Manage Songs");
            System.out.println("2. Manage Albums");
            System.out.println("3. Manage Artists");
            System.out.println("4. Manage Users");
            System.out.println("0. Exit");
            System.out.print("Enter choice: ");

            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

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
                    userView.showMenu();

                case 0:
                    System.out.println("Exiting application...");
                    break;

                default:
                    System.out.println("Invalid choice.");
            }

        } while (choice != 0);
    }
}