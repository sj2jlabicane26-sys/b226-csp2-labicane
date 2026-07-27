package com.joysistvi.recordingapp.model;

public class Playlist {
    private int id;
    private int date_created;
    private int songs_id;


    public Playlist(int id, int date_created, int songs_id) {
        this.id = id;
        this.date_created = date_created;
        this.songs_id = songs_id;
    }

    public int getSongs_id() {
        return songs_id;
    }

    public void setSongs_id(int songs_id) {
        this.songs_id = songs_id;
    }

    public int getDate_created() {
        return date_created;
    }

    public void setDate_created(int date_created) {
        this.date_created = date_created;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
