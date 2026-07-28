package com.joysistvi.recordingapp.controller;

import com.joysistvi.recordingapp.model.Artist;
import com.joysistvi.recordingapp.service.ArtistService;

import java.util.List;

public class ArtistController {

    private final ArtistService artistService;

    // Constructor Injection
    public ArtistController(ArtistService artistService) {
        this.artistService = artistService;
    }

    // Create Artist
    public boolean addArtist(String name) {
        Artist artist = new Artist(name);
        return artistService.addArtist(artist);
    }

    // Get All Artists
    public List<Artist> getAllArtists() {
        return artistService.getAllArtists();
    }

    // Get Artist by ID
    public Artist getArtistById(int id) {
        return artistService.getArtistById(id);
    }

    // Update Artist
    public boolean updateArtist(int id, String newName) {
        return artistService.updateArtist(id, newName);
    }

    // Delete Artist
    public boolean deleteArtist(int id) {
        return artistService.deleteArtist(id);
    }

    // Search Artist
    public List<Artist> searchArtist(String keyword) {
        return artistService.searchArtist(keyword);
    }
    public boolean archiveArtist(int id) {
        return artistService.archiveArtist(id);
    }

    public boolean restoreArtist(int id) {
        return artistService.restoreArtist(id);
    }

    public List<Artist> getArchivedArtists() {
        return artistService.getArchivedArtists();
    }
}