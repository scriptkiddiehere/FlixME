package com.sapient.dao;

import com.sapient.entity.Review;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ReviewDao extends CrudRepository<Review, Integer> {

    List<Review> findByUserId(Integer userId);
    List<Review> findByMovieId(Integer movieId);
    List<Review> findByMovieName(String movieName);
}
