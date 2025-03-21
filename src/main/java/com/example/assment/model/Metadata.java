
package com.example.assment.model;


public class Metadata {

	private String id;
    private String type;
    private Double rating; // Changed from double to Double
    private Integer reviews; // Changed from int to Integer

    // Constructors, getters, and setters
    public Metadata() {}

    public Metadata(String id, String type, Double rating, Integer reviews) {
        this.id = id;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public int getReviews() {
        return reviews;
    }

    public void setReviews(Integer reviews) {
        this.reviews = reviews;
    }
    
}
