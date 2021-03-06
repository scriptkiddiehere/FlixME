package com.sapient.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.sapient.dao.DaoException;
import com.sapient.dao.MovieDao;
import com.sapient.dao.ReviewDao;
import com.sapient.entity.Customer;
import com.sapient.entity.Movie;
import com.sapient.entity.Review;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class ReviewController {
	@Autowired
	private ReviewDao dao;
	@Autowired
	private MovieDao daoMovie;

	@RequestMapping(method = RequestMethod.GET, path = "/add-review")
	public String getReviewForm(@RequestParam("movieId") Integer id, Model model, HttpServletRequest request,
			HttpSession session) throws DaoException {

		Customer customer = (Customer) session.getAttribute("loggedInUser");
		if (customer == null) {
			return "redirect:/login";
		}
		Review review = new Review();
		Movie movie = daoMovie.findById(id);
		review.setMovie(movie);
		review.setCustomer(customer);
		model.addAttribute("review", review);
		log.debug("review = {}", review);
		return "add-review";
	}

	@RequestMapping(method = RequestMethod.POST, path = "/add-review")
	public String handleReview(@ModelAttribute("review") Review review, HttpSession session) throws DaoException {
		Customer customer = (Customer) session.getAttribute("loggedInUser");
		if (customer == null) {
			return "redirect:/login";
		}
		log.debug("in controller, review={}", review);
		review.setCustomer(customer);
		dao.addNewReview(review);
		return "redirect:/";
	}

	@RequestMapping(method = RequestMethod.GET, path = "/customer-review")
	public String showReview(HttpSession session, Model model) throws DaoException {
		Customer customer = (Customer) session.getAttribute("loggedInUser");
		if (customer == null) {
			return "redirect:/login";
		}
		Integer id = customer.getId();
		model.addAttribute("review", dao.findByCustomerId(id));
		return "customer-review";

	}

	@RequestMapping(method = RequestMethod.GET, path = "/view-review")
	public String viewReview(@RequestParam("movieId") Integer id, HttpSession session, Model model)
			throws DaoException {
		Customer customer = (Customer) session.getAttribute("loggedInUser");
		if (customer == null) {
			return "redirect:/login";
		}
		Movie movie = daoMovie.findById(id);
		model.addAttribute("review", dao.findByMovie(movie.getId()));
		return "view-review";

	}

	@RequestMapping("/delete-review")
	public String deleteShipper(@RequestParam("reviewId") Integer id, HttpSession session) throws DaoException {
		Customer customer = (Customer) session.getAttribute("loggedInUser");
		if (customer == null) {
			return "redirect:/login";
		}
		dao.deleteReview(id);
		return "redirect:/";
	}
}
