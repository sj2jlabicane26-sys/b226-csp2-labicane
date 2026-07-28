package com.joysistvi.recordingapp.view;

import com.joysistvi.recordingapp.controller.ArtistController;
import com.joysistvi.recordingapp.model.Artist;

import java.util.List;
import java.util.Scanner;

public class ArtistView {

    private final ArtistController artistController;
    private final Scanner scanner;

    public ArtistView(ArtistController artistController) {
        this.artistController = artistController;
        this.scanner = new Scanner(System.in);
    }

    public void showMenu() {

        int choice;

        do {
            System.out.println("\n===== ARTIST MENU =====");
            System.out.println("1. Add Artist");
            System.out.println("2. View All Artists");
            System.out.println("3. Update Artist");
            System.out.println("4. Archive Artist");
            System.out.println("5. Search Artist");
            System.out.println("6. View Archived Artists");
            System.out.println("7. Restore Artist");
            System.out.println("0. Back");
            System.out.print("Enter Choice: ");

            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {

                case 1:
                    addArtist();
                    break;

                case 2:
                    displayArtists();
                    break;

                case 3:
                    updateArtist();
                    break;

                case 4:
                    archiveArtist();
                    break;

                case 5:
                    searchArtist();
                    break;

                case 6:
                    displayArchivedArtists();
                    break;

                case 7:
                    restoreArtist();
                    break;

                case 0:
                    System.out.println("Returning to Dashboard...");
                    break;

                default:
                    System.out.println("Invalid Choice!");
            }

        } while (choice != 0);
    }

    // ADD ARTIST
    private void addArtist() {

        System.out.print("Enter Artist Name: ");
        String name = scanner.nextLine();

        if (artistController.addArtist(name)) {
            System.out.println("Artist added successfully!");
        } else {
            System.out.println("Failed to add artist.");
        }
    }

    // VIEW ALL ARTISTS
    private void displayArtists() {

        List<Artist> artists = artistController.getAllArtists();

        if (artists.isEmpty()) {
            System.out.println("No artists found.");
            return;
        }

        System.out.println("\n===== ARTIST LIST =====");
        System.out.printf("%-5s %-30s%n", "ID", "NAME");

        for (Artist artist : artists) {
            System.out.printf("%-5d %-30s%n",
                    artist.getId(),
                    artist.getName());
        }
    }

    // UPDATE ARTIST
    private void updateArtist() {

        System.out.print("Enter Artist ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter New Artist Name: ");
        String newName = scanner.nextLine();

        if (artistController.updateArtist(id, newName)) {
            System.out.println("Artist updated successfully!");
        } else {
            System.out.println("Failed to update artist.");
        }
    }

    // ARCHIVE ARTIST
    private void archiveArtist() {

        System.out.print("Enter Artist ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        if (artistController.archiveArtist(id)) {
            System.out.println("Artist archived successfully!");
        } else {
            System.out.println("Failed to archive artist.");
        }
    }

    // SEARCH ARTIST
    private void searchArtist() {

        System.out.print("Enter keyword: ");
        String keyword = scanner.nextLine();

        List<Artist> artists = artistController.searchArtist(keyword);

        if (artists.isEmpty()) {
            System.out.println("No matching artist found.");
            return;
        }

        System.out.println("\n===== SEARCH RESULT =====");
        System.out.printf("%-5s %-30s%n", "ID", "NAME");

        for (Artist artist : artists) {
            System.out.printf("%-5d %-30s%n",
                    artist.getId(),
                    artist.getName());
        }
    }

    // VIEW ARCHIVED ARTISTS
    private void displayArchivedArtists() {

        List<Artist> artists = artistController.getArchivedArtists();

        if (artists.isEmpty()) {
            System.out.println("No archived artists found.");
            return;
        }

        System.out.println("\n===== ARCHIVED ARTISTS =====");
        System.out.printf("%-5s %-30s%n", "ID", "NAME");

        for (Artist artist : artists) {
            System.out.printf("%-5d %-30s%n",
                    artist.getId(),
                    artist.getName());
        }
    }

    // RESTORE ARTIST
    private void restoreArtist() {

        System.out.print("Enter Artist ID to Restore: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        if (artistController.restoreArtist(id)) {
            System.out.println("Artist restored successfully!");
        } else {
            System.out.println("Failed to restore artist.");
        }
    }
}