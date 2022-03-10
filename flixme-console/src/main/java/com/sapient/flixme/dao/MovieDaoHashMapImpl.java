package com.sapient.flixme.dao;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.sapient.flixme.entity.Movie;
import com.sapient.flixme.entity.Review;

public class MovieDaoHashMapImpl implements MovieDao {
    private Map<Integer, Movie> movies = new HashMap<>();
    private static final int MOVIE_COUNTER = 2;
    ReviewDao r = new ReviewDaoHashMapImpl();

    public MovieDaoHashMapImpl() {
        Movie m = new Movie();
        m.setId(1);
        m.setTitle("Deadpool");
        m.setGenre("Action");
        m.setDuration(130);
        m.setReleaseYear(2018);
        movies.put(1, m);

        m = new Movie();
        m.setId(2);
        m.setTitle("Dolittle");
        m.setGenre("Drama");
        m.setDuration(165);
        m.setReleaseYear(2020);
        movies.put(2, m);
    }

    @Override
    public List<Movie> getMovies() throws DaoException {
        List<Movie> list = new ArrayList<>();
        list.addAll(movies.values());
        return list;
    }

    @Override
    public Movie getMovie(int id) throws DaoException {
        if (movies.containsKey(id)) {
            return movies.get(id);
        }
        throw new DaoException("No matching movie found for id " + id);
    }
    
    public Movie findByTitle(String title) throws DaoException {
        Collection<Movie> movie = movies.values();
        Iterator<Movie> it = movie.iterator();
        while (it.hasNext()) {
            Movie c = it.next();
            if (c.getTitle().equalsIgnoreCase(title)) {
                return c;
            }
        }
        return null;
    }

    @Override
    public void addMovie(Movie movie) throws DaoException {
        movie.setId(MOVIE_COUNTER + 1);
        movies.put(movie.getId(), movie);
    }

    @Override
    public void updateMovie(Movie movie) throws DaoException {
        int id = movie.getId();
		if (movies.containsKey(id)) {
			movies.put(id, movie);
		} else {
            throw new DaoException("No matching record found for id " + id);
        }
    }

    @Override
    public Movie findByGenre(String genre) throws DaoException {
        Collection<Movie> movie = movies.values();
        Iterator<Movie> it = movie.iterator();
        while (it.hasNext()) {
            Movie c = it.next();
            if (c.getGenre().equalsIgnoreCase(genre)) {
                return c;
            }
        }
        return null;
    }

    @Override
    public Movie findByRating(float rating) throws DaoException {
        Collection<Movie> movie = movies.values();
        Iterator<Movie> it = movie.iterator();
        while (it.hasNext()) {
            Movie c = it.next();
            if (c.getRating()==rating) {
                return c;
            }
        }
        return null;
    }

    @Override
	public void addReview(Review review) throws DaoException {
		Movie movie= getMovie(review.getMovieId());
		List<Review> reviews= movie.getReview();
		if(reviews==null)
			reviews= new ArrayList<>();
		reviews.add(review);
	}

	@Override
	public void deleteReview(Review review) throws DaoException {
		Movie movie= getMovie(review.getMovieId());
		List<Review> reviews= movie.getReview();
		reviews.remove(review);
	}

}
