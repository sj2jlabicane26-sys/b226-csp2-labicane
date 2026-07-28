package com.joysistvi.recordingapp.view;

import com.joysistvi.recordingapp.controller.SongController;
import com.joysistvi.recordingapp.model.Song;

import java.util.List;
import java.util.Scanner;

public class SongView {

    private final SongController songController;
    private final Scanner scanner;

    // Mas maganda kung gagamitin din ang Scanner na galing sa Main
    public SongView(SongController songController) {
        this.songController = songController;
        this.scanner = new Scanner(System.in);
    }

    public void showMenu() {
        int choice;

        do {
            System.out.println("\n========== SONG MENU ==========");
            System.out.println("1. Add Song");
            System.out.println("2. View All Songs");
            System.out.println("3. Update Song");
            System.out.println("4. Delete Song");
            System.out.println("5. Archive Song");
            System.out.println("6. Restore Song");
            System.out.println("7. Search Song");
            System.out.println("0. Exit");
            System.out.print("Enter choice: ");

            if (!scanner.hasNextInt()) {
                System.out.println("Invalid input! Enter a number.");
                scanner.nextLine();
                choice = -1;
                continue;
            }

            choice = scanner.nextInt();
            scanner.nextLine(); // Clear buffer

            switch (choice) {
                case 1 -> addSong();
                case 2 -> viewSongs();
                case 3 -> updateSong();
                case 4 -> deleteSong();
                case 5 -> archiveSong();
                case 6 -> restoreSong();
                case 7 -> searchSong();
                case 0 -> System.out.println("Returning to Dashboard...");
                default -> System.out.println("Invalid choice.");
            }

        } while (choice != 0);
    }

    //  ADD
    private void addSong() {
        System.out.print("Title: ");
        String title = scanner.nextLine();

        System.out.print("Length: ");
        String length = scanner.nextLine();

        System.out.print("Genre: ");
        String genre = scanner.nextLine();

        System.out.print("Album ID: ");
        int albumId = scanner.nextInt();
        scanner.nextLine();

        boolean success = songController.addSong(title, length, genre, albumId);

        if (success) {
            System.out.println("Song added successfully!");
        } else {
            System.out.println("Failed to add song.");
        }
    }

    //  VIEW (✅ Ginawang PUBLIC para magamit ng User Menu)
    public void viewSongs() {
        List<Song> songs = songController.listSongs();

        if (songs == null || songs.isEmpty()) {
            System.out.println("No songs found.");
            return;
        }

        System.out.println("\n------------------------------------------------------------");
        System.out.printf("%-5s %-20s %-10s %-15s %-20s%n",
                "ID", "TITLE", "LENGTH", "GENRE", "ALBUM");
        System.out.println("------------------------------------------------------------");

        for (Song song : songs) {
            System.out.printf("%-5d %-20s %-10s %-15s %-20s%n",
                    song.getId(),
                    song.getTitle(),
                    song.getLength(),
                    song.getGenre(),
                    song.getAlbumName());
        }
    }

    //  UPDATE
    private void updateSong() {
        System.out.print("Song ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        System.out.print("New Title: ");
        String title = scanner.nextLine();

        System.out.print("New Length: ");
        String length = scanner.nextLine();

        System.out.print("New Genre: ");
        String genre = scanner.nextLine();

        boolean success = songController.updateSong(id, title, length, genre);

        if (success) {
            System.out.println("Song updated successfully.");
        } else {
            System.out.println("Update failed.");
        }
    }

    //  DELETE
    private void deleteSong() {
        System.out.print("Song ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        boolean success = songController.deleteSong(id);

        if (success) {
            System.out.println("Song deleted successfully.");
        } else {
            System.out.println("Delete failed.");
        }
    }

    //  ARCHIVE
    private void archiveSong() {
        System.out.print("Song ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        boolean success = songController.archiveSong(id);

        if (success) {
            System.out.println("Song archived successfully.");
        } else {
            System.out.println("Archive failed.");
        }
    }

    // RESTORE
    private void restoreSong() {
        System.out.print("Song ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        boolean success = songController.restoreSong(id);

        if (success) {
            System.out.println("Song restored successfully.");
        } else {
            System.out.println("Restore failed.");
        }
    }

    //  SEARCH (✅ Ginawang PUBLIC para magamit ng User Menu)
    public void searchSong() {
        System.out.print("Enter keyword: ");
        String keyword = scanner.nextLine();

        List<Song> songs = songController.searchSong(keyword);

        if (songs == null || songs.isEmpty()) {
            System.out.println("No matching songs found.");
            return;
        }

        System.out.println("\n------------------------------------------------------------");
        System.out.printf("%-5s %-20s %-10s %-15s %-20s%n",
                "ID", "TITLE", "LENGTH", "GENRE", "ALBUM");
        System.out.println("------------------------------------------------------------");

        for (Song song : songs) {
            System.out.printf("%-5d %-20s %-10s %-15s %-20s%n",
                    song.getId(),
                    song.getTitle(),
                    song.getLength(),
                    song.getGenre(),
                    song.getAlbumName());
        }
    }
}