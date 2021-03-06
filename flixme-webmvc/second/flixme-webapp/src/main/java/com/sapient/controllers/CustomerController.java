package com.sapient.controllers;

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
public class CustomerController {
	@Autowired
	private CustomerDao dao;
	private MovieDao movieDao;

	@RequestMapping(method = RequestMethod.GET, path = "/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/login";
	}

	@RequestMapping(method = RequestMethod.GET, path = "/login")
	public String getLoginForm() {
		return "login-form";
	}

	@RequestMapping(method = RequestMethod.POST, path = "/login")
	public String handleLogin(@RequestParam String email, @RequestParam String password, HttpSession session,
			Model model) {
		try {
			Customer customer = dao.findByEmail(email);
			System.out.println(customer);
			if (customer.getPassword().equals(password)) {
				session.setAttribute("loggedInUser", customer);
				model.addAttribute("customer", dao.findByEmail(email));
				return "redirect:/";
			}
			model.addAttribute("errmesg", "Ivalid username/password");
			return "login-form";

		} catch (DaoException e) {
			model.addAttribute("errmesg", "Ivalid username/password");
			return "login-form";
		}

	}

	@RequestMapping(method = RequestMethod.GET, path = "/register")
	public String getRegistrationForm(Model model) {
		model.addAttribute("cust", new Customer());
		return "registration-form";
	}

	@RequestMapping(method = RequestMethod.POST, path = "/register")
	public String handleRegistration(@ModelAttribute("cust") Customer customer, HttpSession session)
			throws DaoException {
		dao.addNewCustomer(customer);
		session.setAttribute("loggedInUser", customer);
		return "redirect:/";
	}

	@RequestMapping(method = RequestMethod.GET, path = "/check-balance")
	public String checkBalancee(HttpSession session) {
		Customer customer = (Customer) session.getAttribute("loggedInUser");
		if (customer == null) {
			return "redirect:/login";
		}
		return "check-balance";
	}

	@RequestMapping(method = RequestMethod.GET, path = "/edit-balance")
	public String updateBalanceForm(HttpSession session) throws DaoException {
		Customer customer = (Customer) session.getAttribute("loggedInUser");
		if (customer == null) {
			return "redirect:/login";
		}
		return "edit-balance";
	}

	@RequestMapping(method = RequestMethod.POST, path = "/edit-balance")
	public String updateBalance(@RequestParam Double balance, HttpSession session) throws DaoException {
		Customer customer = (Customer) session.getAttribute("loggedInUser");
		if (customer == null) {
			return "redirect:/login";
		}
		customer.setBalance(balance);
		dao.updateCustomer(customer);
		session.setAttribute("loggedInUser", customer);
		return "redirect:/";
	}

	@RequestMapping(method = RequestMethod.GET, path = "/view-profile")
	public String viewProfile(HttpSession session) throws DaoException {
		Customer customer = (Customer) session.getAttribute("loggedInUser");
		if (customer == null) {
			return "redirect:/login";
		}
		return "view-profile";
	}

	@RequestMapping(method = RequestMethod.GET, path = "/edit-profile")
	public String editProfileForm(Model model, HttpSession session) {
		Customer customer = (Customer) session.getAttribute("loggedInUser");
		if (customer == null) {
			return "redirect:/login";
		}
		model.addAttribute("cust", customer);

		return "edit-profile";
	}

	@RequestMapping(method = RequestMethod.POST, path = "/edit-profile")
	public String editProfile(@ModelAttribute("cust") Customer customer, HttpSession session) throws DaoException {
		Customer c = (Customer) session.getAttribute("loggedInUser");
		if (customer == null) {
			return "redirect:/login";
		}
		customer.setPassword(c.getPassword());
		customer.setBalance(c.getBalance());
		customer.setIs_Admin(c.getIs_Admin());
		dao.updateCustomer(customer);
		session.setAttribute("loggedInUser", customer);
		return "redirect:/view-profile";

	}

	@RequestMapping(method = RequestMethod.GET, path = "/edit-password")
	public String editPasswordForm(Model model, HttpSession session) {
		Customer customer = (Customer) session.getAttribute("loggedInUser");
		if (customer == null) {
			return "redirect:/login";
		}
		return "edit-password";
	}

	@RequestMapping(method = RequestMethod.POST, path = "/edit-password")
	public String editPassword(@RequestParam String password, HttpSession session) throws DaoException {
		Customer customer = (Customer) session.getAttribute("loggedInUser");
		if (customer == null) {
			return "redirect:/login";
		}
		customer.setPassword(password);
		dao.updateCustomer(customer);
		session.setAttribute("loggedInUser", customer);
		return "redirect:/";
	}
	@RequestMapping(method=RequestMethod.GET, path="/all-user")
	public String allUser(HttpSession session, Model model) throws DaoException {
		Customer customer = (Customer) session.getAttribute("loggedInUser");
		if (customer == null) {
			return "redirect:/login";
		}
		model.addAttribute("user",dao.findAll());
		return "all-user";
	}
	@RequestMapping(method = RequestMethod.GET, path = "/user-details")
	public String getMovieById(@RequestParam Integer id, Model model, HttpSession session) throws DaoException {
		Customer customer = (Customer) session.getAttribute("loggedInUser");
		if (customer == null) {
			return "redirect:/login";
		}
		model.addAttribute("sh", dao.findById(id));
		return "user-details";
	}
	

}
