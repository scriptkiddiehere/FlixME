package com.sapient.flixme.dao;

import java.util.List;

import com.sapient.flixme.entity.Movie;
import com.sapient.flixme.entity.Review;

public interface MovieDao {
    public void addMovie(Movie movie) throws DaoException;

    public List<Movie> getMovies() throws DaoException;

    public void updateMovie(Movie movie) throws DaoException;

    public Movie getMovie(int id) throws DaoException;

    public Movie findByTitle(String title) throws DaoException;

    public Movie findByGenre(String genre) throws DaoException;

    public Movie findByRating(float rating) throws DaoException;

    public void addReview(Review review) throws DaoException;

    public void deleteReview(Review review) throws DaoException;
}
