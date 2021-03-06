package com.sapient.dao;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.sapient.entity.Customer;
import com.sapient.entity.Movie;

@Repository
public class MovieDaoHibernateTemplateImpl implements MovieDao {

	@Autowired
	HibernateTemplate template;

	@Override
	public void addNewMovie(Movie movie) throws DaoException {
		try {
			template.persist(movie);
		} catch (Exception e) {
			throw new DaoException(e);
		}

	}

	@Override
	public List<Movie> findAll() throws DaoException {
		try {
			return (List<Movie>) template.find("from Movie order by id");
		} catch (DataAccessException e) {
			throw new DaoException(e);
		}
	}

	@Override
	public Movie findById(Integer id) throws DaoException {
		try {
			return template.get(Movie.class, id);
		} catch (DataAccessException e) {
			throw new DaoException(e);
		}
	}

	@Override
	public void updateMovie(Movie movie) throws DaoException {
		template.merge(movie);
	}

	@Override
	public Movie findByTitle(String title) throws DaoException {
		try {
			String hql = "from Movie where title=?0";
			return (Movie) template.find(hql, title).get(0);
		} catch (Exception e) {
			throw new DaoException(e);
		}

	}

	@Override
	public List<Movie> findByGenre(String genre) throws DaoException {
		try {
			String hql = "from Movie where genre=?0";
			return (List<Movie>) template.find(hql, genre);
		} catch (Exception e) {
			throw new DaoException(e);
		}

	}

	@Override
	public void delete(Integer id) throws DaoException {
		try {
			Movie movie = this.findById(id);
			if (movie != null) {
				template.delete(movie);
			} else {
				throw new DaoException("No data found for id: " + id);
			}
		} catch (Exception e) {
			throw new DaoException(e);
		}		
	}
}
