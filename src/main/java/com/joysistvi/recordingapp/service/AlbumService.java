package com.joysistvi.recordingapp.service;

import com.joysistvi.recordingapp.model.Album;

import java.util.List;

public interface AlbumService {

    // Create
    boolean addAlbum(Album album);

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

    // View Archived
    List<Album> getArchivedAlbums();
}