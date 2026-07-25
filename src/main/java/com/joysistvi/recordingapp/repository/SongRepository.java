package com.joysistvi.recordingapp.repository;

// Contract

import com.joysistvi.recordingapp.model.Song;

import java.util.List;

public interface SongRepository {
    public List<Song> getAllSongs();
    public boolean createSong(Song song);
    public boolean updateSong(String title, String length, String genre, int id);
    public boolean deleteSong(int id);
}
