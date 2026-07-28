package com.joysistvi.recordingapp.service;

import com.joysistvi.recordingapp.model.Artist;

import java.util.List;

public interface ArtistService {

    // Create
    boolean addArtist(Artist artist);

    // Read
    List<Artist> getAllArtists();

    Artist getArtistById(int id);

    // Update
    boolean updateArtist(int id, String newName);

    // Delete
    boolean deleteArtist(int id);

    // Search
    List<Artist> searchArtist(String keyword);

    // Archive
    boolean archiveArtist(int id);

    // Restore
    boolean restoreArtist(int id);

    // View Archived
    List<Artist> getArchivedArtists();
}