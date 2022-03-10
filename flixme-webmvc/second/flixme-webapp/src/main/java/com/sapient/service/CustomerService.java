package com.sapient.service;

import com.sapient.dao.CustomerDao;
import com.sapient.dao.DaoException;
import com.sapient.dao.DaoFactory;
import com.sapient.entity.Customer;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CustomerService {
	
	private CustomerDao dao = DaoFactory.getCustomerDao();
	
	public Customer login(String email, String password) throws ServiceException {
		try {
			Customer c = dao.findByEmail(email);
			if (c == null) {
				throw new ServiceException("Invalid email/password");
			}
			if (c.getPassword().equals(password)) {
				return c;
			} else {
				throw new ServiceException("Invalid email/password");
			}

		} catch (DaoException e) {
			log.warn("Exception while calling login", e);
			throw new ServiceException(e);
		}
	}
}
