package com.joysistvi.recordingapp.dao;

import java.util.Scanner;

import com.joysistvi.recordingapp.config.DbConnection;


// Repository
import com.joysistvi.recordingapp.repository.*;


// Service
import com.joysistvi.recordingapp.service.*;


// Controller
import com.joysistvi.recordingapp.controller.*;


// View
import com.joysistvi.recordingapp.view.*;



public class Main {


    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);



        /*
         ==================================================
                 DATABASE CONNECTION

         DbConnection:
         - kumokonekta sa MySQL Database

         Database:
              recording_app_db


         Example Tables:

              admins
              users
              artists
              albums
              songs
              playlists


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

         ==================================================
        */


        DbConnection dbConnection =
                new DbConnection();





        /*
         ==================================================
                 REPOSITORY
         ==================================================
        */


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






        /*
         ==================================================
                 SERVICE
         ==================================================
        */


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







        /*
         ==================================================
                 CONTROLLER
         ==================================================
        */


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







        /*
         ==================================================
                 VIEW
         ==================================================
        */


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







        /*
         ==================================================
                 DASHBOARD
         ==================================================
        */


        UserDashboard userDashboard =
                new UserDashboard(
                        artistController,
                        albumController,
                        songController,
                        playlistController,
                        artistView,
                        albumView,
                        songView
                );


        AdminDashboard adminDashboard =
                new AdminDashboard(
                        songView,
                        artistView,
                        albumView,
                        userDashboard,
                        adminView
                );







        /*
         ==================================================
                 MAIN MENU LOOP
         ==================================================
        */


        boolean running = true;



        while(running){



            System.out.println("\n=================================");
            System.out.println("     RECORDING STUDIO SYSTEM");
            System.out.println("=================================");


            System.out.println("1. Create Admin Account");
            System.out.println("2. Admin Login");

            System.out.println("3. Create User Account");
            System.out.println("4. User Login");

            System.out.println("0. Exit");



            System.out.print("Enter Choice: ");



            int choice = scanner.nextInt();
            scanner.nextLine();




            switch(choice){



                /*
                 =====================================
                 CREATE ADMIN
                 =====================================
                */


                case 1:


                    /*
                      Database Flow:

                      AdminView
                          |
                      AdminController
                          |
                      AdminService
                          |
                      AdminRepository
                          |
                      INSERT INTO admins

                    */


                    adminView.createAdmin();


                    break;






                /*
                 =====================================
                 ADMIN LOGIN
                 =====================================
                */


                case 2:



                    if(adminView.login()){


                        System.out.println(
                                "Admin Login Successful!"
                        );


                        adminDashboard.mainMenu();


                    }
                    else{


                        System.out.println(
                                "Invalid Admin Account!"
                        );


                    }


                    break;







                /*
                 =====================================
                 CREATE USER
                 =====================================
                */


                case 3:



                    /*
                      Database Flow:

                      UserView
                          |
                      UserController
                          |
                      UserService
                          |
                      UserRepository
                          |
                      INSERT INTO users

                    */


                    userView.registerUser();


                    break;







                /*
                 =====================================
                 USER LOGIN
                 =====================================
                */


                case 4:



                    userView.loginUser();


                    userDashboard.showMenu();


                    break;








                /*
                 =====================================
                 EXIT
                 =====================================
                */


                case 0:



                    System.out.println(
                            "Thank you for using Recording Studio System!"
                    );


                    running = false;


                    break;






                default:


                    System.out.println(
                            "Invalid Choice!"
                    );



            }



        }



        scanner.close();


    }

}