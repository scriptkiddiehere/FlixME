package com.sapient.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "reviews")
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer userId;
    private Integer movieId;
    private String movieName;
    private String review;
    private Double rating;
}