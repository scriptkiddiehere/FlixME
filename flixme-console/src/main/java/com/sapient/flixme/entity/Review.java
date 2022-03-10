package com.sapient.flixme.entity;

import lombok.Data;

@Data
public class Review {
    private int reviewId;
    private String customerName;
    private int customerId;
    private String email;
    private String review;
    private String movieName;
    private int movieId;
    private float rating;
}
