package com.joysistvi.recordingapp.service;

import com.joysistvi.recordingapp.model.Artist;

import java.util.List;

public interface ArtistService {

    boolean addArtist(Artist artist);

    List<Artist> getAllArtists();

    Artist getArtistById(int id);

    boolean updateArtist(int id, String newName);

    boolean deleteArtist(int id);

    List<Artist> searchArtist(String keyword);
}