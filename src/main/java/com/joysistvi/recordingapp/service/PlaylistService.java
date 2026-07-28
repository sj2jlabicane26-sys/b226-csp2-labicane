package com.joysistvi.recordingapp.service;

import com.joysistvi.recordingapp.model.Playlist;

import java.util.List;

public interface PlaylistService {

    boolean createPlaylist(Playlist playlist);

    List<Playlist> getAllPlaylists();

    Playlist getPlaylistById(int id);

    boolean updatePlaylist(Playlist playlist);

    boolean archivePlaylist(int id);

    boolean restorePlaylist(int id);

    boolean deletePlaylist(int id);

    List<Playlist> getArchivedPlaylists();
}