package com.joysistvi.recordingapp.repository;

import com.joysistvi.recordingapp.config.DbConnection;
import com.joysistvi.recordingapp.model.Album;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AlbumRepositoryImpl implements AlbumRepository {

    private final DbConnection dbConnection;

    public AlbumRepositoryImpl(DbConnection dbConnection) {
        this.dbConnection = dbConnection;
    }

    @Override
    public boolean createAlbum(Album album) {

        if (album == null) {
            return false;
        }

        String query = "INSERT INTO albums(name, year, artist_id) VALUES(?, ?, ?)";

        try (Connection conn = dbConnection.connect();
             PreparedStatement prep = conn.prepareStatement(query)) {

            prep.setString(1, album.getName());
            prep.setInt(2, album.getYear());
            prep.setInt(3, album.getArtistId());

            return prep.executeUpdate() > 0;

        } catch (SQLException e) {
            System.out.println("Error inserting album: " + e.getMessage());
            return false;
        }
    }

    @Override
    public List<Album> getAllAlbums() {

        List<Album> albums = new ArrayList<>();

        String query = "SELECT * FROM albums WHERE is_archived = 0";

        try (Connection conn = dbConnection.connect();
             PreparedStatement prep = conn.prepareStatement(query);
             ResultSet rs = prep.executeQuery()) {

            while (rs.next()) {

                Album album = new Album(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getInt("year"),
                        rs.getInt("artist_id"),
                        rs.getInt("is_archived")
                );

                albums.add(album);
            }

        } catch (SQLException e) {
            System.out.println("Error retrieving albums: " + e.getMessage());
        }

        return albums;
    }

    @Override
    public Album getAlbumById(int id) {

        String query = "SELECT * FROM albums WHERE id = ?";

        try (Connection conn = dbConnection.connect();
             PreparedStatement prep = conn.prepareStatement(query)) {

            prep.setInt(1, id);

            ResultSet rs = prep.executeQuery();

            if (rs.next()) {

                return new Album(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getInt("year"),
                        rs.getInt("artist_id"),
                        rs.getInt("is_archived")
                );
            }

        } catch (SQLException e) {
            System.out.println("Error retrieving album: " + e.getMessage());
        }

        return null;
    }

    @Override
    public boolean updateAlbum(int id, String newName, int newYear) {

        String query = "UPDATE albums SET name = ?, year = ? WHERE id = ?";

        try (Connection conn = dbConnection.connect();
             PreparedStatement prep = conn.prepareStatement(query)) {

            prep.setString(1, newName);
            prep.setInt(2, newYear);
            prep.setInt(3, id);

            return prep.executeUpdate() > 0;

        } catch (SQLException e) {
            System.out.println("Error updating album: " + e.getMessage());
            return false;
        }
    }

    @Override
    public boolean deleteAlbum(int id) {

        String query = "DELETE FROM albums WHERE id = ?";

        try (Connection conn = dbConnection.connect();
             PreparedStatement prep = conn.prepareStatement(query)) {

            prep.setInt(1, id);

            return prep.executeUpdate() > 0;

        } catch (SQLException e) {
            System.out.println("Error deleting album: " + e.getMessage());
            return false;
        }
    }

    @Override
    public List<Album> searchAlbum(String keyword) {

        List<Album> albums = new ArrayList<>();

        String query = "SELECT * FROM albums WHERE name LIKE ? AND is_archived = 0";

        try (Connection conn = dbConnection.connect();
             PreparedStatement prep = conn.prepareStatement(query)) {

            prep.setString(1, "%" + keyword + "%");

            ResultSet rs = prep.executeQuery();

            while (rs.next()) {

                albums.add(new Album(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getInt("year"),
                        rs.getInt("artist_id"),
                        rs.getInt("is_archived")
                ));
            }

        } catch (SQLException e) {
            System.out.println("Error searching album: " + e.getMessage());
        }

        return albums;
    }

    @Override
    public boolean archiveAlbum(int id) {

        String query = "UPDATE albums SET is_archived = 1 WHERE id = ?";

        try (Connection conn = dbConnection.connect();
             PreparedStatement prep = conn.prepareStatement(query)) {

            prep.setInt(1, id);

            return prep.executeUpdate() > 0;

        } catch (SQLException e) {
            System.out.println("Error archiving album: " + e.getMessage());
            return false;
        }
    }

    @Override
    public boolean restoreAlbum(int id) {

        String query = "UPDATE albums SET is_archived = 0 WHERE id = ?";

        try (Connection conn = dbConnection.connect();
             PreparedStatement prep = conn.prepareStatement(query)) {

            prep.setInt(1, id);

            return prep.executeUpdate() > 0;

        } catch (SQLException e) {
            System.out.println("Error restoring album: " + e.getMessage());
            return false;
        }
    }

    @Override
    public List<Album> getArchivedAlbums() {

        List<Album> albums = new ArrayList<>();

        String query = "SELECT * FROM albums WHERE is_archived = 1";

        try (Connection conn = dbConnection.connect();
             PreparedStatement prep = conn.prepareStatement(query);
             ResultSet rs = prep.executeQuery()) {

            while (rs.next()) {

                albums.add(new Album(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getInt("year"),
                        rs.getInt("artist_id"),
                        rs.getInt("is_archived")
                ));
            }

        } catch (SQLException e) {
            System.out.println("Error retrieving archived albums: " + e.getMessage());
        }

        return albums;
    }
}