package com.joysistvi.recordingapp.view;

import com.joysistvi.recordingapp.controller.AlbumController;
import com.joysistvi.recordingapp.model.Album;

import java.util.List;
import java.util.Scanner;

public class AlbumView {

    private final AlbumController albumController;
    private final Scanner scanner;

    public AlbumView(AlbumController albumController) {
        this.albumController = albumController;
        this.scanner = new Scanner(System.in);
    }
    public void viewAlbums() {
        displayAlbums();
    }

    public void showMenu() {

        int choice;

        do {

            System.out.println("\n===== ALBUM MENU =====");
            System.out.println("1. Add Album");
            System.out.println("2. View All Albums");
            System.out.println("3. Update Album");
            System.out.println("4. Archive Album");
            System.out.println("5. Search Album");
            System.out.println("6. View Archived Albums");
            System.out.println("7. Restore Album");
            System.out.println("0. Back");
            System.out.print("Enter Choice: ");

            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {

                case 1:
                    addAlbum();
                    break;

                case 2:
                    displayAlbums();
                    break;

                case 3:
                    updateAlbum();
                    break;

                case 4:
                    archiveAlbum();
                    break;

                case 5:
                    searchAlbum();
                    break;

                case 6:
                    displayArchivedAlbums();
                    break;

                case 7:
                    restoreAlbum();
                    break;

                case 0:
                    System.out.println("Returning to Dashboard...");
                    break;

                default:
                    System.out.println("Invalid Choice!");
            }

        } while (choice != 0);
    }

    // ================= ADD ALBUM =================
    private void addAlbum() {

        System.out.print("Enter Album Name: ");
        String name = scanner.nextLine();

        System.out.print("Enter Release Year: ");
        int year = scanner.nextInt();

        System.out.print("Enter Artist ID: ");
        int artistId = scanner.nextInt();
        scanner.nextLine();

        if (albumController.addAlbum(name, year, artistId)) {
            System.out.println("Album added successfully!");
        } else {
            System.out.println("Failed to add album.");
        }
    }

    // ================= VIEW ALL ALBUMS =================
    private void displayAlbums() {

        List<Album> albums = albumController.getAllAlbums();

        if (albums.isEmpty()) {
            System.out.println("No albums found.");
            return;
        }

        System.out.println("\n===== ALBUM LIST =====");
        System.out.printf("%-5s %-25s %-10s %-10s%n",
                "ID", "NAME", "YEAR", "ARTIST");

        for (Album album : albums) {

            System.out.printf("%-5d %-25s %-10d %-10d%n",
                    album.getId(),
                    album.getName(),
                    album.getYear(),
                    album.getArtistId());
        }
    }

    // ================= UPDATE ALBUM =================
    private void updateAlbum() {

        System.out.print("Enter Album ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter New Album Name: ");
        String newName = scanner.nextLine();

        System.out.print("Enter New Release Year: ");
        int newYear = scanner.nextInt();
        scanner.nextLine();

        if (albumController.updateAlbum(id, newName, newYear)) {
            System.out.println("Album updated successfully!");
        } else {
            System.out.println("Failed to update album.");
        }
    }

    // ================= ARCHIVE ALBUM =================
    private void archiveAlbum() {

        System.out.print("Enter Album ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        if (albumController.archiveAlbum(id)) {
            System.out.println("Album archived successfully!");
        } else {
            System.out.println("Failed to archive album.");
        }
    }

    // ================= SEARCH ALBUM =================
    private void searchAlbum() {

        System.out.print("Enter keyword: ");
        String keyword = scanner.nextLine();

        List<Album> albums = albumController.searchAlbum(keyword);

        if (albums.isEmpty()) {
            System.out.println("No matching albums found.");
            return;
        }

        System.out.println("\n===== SEARCH RESULT =====");
        System.out.printf("%-5s %-25s %-10s %-10s%n",
                "ID", "NAME", "YEAR", "ARTIST");

        for (Album album : albums) {

            System.out.printf("%-5d %-25s %-10d %-10d%n",
                    album.getId(),
                    album.getName(),
                    album.getYear(),
                    album.getArtistId());
        }
    }

    // ================= VIEW ARCHIVED ALBUMS =================
    private void displayArchivedAlbums() {

        List<Album> albums = albumController.getArchivedAlbums();

        if (albums.isEmpty()) {
            System.out.println("No archived albums found.");
            return;
        }

        System.out.println("\n===== ARCHIVED ALBUMS =====");
        System.out.printf("%-5s %-25s %-10s %-10s%n",
                "ID", "NAME", "YEAR", "ARTIST");

        for (Album album : albums) {

            System.out.printf("%-5d %-25s %-10d %-10d%n",
                    album.getId(),
                    album.getName(),
                    album.getYear(),
                    album.getArtistId());
        }
    }

    // ================= RESTORE ALBUM =================
    private void restoreAlbum() {

        System.out.print("Enter Album ID to Restore: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        if (albumController.restoreAlbum(id)) {
            System.out.println("Album restored successfully!");
        } else {
            System.out.println("Failed to restore album.");
        }
    }
}