package com.joysistvi.recordingapp.dao;
import com.joysistvi.recordingapp.config.DbConnection;
import com.joysistvi.recordingapp.controller.ArtistController;
import com.joysistvi.recordingapp.controller.SongController;
import com.joysistvi.recordingapp.repository.ArtistRepository;
import com.joysistvi.recordingapp.repository.ArtistRepositoryImpl;
import com.joysistvi.recordingapp.repository.SongRepository;
import com.joysistvi.recordingapp.repository.SongRepositoryImpl;
import com.joysistvi.recordingapp.service.ArtistService;
import com.joysistvi.recordingapp.service.ArtistServiceImpl;
import com.joysistvi.recordingapp.service.SongService;
import com.joysistvi.recordingapp.service.SongServiceImpl;
import com.joysistvi.recordingapp.view.ArtistView;
import com.joysistvi.recordingapp.view.Dashboard;
import com.joysistvi.recordingapp.view.SongView;

public class Main {

    public static void main(String[] args) {

        // Database Connection
        DbConnection dbConnection = new DbConnection();

        // ================= SONG =================
        SongRepository songRepository = new SongRepositoryImpl(dbConnection);
        SongService songService = new SongServiceImpl(songRepository);
        SongController songController = new SongController(songService);
        SongView songView = new SongView(songController);

        // ================= ARTIST =================
        ArtistRepository artistRepository = new ArtistRepositoryImpl(dbConnection);
        ArtistService artistService = new ArtistServiceImpl(artistRepository);
        ArtistController artistController = new ArtistController(artistService);
        ArtistView artistView = new ArtistView(artistController);

        // ================= DASHBOARD =================
        Dashboard dashboard = new Dashboard(songView,artistView);
        dashboard.mainMenu();
    }
}