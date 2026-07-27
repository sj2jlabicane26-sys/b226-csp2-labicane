package com.joysistvi.recordingapp.service;

import com.joysistvi.recordingapp.model.Song;

import java.util.List;

public interface SongService {

    boolean addSong(Song song);

    List<Song> listSongs();

    boolean updateSong(int id, String newTitle, String length, String genre);

    boolean deleteSong(int id);

    boolean archiveSong(int id);

    boolean restoreSong(int id);

    List<Song> searchSong(String keyword);
}