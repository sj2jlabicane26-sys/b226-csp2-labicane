package com.joysistvi.recordingapp.model;

public class Artist {

    private int id;
    private String name;
    private int isArchived;

    // Default Constructor
    public Artist() {
    }

    // Constructor for creating a new artist
    public Artist(String name) {
        this.name = name;
    }

    // Constructor with id and name
    public Artist(int id, String name) {
        this.id = id;
        this.name = name;
    }

    // Constructor with id, name, and archive status
    public Artist(int id, String name, int isArchived) {
        this.id = id;
        this.name = name;
        this.isArchived = isArchived;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getIsArchived() {
        return isArchived;
    }

    public void setIsArchived(int isArchived) {
        this.isArchived = isArchived;
    }
}