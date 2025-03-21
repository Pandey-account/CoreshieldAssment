
package com.example.assment.model;


public class MergedLocation {
    
	private String id;
    private double latitude;
    private double longitude;
    private String type;
    private Double rating; // Changed from double to Double
    private Integer reviews; // Changed from int to Integer

    // Constructors, getters, and setters
    public MergedLocation() {}

    public MergedLocation(String id, double latitude, double longitude, String type, Double rating, Integer reviews) {
        this.id = id;
        this.latitude = latitude;
        this.longitude = longitude;
        this.type = type;
        this.rating = rating;
        this.reviews = reviews;
    }

    // Getters and setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public Integer getReviews() {
        return reviews;
    }

    public void setReviews(Integer reviews) {
        this.reviews = reviews;
    }
}
