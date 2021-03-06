package com.sapient.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.sapient.entity.Customer;
import com.sapient.entity.Movie;

@Repository
public class CustomerDaoHibernateTemplateImpl implements CustomerDao {

	@Autowired
	HibernateTemplate template;

	@Override
	public void addNewCustomer(Customer customer) throws DaoException {
		try {
			template.persist(customer);
		} catch (Exception e) {
			throw new DaoException(e);
		}
	}

	@Override
	public Customer findById(Integer id) throws DaoException {
		try {
			return template.get(Customer.class, id);
		} catch (DataAccessException e) {
			throw new DaoException(e);
		}

	}

	@Override
	public void updateCustomer(Customer customer) throws DaoException {
		template.merge(customer);
	}

	@Override
	public Customer findByEmail(String email) throws DaoException {
		try {
			String hql = "from Customer where email=?0";
			return (Customer) template.find(hql, email).get(0);
		} catch (Exception e) {
			throw new DaoException(e);
		}
	}

	@Override
	public List<Customer> findAll() throws DaoException {
		try {
			return (List<Customer>) template.find("from Customer order by id");
		} catch (DataAccessException e) {
			throw new DaoException(e);
		}
	}



}
