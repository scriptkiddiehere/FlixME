package com.sapient.flixme.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.sapient.flixme.dao.CustomerDao;
import com.sapient.flixme.dao.CustomerDaoHashMapImpl;
import com.sapient.flixme.dao.DaoException;
import com.sapient.flixme.dao.MovieDao;
import com.sapient.flixme.dao.MovieDaoHashMapImpl;
import com.sapient.flixme.dao.ReviewDao;
import com.sapient.flixme.dao.ReviewDaoHashMapImpl;
import com.sapient.flixme.entity.Customer;
import com.sapient.flixme.entity.Movie;
import com.sapient.flixme.entity.Review;
import com.sapient.flixme.util.KeyboardUtil;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MovieService {
    private MovieDao dao = new MovieDaoHashMapImpl();
    private ReviewDao rao = new ReviewDaoHashMapImpl();
    private CustomerDao cao = new CustomerDaoHashMapImpl();
    CustomerService cs = new CustomerService();
    Review review;

    public void addMovie() {
		try {
			System.out.println("Enter Details to add a new Movie: ");
			Movie m = new Movie();

			String input;
			input = KeyboardUtil.getString("Enter title: ");
			if (input.trim().length() != 0) {
				m.setTitle(input);
			}

			input = KeyboardUtil.getString("Enter genre: ");
			if (input.trim().length() != 0) {
				m.setGenre(input);
			}

			input = KeyboardUtil.getString("Enter description: ");
			if (input.trim().length() != 0) {
				m.setDesc(input);
			}

			input = KeyboardUtil.getString("Enter duration: ");
			if (input.trim().length() != 0) {
				m.setDuration(Integer.parseInt(input));
			}

			input = KeyboardUtil.getString("Enter Release year: ");
			if (input.trim().length() != 0) {
				m.setReleaseYear(Integer.parseInt(input));
			}

			dao.addMovie(m);
			System.out.println("Movie Added Successfully.");

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public void updateMovie() {
		try {
			int id = KeyboardUtil.getInt("Enter id to edit movie: ");
			Movie m = dao.getMovie(id);

			String input;
			input = KeyboardUtil.getString(String.format("Enter title: (%s)", m.getTitle()));
			if (input.trim().length() != 0) {
				m.setTitle(input);
			}

			input = KeyboardUtil.getString(String.format("Enter genre: (%s)", m.getGenre()));
			if (input.trim().length() != 0) {
				m.setGenre(input);
			}

			input = KeyboardUtil.getString(String.format("Enter description: (%s)", m.getDesc()));
			if (input.trim().length() != 0) {
				m.setDesc(input);
			}

			input = KeyboardUtil.getString(String.format("Enter duration: (%s)", m.getDuration()));
			if (input.trim().length() != 0) {
				m.setDuration(Integer.parseInt(input));
			}

			input = KeyboardUtil.getString(String.format("Enter Release Year: (%s)", m.getReleaseYear()));
			if (input.trim().length() != 0) {
				m.setReleaseYear(Integer.parseInt(input));
			}

			dao.updateMovie(m);

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

    public void searchByTitle() {
        try {
            String title = KeyboardUtil.getString("Enter title: ");
            List<Movie> list = dao.getMovies();
            list.stream()
                    .filter(m -> m.getTitle().equalsIgnoreCase(title))
                    .forEach(System.out::println);
        } catch (DaoException e) {
            log.warn("Error while executing searchByTitle()", e);
        }
    }

    public void allMovie() {
        try {
            List<Movie> list = dao.getMovies();
            System.out.printf("%4s %-20s %-20s %-10s %6s\n",
                    "ID", "Title", "Genre", "Duration", "Release-Year");
            System.out.println(
                    "-------------------------------------------------------------------------------------------------");
            list.forEach(this::printMovie);
            System.out.println(
                    "-------------------------------------------------------------------------------------------------");
        } catch (DaoException e) {
            log.warn("Error while executing allMovie()", e);
        }
    }

    void printMovie(Movie m) {
        System.out.printf("%4d %-20s %-20s %-10d %6d\n",
                m.getId(),
                m.getTitle(),
                m.getGenre(),
                m.getDuration(),
                m.getReleaseYear());
    }

    public void searchByOther() throws DaoException {
        int choice;
        List<Movie> list = dao.getMovies();

        while ((choice = searchByOtherMenu()) != 0) {
            switch (choice) {
                case 1:
                    String genre = KeyboardUtil.getString("Enter Genre: ");
                    list.stream()
                            .filter(m -> m.getGenre().equalsIgnoreCase(genre))
                            .forEach(System.out::println);
                    break;
                case 2:
                    int releaseYear = KeyboardUtil.getInt("Enter Release Year: ");
                    list.stream()
                            .filter(m -> m.getReleaseYear() == releaseYear)
                            .forEach(System.out::println);
                    break;
                default:
                    System.out.println("Enter a valid choice !!");
            }

        }
    }

    public int searchByOtherMenu() {
        try {
            System.out.println("1. Genre");
            System.out.println("2. Release Year");
            System.out.println("0. Exit");

            return KeyboardUtil.getInt("Enter your choice: ");
        } catch (Exception e) {
            log.warn("There was an error while accepting choice for searchByOtherMenu", e);
            return -1;
        }
    }

    public void enterReview(Customer loggedInCustomer) throws DaoException {
        review = new Review();
        String name = KeyboardUtil.getString("Enter the movie name you want to review: ");
        Movie movie = dao.findByTitle(name);
        review.setMovieId(movie.getId());
        review.setCustomerId(loggedInCustomer.getId());
        review.setReviewId(20);
        review.setMovieName(name);
        review.setCustomerName(loggedInCustomer.getName());
        String rev = KeyboardUtil.getString("Enter your review: ");
        review.setReview(rev);
        try {
            review= rao.addNewReview(review);
            dao.addReview(review);
            cao.addReview(review);
        } catch (DaoException e) {
        	log.debug(e.getMessage());
            throw new DaoException("Could Not add Review", e);
        }
        System.out.println("Submitted Review");
    }

    public void viewMyReview(Customer loggedInCustomer) throws DaoException {
        try {
            List<Review> r = rao.findById(loggedInCustomer.getId());
            r.stream().forEach(this::printReview);

        } catch (Exception e) {
            System.out.println("Exception" + e);
        }

    }

    void printReview(Review m) {
        System.out.println("Review id: " + m.getReviewId() + " \nMovie name: " + m.getMovieName()
                + "\nCustomer Name: " + m.getCustomerName() + "\nReview: "
                + m.getReview());
    }

    public void editReview(Customer loggedInCustomer) throws DaoException{
        List<Review> rr = rao.findById(loggedInCustomer.getId());
        rr.stream().forEach(this::printReview);
        int id =KeyboardUtil.getInt("Enter review id you want to update review for: ");
        List<Review> rnew=rr.stream().filter(o->o.getReviewId()==id).collect(Collectors.toList());
        rnew.stream().forEach(t -> {
            try {
                updateReviews(t);
                System.out.println("");
            } catch (DaoException e) {
                System.out.println(e);
            }
        });
    }

    void updateReviews(Review m) throws DaoException{
        String review = KeyboardUtil.getString("Enter your review: ");
        m.setReview(review);
        rao.updateReview(m);
    }

}
