package com.joysistvi.recordingapp.dao;


import com.joysistvi.recordingapp.config.DbConnection;



public class Main {
    public static void main(String[] args) {
        DbConnection dbConnection = new DbConnection();
        SongDao songDao = new SongDao(dbConnection);
        songDao.createSong("binhi","03:56","Pop", 1);

        UserDao userDao = new UserDao(dbConnection);
        userDao.registerUser("asta","asta123");
    }




        /*

           songDao.archiveSong();

//        SongDaoUpdate songDaoUpdate = new SongDaoUpdate(dbConnection);
//        songDaoUpdate.updateSong(1,"guma", "3:50","POP", 1);

        SongDaoDelete songDaoDelete = new SongDaoDelete(dbConnection);
        songDaoDelete.deleteSong(16);

         */
    }




