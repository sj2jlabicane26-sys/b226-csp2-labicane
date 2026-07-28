package com.joysistvi.recordingapp.repository;

import com.joysistvi.recordingapp.model.Album;

import java.util.List;

public interface AlbumRepository {

    // Create
    boolean createAlbum(Album album);

    // Read
    List<Album> getAllAlbums();

    Album getAlbumById(int id);

    // Update
    boolean updateAlbum(int id, String newName, int newYear);

    // Delete
    boolean deleteAlbum(int id);

    // Search
    List<Album> searchAlbum(String keyword);

    // Archive
    boolean archiveAlbum(int id);

    // Restore
    boolean restoreAlbum(int id);

    // View Archived Albums
    List<Album> getArchivedAlbums();
}