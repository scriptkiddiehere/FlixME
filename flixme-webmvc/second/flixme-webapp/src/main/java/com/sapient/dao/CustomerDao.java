package com.sapient.dao;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.sapient.entity.Customer;
import com.sapient.entity.Movie;

public interface CustomerDao {
	@Transactional(readOnly = false)
	public void addNewCustomer(Customer customer) throws DaoException;

	public Customer findById(Integer id) throws DaoException;

	@Transactional(readOnly = false)
	public void updateCustomer(Customer customer) throws DaoException;

	public Customer findByEmail(String email) throws DaoException;

	public List<Customer> findAll() throws DaoException;
	
	
}
