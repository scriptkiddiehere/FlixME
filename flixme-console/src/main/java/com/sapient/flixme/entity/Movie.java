package com.sapient.flixme.entity;

import java.util.List;

import lombok.Data;

@Data
public class Movie {
    private int id;
    private String title;
    private String genre;
    private float rating;
    private int duration;
    private String desc;
    private int releaseYear;
    List<Review> review;
}
