package com.sapient.dao;

import com.sapient.entity.Movie;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface MovieDao extends CrudRepository<Movie, Integer> {

    List<Movie> findByName(String name);
    List<Movie> findByGenre(String genre);
    List<Movie> findByReleaseYear(String releaseYear);
    List<Movie> findByDuration(String Duration);
}
