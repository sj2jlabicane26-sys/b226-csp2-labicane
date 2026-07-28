package com.joysistvi.recordingapp.controller;

import com.joysistvi.recordingapp.model.Album;
import com.joysistvi.recordingapp.service.AlbumService;

import java.util.List;

public class AlbumController {

    private final AlbumService albumService;

    // Constructor Injection
    public AlbumController(AlbumService albumService) {
        this.albumService = albumService;
    }

    // Create Album
    public boolean addAlbum(String name, int year, int artistId) {

        Album album = new Album();
        album.setName(name);
        album.setYear(year);
        album.setArtistId(artistId);

        return albumService.addAlbum(album);
    }

    // Read All Albums
    public List<Album> getAllAlbums() {
        return albumService.getAllAlbums();
    }

    // Read Album by ID
    public Album getAlbumById(int id) {
        return albumService.getAlbumById(id);
    }

    // Update Album
    public boolean updateAlbum(int id, String newName, int newYear) {
        return albumService.updateAlbum(id, newName, newYear);
    }

    // Delete Album
    public boolean deleteAlbum(int id) {
        return albumService.deleteAlbum(id);
    }

    // Search Album
    public List<Album> searchAlbum(String keyword) {
        return albumService.searchAlbum(keyword);
    }

    // Archive Album
    public boolean archiveAlbum(int id) {
        return albumService.archiveAlbum(id);
    }

    // Restore Album
    public boolean restoreAlbum(int id) {
        return albumService.restoreAlbum(id);
    }

    // View Archived Albums
    public List<Album> getArchivedAlbums() {
        return albumService.getArchivedAlbums();
    }
}