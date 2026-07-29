package com.joysistvi.recordingapp.view;

import com.joysistvi.recordingapp.controller.SongController;
import com.joysistvi.recordingapp.model.Song;

import java.util.List;
import java.util.Scanner;

public class UserDashboard {

    private final SongController songController;
    private final ArtistView artistView;
    private final AlbumView albumView;
    private final SongView songView;
    private final PlaylistView playlistView;

    private final Scanner scanner = new Scanner(System.in);

    public UserDashboard(
            SongController songController,
            ArtistView artistView,
            AlbumView albumView,
            SongView songView,
            PlaylistView playlistView) {

        this.songController = songController;
        this.artistView = artistView;
        this.albumView = albumView;
        this.songView = songView;
        this.playlistView = playlistView;
    }

    public void showMenu() {

        int choice;

        do {

            System.out.println("\n========== USER DASHBOARD ==========");
            System.out.println("1. Browse Artists");
            System.out.println("2. Browse Albums");
            System.out.println("3. Browse Songs");
            System.out.println("4. Search Song");
            System.out.println("5. Playlist Menu");
            System.out.println("0. Logout");
            System.out.print("Enter Choice: ");

            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {

                case 1:
                    artistView.viewArtist();
                    break;

                case 2:
                    albumView.viewAlbums();
                    break;

                case 3:
                    songView.viewSongs();
                    break;

                case 4:
                    searchSong();
                    break;

                case 5:
                    playlistView.start();
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

        System.out.print("Enter Song Title: ");
        String keyword = scanner.nextLine();

        List<Song> songs = songController.searchSong(keyword);

        if (songs.isEmpty()) {

            System.out.println("No songs found.");

        } else {

            System.out.println("\n========== SEARCH RESULT ==========");

            for (Song song : songs) {
                System.out.println(song);
            }
        }
    }
}