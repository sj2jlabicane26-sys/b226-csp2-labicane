package com.joysistvi.recordingapp.dao;

import com.joysistvi.recordingapp.config.DbConnection;
import com.joysistvi.recordingapp.controller.*;
import com.joysistvi.recordingapp.repository.*;
import com.joysistvi.recordingapp.service.*;
import com.joysistvi.recordingapp.view.*;

public class Main {

    public static void main(String[] args) {

        // Database Connection
        DbConnection dbConnection = new DbConnection();

        //  SONG
        SongRepository songRepository = new SongRepositoryImpl(dbConnection);
        SongService songService = new SongServiceImpl(songRepository);
        SongController songController = new SongController(songService);
        SongView songView = new SongView(songController);

        //  ARTIST
        ArtistRepository artistRepository = new ArtistRepositoryImpl(dbConnection);
        ArtistService artistService = new ArtistServiceImpl(artistRepository);
        ArtistController artistController = new ArtistController(artistService);
        ArtistView artistView = new ArtistView(artistController);

        // ALBUM
        AlbumRepository albumRepository = new AlbumRepositoryImpl(dbConnection);
        AlbumService albumService = new AlbumServiceImpl(albumRepository);
        AlbumController albumController = new AlbumController(albumService);
        AlbumView albumView = new AlbumView(albumController);


        //  PLAYLIST
        PlaylistRepository playlistRepository = new PlaylistRepositoryImpl(dbConnection);
        PlaylistService playlistService = new PlaylistServiceImpl(playlistRepository);
        PlaylistController playlistController = new PlaylistController(playlistService);
        PlaylistView playlistView = new PlaylistView(playlistController);

        //  USER

        UserRepository userRepository = new UserRepositoryImpl(dbConnection);

        UserService userService = new UserServiceImpl(userRepository);

        UserController userController = new UserController(userService);

        UserView userView = new UserView(userController);

        //  DASHBOARD
        Dashboard dashboard = new Dashboard(songView, artistView,albumView, userView);
        dashboard.mainMenu();
    }
}