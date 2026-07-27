
package com.joysistvi.recordingapp.view;

import com.joysistvi.recordingapp.config.DbConnection;
import com.joysistvi.recordingapp.controller.SongController;
import com.joysistvi.recordingapp.repository.SongRepository;
import com.joysistvi.recordingapp.repository.SongRepositoryImpl;
import com.joysistvi.recordingapp.service.SongService;
import com.joysistvi.recordingapp.service.SongServiceImpl;

import java.util.Scanner;

import java.util.Scanner;

public class Dashboard {

    private final Scanner scanner = new Scanner(System.in);

    private final SongView songView;
    private final ArtistView artistView;

    public Dashboard(SongView songView, ArtistView artistView) {
        this.songView = songView;
        this.artistView = artistView;
    }

    public void mainMenu() {

        int choice;

        do {
            System.out.println("\n===== Recording Studio App =====");
            System.out.println("1. Manage Songs");
            System.out.println("2. Manage Albums");
            System.out.println("3. Manage Artists");
            System.out.println("0. Exit");
            System.out.print("Enter choice: ");

            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    songView.showMenu();
                    break;

                case 2:
                    System.out.println("Album module is under development.");
                    break;

                case 3:
                    artistView.showMenu();
                    break;

                case 0:
                    System.out.println("Exiting application...");
                    break;

                default:
                    System.out.println("Invalid choice.");
            }

        } while (choice != 0);
    }
}

//        song.dashboard();



/*
    why MVC is useful
    separation of concerns -> each part has a clear responsibility

    maintainability -> easier to update one part without breaking others

    testability -> you can test service logic separately from UI

    flexibility -> swap out the database or UI without rewriting the whole app
 */
