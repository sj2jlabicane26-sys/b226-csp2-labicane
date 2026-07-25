package com.joysistvi.recordingapp.view;

import com.joysistvi.recordingapp.controller.SongController;

import java.util.Scanner;

public class SongView {

    private final SongController songController;
    private final Scanner scanner = new Scanner(System.in);

    // Constructor injection
    public SongView(SongController songController) {
        this.songController = songController;
    }

    public void showMenu() {
        int choice;
        do {
            System.out.println("\n--- Song Menu ---");
            System.out.println("1. Add Song");
            System.out.println("2. View All Songs");
            System.out.println("3. Update Song");
            System.out.println("4. Delete Song");
            System.out.println("5. Archive Song");
            System.out.println("6. Restore Song");
            System.out.println("7. Search Song");
            System.out.println("0. Exit");
            System.out.print("Enter choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.println("Add Song");
                    //songController.addSong();
                    break;
                case 2:
                    System.out.println("View All Songs");
                    songController.listSongs();
                    break;
                default:
                    System.out.println("Invalid choice");
            }
        } while (choice != 0);
    }

}
