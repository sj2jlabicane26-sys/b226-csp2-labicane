package com.joysistvi.recordingapp.controller;

import com.joysistvi.recordingapp.model.Playlist;
import com.joysistvi.recordingapp.service.PlaylistService;

import java.util.List;

public class PlaylistController {

    private final PlaylistService playlistService;

    // Constructor Injection
    public PlaylistController(PlaylistService playlistService) {
        this.playlistService = playlistService;
    }

    // Create Playlist
    public boolean createPlaylist(Playlist playlist) {
        return playlistService.createPlaylist(playlist);
    }

    // Get All Playlists
    public List<Playlist> getAllPlaylists() {
        return playlistService.getAllPlaylists();
    }

    // Get Playlist By ID
    public Playlist getPlaylistById(int id) {
        return playlistService.getPlaylistById(id);
    }

    // Update Playlist
    public boolean updatePlaylist(Playlist playlist) {
        return playlistService.updatePlaylist(playlist);
    }

    // Archive Playlist
    public boolean archivePlaylist(int id) {
        return playlistService.archivePlaylist(id);
    }

    // Restore Playlist
    public boolean restorePlaylist(int id) {
        return playlistService.restorePlaylist(id);
    }

    // Delete Playlist
    public boolean deletePlaylist(int id) {
        return playlistService.deletePlaylist(id);
    }

    // View Archived Playlists
    public List<Playlist> getArchivedPlaylists() {
        return playlistService.getArchivedPlaylists();
    }
}