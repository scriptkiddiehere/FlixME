package com.sapient.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.sapient.entity.Movie;
import com.sapient.entity.Review;

@Repository("reviewDao")
public interface ReviewDao {
	@Transactional(readOnly = false)
	public void addNewReview(Review review) throws DaoException;

	@Transactional(readOnly = false)
	public void updateReview(Review review) throws DaoException;

	public List<Review> findAll() throws DaoException;

	public Review findById(Integer id) throws DaoException;

	public List<Review> findByCustomerId(Integer id) throws DaoException;

	public List<Review> findByMovie(Integer id) throws DaoException;

	@Transactional(readOnly = false)
	void deleteReview(Integer id) throws DaoException;
}
