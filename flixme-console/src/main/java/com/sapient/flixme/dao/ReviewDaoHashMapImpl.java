package com.sapient.flixme.dao;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.sapient.flixme.entity.Review;

public class ReviewDaoHashMapImpl implements ReviewDao {
    private Map<Integer, Review> rdata = new HashMap<>();
    static int ID_COUNTER = 1;

    public ReviewDaoHashMapImpl() {
        Review r = new Review();
        r.setReviewId(1);
        r.setCustomerId(1);
        r.setMovieId(1);
        r.setMovieName("deadpool");
        r.setEmail("shivam@shivam.com");
        r.setReview("Awesome movie");
        r.setCustomerName("Shivam");
        rdata.put(1, r);

        r = new Review();
        r.setReviewId(2);
        r.setCustomerId(2);
        r.setMovieId(2);
        r.setMovieName("dolittle");
        r.setEmail("rahul@rahul.com");
        r.setReview("Average movie");
        r.setCustomerName("Rahul");
        rdata.put(2, r);
    }

    @Override
    public Review addNewReview(Review review) throws DaoException {
        rdata.put(ID_COUNTER+1, review);
        ID_COUNTER++;
        return review;
    }

    @Override
    public void updateReview(Review review) throws DaoException {
        if (rdata.containsKey(review.getReviewId())) {
            rdata.put(review.getReviewId(), review);
        } else {
            throw new DaoException("No data found" + review.getReviewId());
        }
    }

    @Override
    public Review getReview(int reviewId) throws DaoException {
        return rdata.get(reviewId);
    }

    @Override
    public List<Review> findById(Integer id) throws DaoException {
        List<Review> list = new ArrayList<>();
        Collection<Review> reviews = rdata.values();
        Iterator<Review> it = reviews.iterator();
        while (it.hasNext()) {
            Review r = it.next();
            if (r.getCustomerId() == id) {
                list.add(r);
            }
        }
        return list;
    }

    @Override
    public List<Review> findAll() {
        List<Review> list = new ArrayList<>();
        list.addAll(rdata.values());
        return list;
    }

    @Override
    public void deleteReview(int id) {
        if (rdata.containsKey(id)) {
            rdata.remove(id);
            System.out.println("Review deleted successfully ");
        } else {
            System.out.println("Id not found!! try again");
        }
    }

}
