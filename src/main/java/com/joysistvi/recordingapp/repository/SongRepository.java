package com.joysistvi.recordingapp.repository;


// Contract

import com.joysistvi.recordingapp.model.Song;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;


// Repository: Handles data access logic
// Calls Model
public interface SongRepository {
    public List<Song> getAllSongsWithAlbum();

    public boolean createSong(Song song);

    public boolean updateSong(String title, String length, String genre, int id);

    public boolean deleteSong(int id);

    public boolean archiveSong(int id);

    public boolean restoreSong(int id);

    public List<Song> searchSong(String keyword);

    public void readSongsWithAlbum();
}