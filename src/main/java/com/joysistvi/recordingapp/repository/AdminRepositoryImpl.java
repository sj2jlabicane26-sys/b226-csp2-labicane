package com.joysistvi.recordingapp.repository;


import com.joysistvi.recordingapp.config.DbConnection;
import com.joysistvi.recordingapp.model.Admin;

import org.mindrot.jbcrypt.BCrypt;

import java.sql.*;


public class AdminRepositoryImpl implements AdminRepository {


    private final DbConnection dbConnection;


    public AdminRepositoryImpl(DbConnection dbConnection){

        this.dbConnection = dbConnection;

    }



    @Override
    public boolean createAdmin(Admin admin){


        String sql =
                "INSERT INTO admins(username,password,is_archived) VALUES(?,?,?)";



        String hashPassword =
                BCrypt.hashpw(
                        admin.getPassword(),
                        BCrypt.gensalt()
                );


        try(Connection connection = dbConnection.connect();
            PreparedStatement ps = connection.prepareStatement(sql)){


            ps.setString(1,admin.getUsername());
            ps.setString(2,hashPassword);
            ps.setInt(3,0);


            return ps.executeUpdate()>0;



        }catch(SQLException e){

            System.out.println("Create Admin Error: "+e.getMessage());

        }


        return false;

    }




    @Override
    public Admin login(String username,String password){


        String sql =
                "SELECT * FROM admins WHERE username=? AND is_archived=0";



        try(Connection connection = dbConnection.connect();
            PreparedStatement ps = connection.prepareStatement(sql)){


            ps.setString(1,username);


            ResultSet rs = ps.executeQuery();



            if(rs.next()){


                String hash =
                        rs.getString("password");



                if(BCrypt.checkpw(password,hash)){


                    Admin admin = new Admin();


                    admin.setId(rs.getInt("id"));
                    admin.setUsername(rs.getString("username"));
                    admin.setPassword(hash);
                    admin.setIsArchived(
                            rs.getInt("is_archived")
                    );


                    return admin;

                }

            }



        }catch(SQLException e){

            System.out.println("Login Error: "+e.getMessage());

        }



        return null;

    }

}