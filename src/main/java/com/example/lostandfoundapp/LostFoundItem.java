package com.example.lostandfoundapp;

public class LostFoundItem {
    private int id;
    private String name;
    private String description;
    private String contact;
    private String date;
    private String location;
    private String status;

    // New fields
    private double latitude;
    private double longitude;

    public LostFoundItem(int id, String name, String description, String contact, String date, String location, String status, double latitude, double longitude) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.contact = contact;
        this.date = date;
        this.location = location;
        this.status = status;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    // Existing getters
    public int getId() { return id; }
    public String getName() { return name; }
    public String getDescription() { return description; }
    public String getContact() { return contact; }
    public String getDate() { return date; }
    public String getLocation() { return location; }
    public String getStatus() { return status; }

    // New getters
    public double getLatitude() { return latitude; }
    public double getLongitude() { return longitude; }

    // Optional alias for map marker title
    public String getTitle() { return name; }
}
