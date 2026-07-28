package com.joysistvi.recordingapp.service;

import com.joysistvi.recordingapp.model.Playlist;
import com.joysistvi.recordingapp.repository.PlaylistRepository;

import java.util.List;

public class PlaylistServiceImpl implements PlaylistService {

    private final PlaylistRepository playlistRepository;

    // Constructor Injection
    public PlaylistServiceImpl(PlaylistRepository playlistRepository) {
        this.playlistRepository = playlistRepository;
    }

    @Override
    public boolean createPlaylist(Playlist playlist) {
        return playlistRepository.createPlaylist(playlist);
    }

    @Override
    public List<Playlist> getAllPlaylists() {
        return playlistRepository.getAllPlaylists();
    }

    @Override
    public Playlist getPlaylistById(int id) {
        return playlistRepository.getPlaylistById(id);
    }

    @Override
    public boolean updatePlaylist(Playlist playlist) {
        return playlistRepository.updatePlaylist(playlist);
    }

    @Override
    public boolean archivePlaylist(int id) {
        return playlistRepository.archivePlaylist(id);
    }

    @Override
    public boolean restorePlaylist(int id) {
        return playlistRepository.restorePlaylist(id);
    }

    @Override
    public boolean deletePlaylist(int id) {
        return playlistRepository.deletePlaylist(id);
    }

    @Override
    public List<Playlist> getArchivedPlaylists() {
        return playlistRepository.getArchivedPlaylists();
    }
}