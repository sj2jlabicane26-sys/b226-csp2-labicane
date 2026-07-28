package com.joysistvi.recordingapp.repository;

import com.joysistvi.recordingapp.config.DbConnection;
import com.joysistvi.recordingapp.model.Playlist;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PlaylistRepositoryImpl implements PlaylistRepository {

    private final DbConnection dbConnection;

    public PlaylistRepositoryImpl(DbConnection dbConnection) {
        this.dbConnection = dbConnection;
    }

    @Override
    public boolean createPlaylist(Playlist playlist) {

        String query = "INSERT INTO playlist(date_created, songs_id) VALUES(?, ?)";

        try (Connection conn = dbConnection.connect();
             PreparedStatement prep = conn.prepareStatement(query)) {

            prep.setString(1, playlist.getDateCreated());
            prep.setInt(2, playlist.getSongsId());

            return prep.executeUpdate() > 0;

        } catch (SQLException e) {
            System.out.println("Error creating playlist: " + e.getMessage());
        }

        return false;
    }

    @Override
    public List<Playlist> getAllPlaylists() {

        List<Playlist> playlists = new ArrayList<>();

        String query = "SELECT * FROM playlist WHERE is_archived = 0";

        try (Connection conn = dbConnection.connect();
             PreparedStatement prep = conn.prepareStatement(query);
             ResultSet rs = prep.executeQuery()) {

            while (rs.next()) {

                Playlist playlist = new Playlist();

                playlist.setId(rs.getInt("id"));
                playlist.setDateCreated(rs.getString("date_created"));
                playlist.setSongsId(rs.getInt("songs_id"));
                playlist.setIsArchived(rs.getInt("is_archived"));

                playlists.add(playlist);
            }

        } catch (SQLException e) {
            System.out.println("Error retrieving playlists: " + e.getMessage());
        }

        return playlists;
    }

    @Override
    public Playlist getPlaylistById(int id) {

        String query = "SELECT * FROM playlist WHERE id = ?";

        try (Connection conn = dbConnection.connect();
             PreparedStatement prep = conn.prepareStatement(query)) {

            prep.setInt(1, id);

            ResultSet rs = prep.executeQuery();

            if (rs.next()) {

                Playlist playlist = new Playlist();

                playlist.setId(rs.getInt("id"));
                playlist.setDateCreated(rs.getString("date_created"));
                playlist.setSongsId(rs.getInt("songs_id"));
                playlist.setIsArchived(rs.getInt("is_archived"));

                return playlist;
            }

        } catch (SQLException e) {
            System.out.println("Error retrieving playlist: " + e.getMessage());
        }

        return null;
    }

    @Override
    public boolean updatePlaylist(Playlist playlist) {

        String query = "UPDATE playlist SET date_created=?, songs_id=? WHERE id=?";

        try (Connection conn = dbConnection.connect();
             PreparedStatement prep = conn.prepareStatement(query)) {

            prep.setString(1, playlist.getDateCreated());
            prep.setInt(2, playlist.getSongsId());
            prep.setInt(3, playlist.getId());

            return prep.executeUpdate() > 0;

        } catch (SQLException e) {
            System.out.println("Error updating playlist: " + e.getMessage());
        }

        return false;
    }

    @Override
    public boolean archivePlaylist(int id) {

        String query = "UPDATE playlist SET is_archived = 1 WHERE id = ?";

        try (Connection conn = dbConnection.connect();
             PreparedStatement prep = conn.prepareStatement(query)) {

            prep.setInt(1, id);

            return prep.executeUpdate() > 0;

        } catch (SQLException e) {
            System.out.println("Error archiving playlist: " + e.getMessage());
        }

        return false;
    }

    @Override
    public boolean restorePlaylist(int id) {

        String query = "UPDATE playlist SET is_archived = 0 WHERE id = ?";

        try (Connection conn = dbConnection.connect();
             PreparedStatement prep = conn.prepareStatement(query)) {

            prep.setInt(1, id);

            return prep.executeUpdate() > 0;

        } catch (SQLException e) {
            System.out.println("Error restoring playlist: " + e.getMessage());
        }

        return false;
    }

    @Override
    public boolean deletePlaylist(int id) {

        String query = "DELETE FROM playlist WHERE id = ?";

        try (Connection conn = dbConnection.connect();
             PreparedStatement prep = conn.prepareStatement(query)) {

            prep.setInt(1, id);

            return prep.executeUpdate() > 0;

        } catch (SQLException e) {
            System.out.println("Error deleting playlist: " + e.getMessage());
        }

        return false;
    }

    @Override
    public List<Playlist> getArchivedPlaylists() {

        List<Playlist> playlists = new ArrayList<>();

        String query = "SELECT * FROM playlist WHERE is_archived = 1";

        try (Connection conn = dbConnection.connect();
             PreparedStatement prep = conn.prepareStatement(query);
             ResultSet rs = prep.executeQuery()) {

            while (rs.next()) {

                Playlist playlist = new Playlist();

                playlist.setId(rs.getInt("id"));
                playlist.setDateCreated(rs.getString("date_created"));
                playlist.setSongsId(rs.getInt("songs_id"));
                playlist.setIsArchived(rs.getInt("is_archived"));

                playlists.add(playlist);
            }

        } catch (SQLException e) {
            System.out.println("Error retrieving archived playlists: " + e.getMessage());
        }

        return playlists;
    }
}