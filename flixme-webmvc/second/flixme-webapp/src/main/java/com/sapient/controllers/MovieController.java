package com.sapient.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.sapient.dao.CustomerDao;
import com.sapient.dao.DaoException;
import com.sapient.dao.MovieDao;
import com.sapient.entity.Customer;
import com.sapient.entity.Movie;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class MovieController {
	@Autowired
	private MovieDao movieDao;

	@RequestMapping(method = RequestMethod.GET, path = "/movie")
	public String getMovieForm(Model model,HttpSession session) {
		Customer customer = (Customer) session.getAttribute("loggedInUser");
		if (customer == null) {
			return "redirect:/login";
		}
		Movie movie = new Movie();
		model.addAttribute("mov", movie);
		log.debug("movie = {}", movie);
		return "add-movie";
	}

	@RequestMapping(method = RequestMethod.POST, path = "/movie")
	public String handleMovie(@ModelAttribute("mov") Movie movie, HttpSession session) throws DaoException {
		Customer customer = (Customer) session.getAttribute("loggedInUser");
		if (customer == null) {
			return "redirect:/login";
		}
		log.debug("movie = {}", movie);
		movieDao.addNewMovie(movie);
		return "redirect:/";
	}

	@RequestMapping(method = RequestMethod.GET, path = "/all-movies")
	public String getAllMovies(Model model, HttpSession session) throws DaoException {
		Customer customer = (Customer) session.getAttribute("loggedInUser");
		if (customer == null) {
			return "redirect:/login";
		}
		model.addAttribute("movies", movieDao.findAll());
		return "all-movies";
	}

	@RequestMapping(method = RequestMethod.GET, path = "/movie-details")
	public String getMovieById(@RequestParam Integer id, Model model, HttpSession session) throws DaoException {
		Customer customer = (Customer) session.getAttribute("loggedInUser");
		if (customer == null) {
			return "redirect:/login";
		}
		model.addAttribute("sh", movieDao.findById(id));
		return "movie-details";
	}

	@RequestMapping(method = RequestMethod.GET, path = "/search-by-title")
	public String searchMovieForm(HttpSession session) {
		Customer customer = (Customer) session.getAttribute("loggedInUser");
		if (customer == null) {
			return "redirect:/login";
		}
		return "search-by-title";
	}

	@RequestMapping(method = RequestMethod.POST, path = "/search-by-title")
	public String searchMovie(@RequestParam String title, Model model, HttpSession session) throws DaoException {
		Customer customer = (Customer) session.getAttribute("loggedInUser");
		if (customer == null) {
			return "redirect:/login";
		}
		model.addAttribute("sh", movieDao.findByTitle(title));

		return "movie-details";
	}

	@RequestMapping(method = RequestMethod.GET, path = "/search-by-genre")
	public String searchMovieFormGerne(HttpSession session ) {
		Customer customer = (Customer) session.getAttribute("loggedInUser");
		if (customer == null) {
			return "redirect:/login";
		}
		return "search-by-genre";
	}

	@RequestMapping(method = RequestMethod.POST, path = "/search-by-genre")
	public String searchMovieGerne(@RequestParam String genre, Model model, HttpSession session) throws DaoException {
		Customer customer = (Customer) session.getAttribute("loggedInUser");
		if (customer == null) {
			return "redirect:/login";
		}
		model.addAttribute("sh", movieDao.findByGenre(genre));

		return "movie-details-list";
	}

	@RequestMapping(method = RequestMethod.GET, path = "/edit-movie")
	public String editProfileForm(@RequestParam("movieId") Integer id, Model model, HttpSession session)
			throws DaoException {
		Customer customer = (Customer) session.getAttribute("loggedInUser");
		if (customer == null) {
			return "redirect:/login";
		}
		Movie movie = movieDao.findById(id);
		model.addAttribute("movie", movie);

		return "edit-movie";
	}

	@RequestMapping(method = RequestMethod.POST, path = "/edit-movie")
	public String editProfile(@ModelAttribute("movie") Movie movie, HttpSession session) throws DaoException {
		Customer customer = (Customer) session.getAttribute("loggedInUser");
		if (customer == null) {
			return "redirect:/login";
		}
		movieDao.updateMovie(movie);

		return "redirect:/";

	}
	@RequestMapping("/delete-movie")
	public String deleteMovie(@RequestParam("movieId") Integer id, HttpSession session) throws DaoException {
		Customer customer = (Customer) session.getAttribute("loggedInUser");
		if (customer == null) {
			return "redirect:/login";
		}
		movieDao.delete(id);
		return "redirect:/all-movies";
	}

}
