package com.joysistvi.recordingapp.view;

import com.joysistvi.recordingapp.controller.AlbumController;
import com.joysistvi.recordingapp.controller.ArtistController;
import com.joysistvi.recordingapp.controller.PlaylistController;
import com.joysistvi.recordingapp.controller.SongController;
import com.joysistvi.recordingapp.model.Playlist;
import com.joysistvi.recordingapp.model.Song;

import java.util.List;
import java.util.Scanner;

public class UserDashboard {

    private final ArtistController artistController;
    private final AlbumController albumController;
    private final SongController songController;
    private final PlaylistController playlistController;
    private final ArtistView artistView;
    private final AlbumView albumView;
    private final SongView songView;


    private final Scanner scanner = new Scanner(System.in);


    public UserDashboard(
            ArtistController artistController,
            AlbumController albumController,
            SongController songController,
            PlaylistController playlistController,
            ArtistView artistView,
            AlbumView albumView,
            SongView songView) {


        this.artistController = artistController;
        this.albumController = albumController;
        this.songController = songController;
        this.playlistController = playlistController;

        this.artistView = artistView;
        this.albumView = albumView;
        this.songView = songView;

    }

    public void showMenu() {

        int choice;

        do {

            System.out.println("\n========== USER DASHBOARD ==========");
            System.out.println("1. Browse Artists");
            System.out.println("2. Browse Albums");
            System.out.println("3. Browse Songs");
            System.out.println("4. Search Song");
            System.out.println("5. Create Playlist");
            System.out.println("6. View Playlists");
            System.out.println("7. Delete Playlist");
            System.out.println("8. Add Song to Playlist");
            System.out.println("9. Remove Song from Playlist");
            System.out.println("0. Logout");
            System.out.print("Enter Choice: ");

            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {

                case 1:
                  songView.viewSongs();


                    break;

                case 2:
                    albumController.getAllAlbums();
                    break;

                case 3:
                    songController.listSongs();
                    break;

                case 4:
                    searchSong();
                    break;

                case 5:
                    createPlaylist();
                    break;

                case 6:
                    viewPlaylists();
                    break;

                case 7:
                    deletePlaylist();
                    break;

                case 8:
                    addSongToPlaylist();
                    break;

                case 9:
                    removeSongFromPlaylist();
                    break;

                case 0:
                    System.out.println("Logging out...");
                    break;

                default:
                    System.out.println("Invalid Choice!");

            }

        } while (choice != 0);

    }

    private void searchSong() {

        System.out.print("Enter song title: ");
        String keyword = scanner.nextLine();

        List<Song> songs = songController.searchSong(keyword);

        if (songs.isEmpty()) {

            System.out.println("No songs found.");

        } else {

            for (Song song : songs) {

                System.out.println(song);

            }

        }

    }

    private void createPlaylist() {

        Playlist playlist = new Playlist();

        System.out.print("Playlist ID: ");
        playlist.setId(scanner.nextInt());
        scanner.nextLine();

        System.out.print("Date Created: ");
        playlist.setDateCreated(scanner.nextLine());

        System.out.print("Song ID: ");
        playlist.setSongsId(scanner.nextInt());
        scanner.nextLine();

        if (playlistController.createPlaylist(playlist)) {

            System.out.println("Playlist created successfully.");

        } else {

            System.out.println("Failed to create playlist.");

        }

    }

    private void viewPlaylists() {

        List<Playlist> playlists = playlistController.getAllPlaylists();

        for (Playlist playlist : playlists) {

            System.out.println(playlist);

        }

    }

    private void deletePlaylist() {

        System.out.print("Playlist ID: ");

        int id = scanner.nextInt();
        scanner.nextLine();

        if (playlistController.deletePlaylist(id)) {

            System.out.println("Playlist deleted.");

        } else {

            System.out.println("Delete failed.");

        }

    }

    private void addSongToPlaylist() {

        System.out.println("Feature to be implemented.");

    }

    private void removeSongFromPlaylist() {

        System.out.println("Feature to be implemented.");

    }

}