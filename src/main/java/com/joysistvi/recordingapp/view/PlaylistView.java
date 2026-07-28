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

        while (true) {

            System.out.println("\n===== PLAYLIST MENU =====");
            System.out.println("1. Create Playlist");
            System.out.println("2. View All Playlists");
            System.out.println("3. Update Playlist");
            System.out.println("4. Archive Playlist");
            System.out.println("5. Restore Playlist");
            System.out.println("6. Delete Playlist");
            System.out.println("7. View Archived Playlists");
            System.out.println("0. Exit");

            System.out.print("Choose: ");
            int choice = scanner.nextInt();
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
                    System.out.println("Thank you!");
                    return;

                default:
                    System.out.println("Invalid Choice!");
            }
        }
    }

    private void createPlaylist() {

        System.out.print("Date Created: ");
        String dateCreated = scanner.nextLine();

        System.out.print("Song ID: ");
        int songId = scanner.nextInt();
        scanner.nextLine();

        Playlist playlist = new Playlist();
        playlist.setDateCreated(dateCreated);
        playlist.setSongsId(songId);

        if (playlistController.createPlaylist(playlist)) {
            System.out.println("Playlist Added Successfully!");
        } else {
            System.out.println("Failed to Add Playlist!");
        }
    }

    private void viewAllPlaylists() {

        List<Playlist> playlists = playlistController.getAllPlaylists();

        if (playlists.isEmpty()) {
            System.out.println("No playlists found.");
            return;
        }

        for (Playlist playlist : playlists) {

            System.out.println("----------------------------");
            System.out.println("ID: " + playlist.getId());
            System.out.println("Date Created: " + playlist.getDateCreated());
            System.out.println("Song ID: " + playlist.getSongsId());
        }
    }

    private void updatePlaylist() {

        System.out.print("Playlist ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        System.out.print("New Date Created: ");
        String date = scanner.nextLine();

        System.out.print("New Song ID: ");
        int songId = scanner.nextInt();
        scanner.nextLine();

        Playlist playlist = new Playlist();
        playlist.setId(id);
        playlist.setDateCreated(date);
        playlist.setSongsId(songId);

        if (playlistController.updatePlaylist(playlist)) {
            System.out.println("Playlist Updated Successfully!");
        } else {
            System.out.println("Update Failed!");
        }
    }

    private void archivePlaylist() {

        System.out.print("Playlist ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        if (playlistController.archivePlaylist(id)) {
            System.out.println("Playlist Archived Successfully!");
        } else {
            System.out.println("Archive Failed!");
        }
    }

    private void restorePlaylist() {

        System.out.print("Playlist ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        if (playlistController.restorePlaylist(id)) {
            System.out.println("Playlist Restored Successfully!");
        } else {
            System.out.println("Restore Failed!");
        }
    }

    private void deletePlaylist() {

        System.out.print("Playlist ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        if (playlistController.deletePlaylist(id)) {
            System.out.println("Playlist Deleted Successfully!");
        } else {
            System.out.println("Delete Failed!");
        }
    }

    private void viewArchivedPlaylists() {

        List<Playlist> playlists = playlistController.getArchivedPlaylists();

        if (playlists.isEmpty()) {
            System.out.println("No Archived Playlists.");
            return;
        }

        for (Playlist playlist : playlists) {

            System.out.println("----------------------------");
            System.out.println("ID: " + playlist.getId());
            System.out.println("Date Created: " + playlist.getDateCreated());
            System.out.println("Song ID: " + playlist.getSongsId());
        }
    }
}