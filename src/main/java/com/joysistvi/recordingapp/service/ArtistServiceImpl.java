package com.joysistvi.recordingapp.service;

import com.joysistvi.recordingapp.model.Artist;
import com.joysistvi.recordingapp.repository.ArtistRepository;

import java.util.List;

public class ArtistServiceImpl implements ArtistService {

    private final ArtistRepository artistRepository;

    // Constructor Injection
    public ArtistServiceImpl(ArtistRepository artistRepository) {
        this.artistRepository = artistRepository;
    }

    @Override
    public boolean addArtist(Artist artist) {

        if (artist == null) {
            System.out.println("Artist cannot be null.");
            return false;
        }

        if (artist.getName() == null || artist.getName().trim().isEmpty()) {
            System.out.println("Artist name cannot be empty.");
            return false;
        }

        if (artist.getName().trim().length() < 3) {
            System.out.println("Artist name must be at least 3 characters.");
            return false;
        }

        // Letters, spaces, apostrophe ('), hyphen (-), and period (.)
        if (!artist.getName().matches("[A-Za-z .'-]+")) {
            System.out.println("Artist name contains invalid characters.");
            return false;
        }

        return artistRepository.createArtist(artist);
    }

    @Override
    public List<Artist> getAllArtists() {
        return artistRepository.getAllArtists();
    }

    @Override
    public Artist getArtistById(int id) {

        if (id <= 0) {
            System.out.println("Invalid Artist ID.");
            return null;
        }

        return artistRepository.getArtistById(id);
    }

    @Override
    public boolean updateArtist(int id, String newName) {

        if (id <= 0) {
            System.out.println("Invalid Artist ID.");
            return false;
        }

        if (newName == null || newName.trim().isEmpty()) {
            System.out.println("Artist name cannot be empty.");
            return false;
        }

        if (newName.trim().length() < 3) {
            System.out.println("Artist name must be at least 3 characters.");
            return false;
        }

        if (!newName.matches("[A-Za-z .'-]+")) {
            System.out.println("Artist name contains invalid characters.");
            return false;
        }

        return artistRepository.updateArtist(id, newName);
    }

    @Override
    public boolean deleteArtist(int id) {

        if (id <= 0) {
            System.out.println("Invalid Artist ID.");
            return false;
        }

        return artistRepository.deleteArtist(id);
    }

    @Override
    public List<Artist> searchArtist(String keyword) {

        if (keyword == null || keyword.trim().isEmpty()) {
            System.out.println("Search keyword cannot be empty.");
            return List.of();
        }

        return artistRepository.searchArtist(keyword.trim());
    }
    @Override
    public boolean archiveArtist(int id) {

        if (id <= 0) {
            System.out.println("Invalid Artist ID.");
            return false;
        }

        return artistRepository.archiveArtist(id);
    }

    @Override
    public boolean restoreArtist(int id) {

        if (id <= 0) {
            System.out.println("Invalid Artist ID.");
            return false;
        }

        return artistRepository.restoreArtist(id);
    }

    @Override
    public List<Artist> getArchivedArtists() {
        return artistRepository.getArchivedArtists();
    }
}