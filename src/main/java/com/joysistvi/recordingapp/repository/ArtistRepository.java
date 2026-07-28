package com.joysistvi.recordingapp.repository;

import com.joysistvi.recordingapp.model.Artist;

import java.util.List;

public interface ArtistRepository {

    // Create
    boolean createArtist(Artist artist);

    // Read
    List<Artist> getAllArtists();

    Artist getArtistById(int id);

    // Update
    boolean updateArtist(int id, String newName);

    // Delete
    boolean deleteArtist(int id);

    // Search
    List<Artist> searchArtist(String keyword);
    boolean archiveArtist(int id);

    boolean restoreArtist(int id);

    List<Artist> getArchivedArtists();
}