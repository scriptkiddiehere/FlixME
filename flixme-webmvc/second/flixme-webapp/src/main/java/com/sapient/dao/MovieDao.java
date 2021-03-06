package com.sapient.dao;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;

import com.sapient.controllers.CustomerController;
import com.sapient.entity.Customer;
import com.sapient.entity.Movie;

import lombok.extern.slf4j.Slf4j;

public interface MovieDao {

	@Transactional(readOnly = false)
	public void addNewMovie(Movie movie) throws DaoException;

	@Transactional(readOnly = false)
	public void updateMovie(Movie movie) throws DaoException;

	public Movie findByTitle(String title) throws DaoException;

	public List<Movie> findAll() throws DaoException;

	public Movie findById(Integer id) throws DaoException;

	List<Movie> findByGenre(String gerne) throws DaoException;

	@Transactional(readOnly = false)
	public void delete(Integer id) throws DaoException;

}
