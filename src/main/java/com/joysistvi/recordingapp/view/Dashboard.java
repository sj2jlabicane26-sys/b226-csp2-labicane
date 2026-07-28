package com.joysistvi.recordingapp.view;

import java.util.Scanner;

public class Dashboard {

    private final Scanner scanner = new Scanner(System.in);

    private final SongView songView;
    private final ArtistView artistView;

    public Dashboard(SongView songView, ArtistView artistView) {
        this.songView = songView;
        this.artistView = artistView;
    }

    public void mainMenu() {

        int choice;

        do {
            System.out.println("\n===== Recording Studio App =====");
            System.out.println("1. Manage Songs");
            System.out.println("2. Manage Albums");
            System.out.println("3. Manage Artists");
            System.out.println("0. Exit");
            System.out.print("Enter choice: ");

            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {

                case 1:
                    songView.showMenu();
                    break;

                case 2:
                    System.out.println("Album module is under development.");
                    break;

                case 3:
                    artistView.showMenu();
                    break;

                case 0:
                    System.out.println("Exiting application...");
                    break;

                default:
                    System.out.println("Invalid choice.");
            }

        } while (choice != 0);
    }
}