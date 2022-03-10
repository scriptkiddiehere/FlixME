package com.sapient.flixme.dao;

import java.util.List;

import com.sapient.flixme.entity.Customer;
import com.sapient.flixme.entity.Review;

public interface CustomerDao {
    public void addNewCustomer(Customer customer) throws DaoException;

    public Customer findById(Integer id) throws DaoException;

    public void updateCustomer(Customer customer) throws DaoException;

    public Customer findByEmail(String email) throws DaoException;

    public List<Customer> findAll() throws DaoException;

    public void addReview(Review review) throws DaoException;

    public void deleteReview(Review review) throws DaoException;
}
