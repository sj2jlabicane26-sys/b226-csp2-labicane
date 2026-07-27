package com.joysistvi.recordingapp.controller;

import com.joysistvi.recordingapp.model.Song;
import com.joysistvi.recordingapp.service.SongService;

import java.util.List;

public class SongController {

    private final SongService songService;

    // Constructor injection
    public SongController(SongService songService) {
        this.songService = songService;
    }

    // Add Song
    public boolean addSong(String title, String length, String genre, int albumId) {
        Song song = new Song(title, length, genre, albumId);
        return songService.addSong(song);
    }

    // View All Songs
    public List<Song> listSongs() {
        return songService.listSongs();
    }

    // Update Song
    public boolean updateSong(int id, String title, String length, String genre) {
        return songService.updateSong(id, title, length, genre);
    }

    // Delete Song
    public boolean deleteSong(int id) {
        return songService.deleteSong(id);
    }

    // Archive Song
    public boolean archiveSong(int id) {
        return songService.archiveSong(id);
    }

    // Restore Song
    public boolean restoreSong(int id) {
        return songService.restoreSong(id);
    }

    // Search Song
    public List<Song> searchSong(String keyword) {
        return songService.searchSong(keyword);
    }
}