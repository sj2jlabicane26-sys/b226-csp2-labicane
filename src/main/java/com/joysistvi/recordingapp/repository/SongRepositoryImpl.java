package com.joysistvi.recordingapp.repository;

import com.joysistvi.recordingapp.config.DbConnection;
import com.joysistvi.recordingapp.model.Song;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SongRepositoryImpl implements SongRepository{

    private final DbConnection dbConnection; // Composition

    // Constructor injection
    public SongRepositoryImpl(DbConnection dbConnection) {
        this.dbConnection = dbConnection;
    }

    public List<Song> getAllSongs() {
        List<Song> songs = new ArrayList<>();
        String query = "SELECT s.id, s.title, s.length, s.genre, a.name " +
                "FROM songs s " +
                "JOIN albums a ON s.album_id = a.id " +
                "WHERE s.is_archived = 0";

        try (Connection conn = dbConnection.connect();
             PreparedStatement prep = conn.prepareStatement(query);
             ResultSet res = prep.executeQuery()) {


            while (res.next()) {
                songs.add(new Song(
                        res.getInt("id"),
                        res.getString("title"),
                        res.getString("length"),
                        res.getString("genre"),
                        res.getString("name")
                ));

            }

        } catch (Exception e) {
            System.out.println("Read Songs With Album: " + e.getMessage());
        }

        return songs;
    }
    public boolean createSong(Song song) {
        String query = "INSERT INTO songs (title, length, genre, album_id) " + // create statement
                "VALUES (?,?,?,?)"; // Anti-SQL Injection

        // Try-with-resources: automatically close opened connection
        try (Connection connection = dbConnection.connect();
             PreparedStatement prep = connection.prepareStatement(query);
        ) {
            // Bind values to the placeholders in the query
            prep.setString(1, song.getTitle());
            prep.setString(2, song.getLength());
            prep.setString(3, song.getGenre());
            prep.setInt(4, song.getAlbumId());

            // Execute the insert statement
            int rowsAffected = prep.executeUpdate();
            return rowsAffected > 0;

        } catch (SQLException e) {
            // Print the error message if something goes wrong
            System.out.println("Error in inserting song: " + e.getMessage());

        }
        return false;
    }

    // Update Song
    public boolean updateSong(String title, String length, String genre, int id) {
        String query = "UPDATE songs SET title = ?, length = ?, genre = ? WHERE id = ?"; // parametherized query

        try (Connection conn = dbConnection.connect();
             PreparedStatement prep = conn.prepareStatement(query)) {

            // setting parameter wild cards
            prep.setString(1, title);
            prep.setString(2, length);
            prep.setString(3, genre);
            prep.setInt(4, id);

            int rowsAffected = prep.executeUpdate();
            return rowsAffected > 0;


        } catch (SQLException e) {
            System.out.println("Update Song: " + e.getMessage());

        }
        return false;
    }

    // Hard Delete Song
    public boolean deleteSong(int id) {
        String query = "DELETE FROM songs WHERE id = ?";

        try (Connection conn = dbConnection.connect();
             PreparedStatement prep = conn.prepareStatement(query)) {

            prep.setInt(1, id);
            int rows = prep.executeUpdate();
            return rows > 0;

        } catch (SQLException e) {
            System.out.println("Delete Song: " + e.getMessage());
        }
        return false;
    }


}
