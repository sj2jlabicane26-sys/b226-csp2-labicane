package com.joysistvi.recordingapp.model;

public class Album {

    private int id;
    private String name;
    private int year;
    private int isArchived;

    public Album() {
    }

    // Constructor for creating a new album
    public Album(String name, int year) {
        this.name = name;
        this.year = year;
    }

    // Constructor for retrieving from database
    public Album(int id, String name, int year, int isArchived) {
        this.id = id;
        this.name = name;
        this.year = year;
        this.isArchived = isArchived;
    }

    @Override
    public String toString() {
        return "Album{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", year=" + year +
                ", isArchived=" + isArchived +
                '}';
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

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getIsArchived() {
        return isArchived;
    }

    public void setIsArchived(int isArchived) {
        this.isArchived = isArchived;
    }
}