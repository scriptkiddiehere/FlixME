package com.sapient.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.sapient.entity.Customer;
import com.sapient.entity.Movie;
import com.sapient.entity.Review;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Repository
public class ReviewDaoHibernateTemplateImpl implements ReviewDao {

	@Autowired
	HibernateTemplate template;

	@Override
	public void addNewReview(Review review) throws DaoException {
		try {
			log.debug("review is {}", review);
			template.persist(review);
		} catch (Exception e) {
			throw new DaoException(e);
		}

	}

	@Override
	public void updateReview(Review review) throws DaoException {
		template.merge(review);

	}

	@Override
	public List<Review> findAll() throws DaoException {
		try {
			return (List<Review>) template.find("from Movie order by id");
		} catch (DataAccessException e) {
			throw new DaoException(e);
		}

	}

	@Override
	public Review findById(Integer id) throws DaoException {
		try {
			return template.get(Review.class, id);
		} catch (DataAccessException e) {
			throw new DaoException(e);
		}
	}

	@Override
	public List<Review> findByCustomerId(Integer customer_id) throws DaoException {
		try {
			String hql = "from Review where customer_id=?0";
			return (List<Review>) template.find(hql, customer_id);
		} catch (Exception e) {
			throw new DaoException(e);
		}
	}

	@Override
	public List<Review> findByMovie(Integer movie_id) throws DaoException {
		try {
			String hql = "from Review where movie_id=?0";
			return (List<Review>) template.find(hql, movie_id);
		} catch (Exception e) {
			throw new DaoException(e);
		}
	}

	@Override
	public void deleteReview(Integer id) throws DaoException {
		try {
			Review review = this.findById(id);
			if (review != null) {
				template.delete(review);
			} else {
				throw new DaoException("No data found for id: " + id);
			}
		} catch (Exception e) {
			throw new DaoException(e);
		}
	}

}
