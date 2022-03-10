package com.sapient.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "movies")
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String genre;
    private String releaseYear;
    private String duration;

}
