package com.joysistvi.recordingapp.service;

import com.joysistvi.recordingapp.model.Song;
import com.joysistvi.recordingapp.repository.SongRepository;

import java.util.List;

public class SongServiceImpl implements SongService {

    private final SongRepository songRepo;

    // Constructor Injection
    public SongServiceImpl(SongRepository songRepo) {
        this.songRepo = songRepo;
    }

    @Override
    public boolean addSong(Song song) {
        if (song.getTitle() == null || song.getTitle().isEmpty()) {
            System.out.println("Song title cannot be empty.");
            return false;
        }

        return songRepo.createSong(song);
    }

    @Override
    public List<Song> listSongs() {
        return songRepo.getAllSongsWithAlbum();
    }

    @Override
    public boolean updateSong(int id, String newTitle, String length, String genre) {
        if (newTitle == null || newTitle.isEmpty()) {
            System.out.println("New title cannot be empty.");
            return false;
        }

        return songRepo.updateSong(newTitle, length, genre, id);
    }

    @Override
    public boolean deleteSong(int id) {
        return songRepo.deleteSong(id);
    }

    @Override
    public boolean archiveSong(int id) {
        return songRepo.archiveSong(id);
    }

    @Override
    public boolean restoreSong(int id) {
        return songRepo.restoreSong(id);
    }

    @Override
    public List<Song> searchSong(String keyword) {
        return songRepo.searchSong(keyword);
    }
}