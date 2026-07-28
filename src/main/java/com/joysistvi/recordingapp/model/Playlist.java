package com.joysistvi.recordingapp.model;

public class Playlist {
    private int id;
    private String dateCreated;
    private int songsId;
    private int isArchived;

    public Playlist() {
    }

    public Playlist(int id, String dateCreated, int songsId) {
        this.id = id;
        this.dateCreated = dateCreated;
        this.songsId = songsId;

    }


    public Playlist(int id, String dateCreated, int songsId, int isArchived) {
        this.id = id;
        this. dateCreated = dateCreated;
        this. songsId = songsId;
        this.isArchived = isArchived;

    }

    @Override
    public String toString() {
        return "Playlist{" +
                "id=" + id +
                ", dateCreated=" + dateCreated +
                ", songsId=" + songsId +
                ", isArchived=" + isArchived +
                '}';
    }

    public int getIsArchived() {
        return isArchived;
    }

    public void setIsArchived(int isArchived) {
        this.isArchived = isArchived;
    }

    public int getSongsId() {
        return songsId;
    }

    public void setSongsId(int songsId) {
        this.songsId = songsId;
    }

    public String getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(String dateCreated) {
        this.dateCreated = dateCreated;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}

