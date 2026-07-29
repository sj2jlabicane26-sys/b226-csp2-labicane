package com.joysistvi.recordingapp.view;

import com.joysistvi.recordingapp.controller.PlaylistController;
import com.joysistvi.recordingapp.model.Playlist;

import java.util.List;
import java.util.Scanner;

public class PlaylistView {

    private final PlaylistController playlistController;
    private final Scanner scanner;

    public PlaylistView(PlaylistController playlistController) {
        this.playlistController = playlistController;
        this.scanner = new Scanner(System.in);
    }

    public void start() {

        int choice;

        do {

            System.out.println("\n========== PLAYLIST MENU ==========");
            System.out.println("1. Create Playlist");
            System.out.println("2. View All Playlists");
            System.out.println("3. Update Playlist");
            System.out.println("4. Archive Playlist");
            System.out.println("5. Restore Playlist");
            System.out.println("6. Delete Playlist");
            System.out.println("7. View Archived Playlists");
            System.out.println("0. Back");
            System.out.print("Enter Choice: ");

            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {

                case 1:
                    createPlaylist();
                    break;

                case 2:
                    viewAllPlaylists();
                    break;

                case 3:
                    updatePlaylist();
                    break;

                case 4:
                    archivePlaylist();
                    break;

                case 5:
                    restorePlaylist();
                    break;

                case 6:
                    deletePlaylist();
                    break;

                case 7:
                    viewArchivedPlaylists();
                    break;

                case 0:
                    System.out.println("Returning to User Dashboard...");
                    break;

                default:
                    System.out.println("Invalid Choice!");
            }

        } while (choice != 0);
    }

    // ================= CREATE =================

    private void createPlaylist() {

        Playlist playlist = new Playlist();

        System.out.print("Date Created (yyyy-MM-dd HH:mm:ss): ");
        playlist.setDateCreated(scanner.nextLine());

        System.out.print("Song ID: ");
        playlist.setSongsId(scanner.nextInt());
        scanner.nextLine();

        if (playlistController.createPlaylist(playlist)) {
            System.out.println("Playlist Created Successfully!");
        } else {
            System.out.println("Failed to Create Playlist!");
        }
    }

    // ================= VIEW =================

    private void viewAllPlaylists() {

        List<Playlist> playlists = playlistController.getAllPlaylists();

        if (playlists.isEmpty()) {
            System.out.println("No Playlists Found.");
            return;
        }

        System.out.println("\n========== PLAYLIST LIST ==========");
        System.out.printf("%-5s %-25s %-10s%n",
                "ID", "DATE CREATED", "SONG ID");

        for (Playlist playlist : playlists) {

            System.out.printf("%-5d %-25s %-10d%n",
                    playlist.getId(),
                    playlist.getDateCreated(),
                    playlist.getSongsId());
        }
    }

    // ================= UPDATE =================

    private void updatePlaylist() {

        Playlist playlist = new Playlist();

        System.out.print("Playlist ID: ");
        playlist.setId(scanner.nextInt());
        scanner.nextLine();

        System.out.print("New Date Created (yyyy-MM-dd HH:mm:ss): ");
        playlist.setDateCreated(scanner.nextLine());

        System.out.print("New Song ID: ");
        playlist.setSongsId(scanner.nextInt());
        scanner.nextLine();

        if (playlistController.updatePlaylist(playlist)) {
            System.out.println("Playlist Updated Successfully!");
        } else {
            System.out.println("Failed to Update Playlist!");
        }
    }

    // ================= ARCHIVE =================

    private void archivePlaylist() {

        System.out.print("Playlist ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        if (playlistController.archivePlaylist(id)) {
            System.out.println("Playlist Archived Successfully!");
        } else {
            System.out.println("Failed to Archive Playlist!");
        }
    }

    // ================= RESTORE =================

    private void restorePlaylist() {

        System.out.print("Playlist ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        if (playlistController.restorePlaylist(id)) {
            System.out.println("Playlist Restored Successfully!");
        } else {
            System.out.println("Failed to Restore Playlist!");
        }
    }

    // ================= DELETE =================

    private void deletePlaylist() {

        System.out.print("Playlist ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        if (playlistController.deletePlaylist(id)) {
            System.out.println("Playlist Deleted Successfully!");
        } else {
            System.out.println("Failed to Delete Playlist!");
        }
    }

    // ================= VIEW ARCHIVED =================

    private void viewArchivedPlaylists() {

        List<Playlist> playlists = playlistController.getArchivedPlaylists();

        if (playlists.isEmpty()) {
            System.out.println("No Archived Playlists Found.");
            return;
        }

        System.out.println("\n====== ARCHIVED PLAYLISTS ======");
        System.out.printf("%-5s %-25s %-10s%n",
                "ID", "DATE CREATED", "SONG ID");

        for (Playlist playlist : playlists) {

            System.out.printf("%-5d %-25s %-10d%n",
                    playlist.getId(),
                    playlist.getDateCreated(),
                    playlist.getSongsId());
        }
    }
}