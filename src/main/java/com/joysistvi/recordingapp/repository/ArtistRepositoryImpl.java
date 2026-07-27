package com.joysistvi.recordingapp.repository;

import com.joysistvi.recordingapp.config.DbConnection;
import com.joysistvi.recordingapp.model.Artist;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ArtistRepositoryImpl implements ArtistRepository {

    private final DbConnection dbConnection;

    public ArtistRepositoryImpl(DbConnection dbConnection) {
        this.dbConnection = dbConnection;
    }

    @Override
    public boolean createArtist(Artist artist) {

        if (artist == null) {
            return false;
        }

        String query = "INSERT INTO artists(name) VALUES(?)";

        try (Connection conn = dbConnection.connect();
             PreparedStatement prep = conn.prepareStatement(query)) {

            prep.setString(1, artist.getName());

            return prep.executeUpdate() > 0;

        } catch (SQLException e) {
            System.out.println("Error inserting artist: " + e.getMessage());
            return false;
        }
    }

    @Override
    public List<Artist> getAllArtists() {

        List<Artist> artists = new ArrayList<>();

        String query = "SELECT * FROM artists WHERE is_archived = 0";

        try (Connection conn = dbConnection.connect();
             PreparedStatement prep = conn.prepareStatement(query);
             ResultSet rs = prep.executeQuery()) {

            while (rs.next()) {

                Artist artist = new Artist();

                artist.setId(rs.getInt("id"));
                artist.setName(rs.getString("name"));

                artists.add(artist);
            }

        } catch (SQLException e) {
            System.out.println("Error retrieving artists: " + e.getMessage());
        }

        return artists;
    }

    @Override
    public Artist getArtistById(int id) {

        String query = "SELECT * FROM artists WHERE id = ?";

        try (Connection conn = dbConnection.connect();
             PreparedStatement prep = conn.prepareStatement(query)) {

            prep.setInt(1, id);

            ResultSet rs = prep.executeQuery();

            if (rs.next()) {

                return new Artist(
                        rs.getInt("id"),
                        rs.getString("name")
                );
            }

        } catch (SQLException e) {
            System.out.println("Error retrieving artist: " + e.getMessage());
        }

        return null;
    }

    @Override
    public boolean updateArtist(int id, String newName) {

        String query = "UPDATE artists SET name = ? WHERE id = ?";

        try (Connection conn = dbConnection.connect();
             PreparedStatement prep = conn.prepareStatement(query)) {

            prep.setString(1, newName);
            prep.setInt(2, id);

            return prep.executeUpdate() > 0;

        } catch (SQLException e) {
            System.out.println("Error updating artist: " + e.getMessage());
            return false;
        }
    }

    @Override
    public boolean deleteArtist(int id) {

        String query = "DELETE FROM artists WHERE id = ?";

        try (Connection conn = dbConnection.connect();
             PreparedStatement prep = conn.prepareStatement(query)) {

            prep.setInt(1, id);

            return prep.executeUpdate() > 0;

        } catch (SQLException e) {
            System.out.println("Error deleting artist: " + e.getMessage());
            return false;
        }
    }



    @Override
    public List<Artist> searchArtist(String keyword) {

        List<Artist> artists = new ArrayList<>();

        String query = "SELECT * FROM artists WHERE name LIKE ? AND is_archived = 0";

        try (Connection conn = dbConnection.connect();
             PreparedStatement prep = conn.prepareStatement(query)) {

            prep.setString(1, "%" + keyword + "%");

            ResultSet rs = prep.executeQuery();

            while (rs.next()) {

                artists.add(new Artist(
                        rs.getInt("id"),
                        rs.getString("name")
                ));
            }

        } catch (SQLException e) {
            System.out.println("Error searching artist: " + e.getMessage());
        }

        return artists;
    }
}