/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.joysistvi.recordingapp.model;


// Model → Repository → Service → Controller → View

// Encapsulated Class
public class Song {

    // private fields
    private int id;
    private String title;
    private String length;
    private String genre;
    private String albumName;
    private int albumId;
    private int isArchived;

    public Song() {
    }

    public Song(String title, String length, String genre, int albumId) {
        this.title = title;
        this.length = length;
        this.genre = genre;
        this.albumId = albumId;
    }

    public Song(int id, String title, String length, String genre, String albumName) {
        this.id = id;
        this.title = title;
        this.length = length;
        this.genre = genre;
        this.albumName = albumName;
    }

    public int getIsArchived() {
        return isArchived;
    }

    public void setIsArchived(int isArchived) {
        this.isArchived = isArchived;
    }

    public int getAlbumId() {
        return albumId;
    }

    public void setAlbumId(int albumId) {
        this.albumId = albumId;
    }

    public String getAlbumName() {
        return albumName;
    }

    public void setAlbumName(String albumName) {
        this.albumName = albumName;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getLength() {
        return length;
    }

    public void setLength(String length) {
        this.length = length;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Song{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", length='" + length + '\'' +
                ", genre='" + genre + '\'' +
                ", albumName='" + albumName + '\'' +
                ", albumId=" + albumId +
                ", isArchived=" + isArchived +
                '}';
    }
}