package com.joysistvi.recordingapp.repository;

import com.joysistvi.recordingapp.config.DbConnection;
import com.joysistvi.recordingapp.model.User;
import org.mindrot.jbcrypt.BCrypt;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserRepositoryImpl implements UserRepository {


    private final DbConnection dbConnection;


    // Constructor Injection
    public UserRepositoryImpl(DbConnection dbConnection) {
        this.dbConnection = dbConnection;
    }



    // ================= REGISTER USER =================
    @Override
    public boolean registerUser(User user) {


        String query = "INSERT INTO users(username, password, playlist_id) VALUES (?, ?, ?)";


        // Hash password
        String hashedPassword = BCrypt.hashpw(
                user.getPassword(),
                BCrypt.gensalt()
        );


        try (Connection connection = dbConnection.connect();
             PreparedStatement prep = connection.prepareStatement(query)) {


            prep.setString(1, user.getUsername());
            prep.setString(2, hashedPassword);
            prep.setInt(3, user.getPlaylist_id());


            int rows = prep.executeUpdate();


            return rows > 0;


        } catch (SQLException e) {

            System.out.println("Register User Error: " + e.getMessage());
            return false;
        }
    }





    // ================= LOGIN USER =================
    @Override
    public boolean loginUser(String username, String password) {


        String query = "SELECT password FROM users WHERE username = ?";


        try (Connection connection = dbConnection.connect();
             PreparedStatement prep = connection.prepareStatement(query)) {


            prep.setString(1, username);


            ResultSet rs = prep.executeQuery();



            if (rs.next()) {


                String storedHash = rs.getString("password");


                return BCrypt.checkpw(password, storedHash);

            }



        } catch (SQLException e) {

            System.out.println("Login Error: " + e.getMessage());
        }


        return false;
    }





    // ================= GET USER BY USERNAME =================
    @Override
    public User getUserByUsername(String username) {


        String query = "SELECT * FROM users WHERE username = ?";


        try (Connection connection = dbConnection.connect();
             PreparedStatement prep = connection.prepareStatement(query)) {


            prep.setString(1, username);


            ResultSet rs = prep.executeQuery();



            if (rs.next()) {


                User user = new User();


                user.setId(rs.getInt("id"));
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                user.setPlaylist_id(rs.getInt("playlist_id"));


                return user;
            }



        } catch (SQLException e) {

            System.out.println("Get User Error: " + e.getMessage());
        }


        return null;
    }





    // ================= DELETE USER =================
    @Override
    public boolean deleteUser(int id) {


        String query = "DELETE FROM users WHERE id = ?";


        try (Connection connection = dbConnection.connect();
             PreparedStatement prep = connection.prepareStatement(query)) {


            prep.setInt(1, id);


            return prep.executeUpdate() > 0;



        } catch (SQLException e) {


            System.out.println("Delete User Error: " + e.getMessage());
            return false;
        }
    }
}