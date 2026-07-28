package com.joysistvi.recordingapp.service;

import com.joysistvi.recordingapp.model.Album;
import com.joysistvi.recordingapp.repository.AlbumRepository;

import java.time.Year;
import java.util.List;

public class AlbumServiceImpl implements AlbumService {

    private final AlbumRepository albumRepository;

    // Constructor Injection
    public AlbumServiceImpl(AlbumRepository albumRepository) {
        this.albumRepository = albumRepository;
    }

    @Override
    public boolean addAlbum(Album album) {

        if (album == null) {
            System.out.println("Album cannot be null.");
            return false;
        }

        if (album.getName() == null || album.getName().trim().isEmpty()) {
            System.out.println("Album name cannot be empty.");
            return false;
        }

        if (album.getName().trim().length() < 2) {
            System.out.println("Album name must be at least 2 characters.");
            return false;
        }

        if (!album.getName().matches("[A-Za-z0-9 .,'-]+")) {
            System.out.println("Album name contains invalid characters.");
            return false;
        }

        int currentYear = Year.now().getValue();

        if (album.getYear() < 1900 || album.getYear() > currentYear) {
            System.out.println("Invalid album year.");
            return false;
        }

        return albumRepository.createAlbum(album);
    }

    @Override
    public List<Album> getAllAlbums() {
        return albumRepository.getAllAlbums();
    }

    @Override
    public Album getAlbumById(int id) {

        if (id <= 0) {
            System.out.println("Invalid Album ID.");
            return null;
        }

        return albumRepository.getAlbumById(id);
    }

    @Override
    public boolean updateAlbum(int id, String newName, int newYear) {

        if (id <= 0) {
            System.out.println("Invalid Album ID.");
            return false;
        }

        if (newName == null || newName.trim().isEmpty()) {
            System.out.println("Album name cannot be empty.");
            return false;
        }

        if (newName.trim().length() < 2) {
            System.out.println("Album name must be at least 2 characters.");
            return false;
        }

        if (!newName.matches("[A-Za-z0-9 .,'-]+")) {
            System.out.println("Album name contains invalid characters.");
            return false;
        }

        int currentYear = Year.now().getValue();

        if (newYear < 1900 || newYear > currentYear) {
            System.out.println("Invalid album year.");
            return false;
        }

        return albumRepository.updateAlbum(id, newName, newYear);
    }

    @Override
    public boolean deleteAlbum(int id) {

        if (id <= 0) {
            System.out.println("Invalid Album ID.");
            return false;
        }

        return albumRepository.deleteAlbum(id);
    }

    @Override
    public List<Album> searchAlbum(String keyword) {

        if (keyword == null || keyword.trim().isEmpty()) {
            System.out.println("Search keyword cannot be empty.");
            return List.of();
        }

        return albumRepository.searchAlbum(keyword.trim());
    }

    @Override
    public boolean archiveAlbum(int id) {

        if (id <= 0) {
            System.out.println("Invalid Album ID.");
            return false;
        }

        return albumRepository.archiveAlbum(id);
    }

    @Override
    public boolean restoreAlbum(int id) {

        if (id <= 0) {
            System.out.println("Invalid Album ID.");
            return false;
        }

        return albumRepository.restoreAlbum(id);
    }

    @Override
    public List<Album> getArchivedAlbums() {
        return albumRepository.getArchivedAlbums();
    }
}