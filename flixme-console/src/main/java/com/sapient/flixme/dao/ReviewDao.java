package com.sapient.flixme.dao;

import java.util.List;

import com.sapient.flixme.entity.Review;

public interface ReviewDao {

    public List<Review> findById(Integer id) throws DaoException;

    public Review addNewReview(Review review) throws DaoException;

    public List<Review> findAll();

    public void updateReview(Review review) throws DaoException;

    public void deleteReview(int id);

    public Review getReview(int reviewid) throws DaoException;

}
