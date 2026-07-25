package com.joysistvi.recordingapp.service;

import com.joysistvi.recordingapp.model.Song;
import com.joysistvi.recordingapp.repository.SongRepository;

import java.util.List;

public class SongService {

    private final SongRepository songRepo;

    // Constructor injection
    public SongService(SongRepository songRepo) {
        this.songRepo = songRepo;
    }

    public boolean addSong(Song song) {
        if (song.getTitle() == null || song.getTitle().isEmpty() ) {
            System.out.println("Song title cannot be empty");
            return false;
        }

        return songRepo.createSong(song);
    }

    public List<Song> listSongs() {
        return songRepo.getAllSongs();
    }

//    public boolean updateSong(int id, String newTitle, String length, String genre) {
//        if (newTitle == null || newTitle.isEmpty()) {
//            System.out.println("New title cannot be empty.");
//            return false;
//        }
//        return songRepo.updateSongTitle(id, newTitle);
//    }

    public boolean deleteSong(){
        return true;
    }

}
