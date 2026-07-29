package com.joysistvi.recordingapp.dao;

import java.util.Scanner;

import com.joysistvi.recordingapp.config.DbConnection;

import com.joysistvi.recordingapp.repository.*;

import com.joysistvi.recordingapp.service.*;

import com.joysistvi.recordingapp.controller.*;

import com.joysistvi.recordingapp.view.*;



public class Main {


    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);



       /*

         Flow:

         View
          |
         Controller
          |
         Service
          |
         Repository
          |
         DbConnection
          |
         MySQL Database


        */

        // DATABASE CONNECTION
        DbConnection dbConnection =
                new DbConnection();






               //  REPOSITORY



        AdminRepository adminRepository =
                new AdminRepositoryImpl(dbConnection);


        UserRepository userRepository =
                new UserRepositoryImpl(dbConnection);


        ArtistRepository artistRepository =
                new ArtistRepositoryImpl(dbConnection);


        AlbumRepository albumRepository =
                new AlbumRepositoryImpl(dbConnection);


        SongRepository songRepository =
                new SongRepositoryImpl(dbConnection);


        PlaylistRepository playlistRepository =
                new PlaylistRepositoryImpl(dbConnection);







             //    SERVICE



        AdminService adminService =
                new AdminServiceImpl(adminRepository);


        UserService userService =
                new UserServiceImpl(userRepository);


        ArtistService artistService =
                new ArtistServiceImpl(artistRepository);


        AlbumService albumService =
                new AlbumServiceImpl(albumRepository);


        SongService songService =
                new SongServiceImpl(songRepository);


        PlaylistService playlistService =
                new PlaylistServiceImpl(playlistRepository);








             //    CONTROLLER



        AdminController adminController =
                new AdminController(adminService);


        UserController userController =
                new UserController(userService);


        ArtistController artistController =
                new ArtistController(artistService);


        AlbumController albumController =
                new AlbumController(albumService);


        SongController songController =
                new SongController(songService);


        PlaylistController playlistController =
                new PlaylistController(playlistService);




       //  VIEW



        AdminView adminView =
                new AdminView(adminController);

        UserView userView =
                new UserView(userController);

        SongView songView =
                new SongView(songController);

        ArtistView artistView =
                new ArtistView(artistController);

        AlbumView albumView =
                new AlbumView(albumController);

        PlaylistView playlistView =
                new PlaylistView(playlistController);


       //  DASHBOARD


        UserDashboard userDashboard =
                new UserDashboard(
                        songController,
                        artistView,
                        albumView,
                        songView,
                        playlistView
                );

        AdminDashboard adminDashboard =
                new AdminDashboard(
                        songView,
                        artistView,
                        albumView,
                        userDashboard,
                        adminView,
                        userView
                );



       //  WELCOME VIEW


        WelcomeView welcomeView =
                new WelcomeView(
                        adminView,
                        userView,
                        adminDashboard,
                        userDashboard
                );

        welcomeView.showMenu();

    }
}