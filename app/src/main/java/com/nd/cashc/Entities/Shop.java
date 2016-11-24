package com.nd.cashc.Entities;

import java.util.UUID;

/**
 * Created by ND on 11/23/2016.
 */

public class Shop {

    private UUID id;
    private String name;
    private String location;
    private Integer rating;
    private String comment;

    public Shop(String name, String location, Integer rating, String comment) {
        this.id = UUID.randomUUID();
        this.name = name;
        this.location = location;
        this.rating = rating;
        this.comment = comment;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
