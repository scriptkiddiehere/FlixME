package com.sapient.flixme.dao;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.sapient.flixme.entity.Customer;
import com.sapient.flixme.entity.Review;

public class CustomerDaoHashMapImpl implements CustomerDao {
	private Map<Integer, Customer> data = new HashMap<>();
	private static final int ID_COUNTER = 2;
	public CustomerDaoHashMapImpl() {
		Customer c1=new Customer();
		c1.setId(1);
		c1.setName("Shivam");
		c1.setEmail("shivam@shivam.com");
		c1.setPassword("password");
		c1.setPhone("9567898763");
		c1.setStreet("5");
		c1.setCity("Ghaziabad");
		c1.setState("Uttar Pradesh");
		c1.setCountry("India");
		c1.setPincode(201005);
		c1.setBalance(100d);
		data.put(1, c1);
		
		c1=new Customer();
		c1.setId(2);
		c1.setName("Rahul");
		c1.setEmail("rahul@rahul.com");
		c1.setPassword("password");
		c1.setPhone("9567898763");
		c1.setStreet("new street");
		c1.setCity("Delhi");
		c1.setState("New delhi");
		c1.setCountry("India");
		c1.setBalance(50d);
		data.put(2, c1);
		
	}

	@Override
	public void addNewCustomer(Customer customer) throws DaoException {
		customer.setId(ID_COUNTER + 1);
		data.put(customer.getId(), customer);
	}

	@Override
	public Customer findById(Integer id) throws DaoException {
		return data.get(id);
	}

	@Override
	public void updateCustomer(Customer customer) throws DaoException {
		if (data.containsKey(customer.getId())) {
			data.put(customer.getId(), customer);
		} else {
			throw new DaoException("No data found" + customer.getId());
		}
	}

	@Override
	public Customer findByEmail(String email) throws DaoException {
		Collection<Customer> customers = data.values();
		Iterator<Customer> it = customers.iterator();
		while(it.hasNext()) {
			Customer c=it.next();
			if(c.getEmail().equals(email)) {
				return c;
			}
		}
		return null;
	}

	@Override
	public List<Customer> findAll() throws DaoException {
		List<Customer> list = new ArrayList<>();
        list.addAll(data.values());
        return list;
	}

	@Override
	public void addReview(Review review) throws DaoException {
		Customer customer= findById(review.getCustomerId());
		List<Review> reviews= customer.getReviews();
		if(reviews==null)
			reviews= new ArrayList<>();
		reviews.add(review);
	}

	@Override
	public void deleteReview(Review review) throws DaoException {
		Customer customer= findById(review.getCustomerId());
		List<Review> reviews= customer.getReviews();
		reviews.remove(review);		
	}
}
