package com.sapient.flixme.service;

import java.util.List;

import com.sapient.flixme.dao.AdminDao;
import com.sapient.flixme.dao.AdminDaoHashMapImpl;
import com.sapient.flixme.dao.DaoException;
import com.sapient.flixme.dao.ReviewDao;
import com.sapient.flixme.dao.ReviewDaoHashMapImpl;
import com.sapient.flixme.entity.Admin;
import com.sapient.flixme.entity.Movie;
import com.sapient.flixme.entity.Review;
import com.sapient.flixme.util.KeyboardUtil;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class AdminService {

	private AdminDao dao = new AdminDaoHashMapImpl();
	private ReviewDao rdao = new ReviewDaoHashMapImpl();

	public Admin login(String email, String password) throws ServiceException {
		try {
			Admin a = dao.findByEmail(email);
			if (a == null) {
				throw new ServiceException("Invalid email/password");
			}
			if (a.getPassword().equals(password)) {
				return a;
			} else {
				throw new ServiceException("Invalid email/password");
			}

		} catch (DaoException e) {
			log.warn("Exception while calling login", e);
			throw new ServiceException(e);
		}
	}

	public void viewProfile(Admin admin) {
		System.out.println("\n\n**** PROFILE ****");
		System.out.println("ID: " + admin.getId());
		System.out.println("Name: " + admin.getName());
		System.out.println("Phone: " + admin.getPhone());
		System.out.println("Email: " + admin.getEmail());
		// System.out.println("Street: " + admin.getStreet());
		// System.out.println("City: " + admin.getCity());
		// System.out.println("State: " + admin.getState());
		// System.out.println("Country: " + admin.getCountry());
		// System.out.println("Pincode: " + admin.getPincode());
	}

	public void updateProfile(Admin admin) {
		try {
			String input;
			input = KeyboardUtil.getString(String.format("Enter Name: (%s)", admin.getName()));
			if (input.trim().length() != 0) {
				admin.setName(input);
			}
			input = KeyboardUtil.getString(String.format("Enter email: (%s)", admin.getEmail()));
			if (input.trim().length() != 0) {
				admin.setEmail(input);
			}
			input = KeyboardUtil.getString(String.format("Enter phone: (%s)", admin.getPhone()));
			if (input.trim().length() != 0) {
				admin.setPhone(input);
			}
			input = KeyboardUtil.getString(String.format("Enter street: (%s)", admin.getStreet()));
			if (input.trim().length() != 0) {
				admin.setStreet(input);
			}
			input = KeyboardUtil.getString(String.format("Enter city: (%s)", admin.getCity()));
			if (input.trim().length() != 0) {
				admin.setCity(input);
			}
			input = KeyboardUtil.getString(String.format("Enter state: (%s)", admin.getState()));
			if (input.trim().length() != 0) {
				admin.setState(input);
			}
			input = KeyboardUtil.getString(String.format("Enter pincode: (%s)", admin.getPincode()));
			if (input.trim().length() != 0) {
				admin.setPincode(Integer.parseInt(input));
			}
			input = KeyboardUtil.getString(String.format("Enter country: (%s)", admin.getCountry()));
			if (input.trim().length() != 0) {
				admin.setCountry(input);
			}
			dao.updateProfile(admin);
			System.out.println("Profile Updated Successfully!");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public void viewReviewAll() {
			List<Review> r = rdao.findAll();
			System.out.printf("%10s %10s %-20s %-20s %-20s\n",
					"Review_id", "Movie_id", "Movie Name", "Customer Name", "Review");
			System.out.println(
					"-------------------------------------------------------------------------------------------------");
			r.stream().forEach(this::printReview);
			System.out.println(
					"-------------------------------------------------------------------------------------------------");
	}

	public void deleteReview() {
		int id = KeyboardUtil.getInt("Enter id of review you want to delete: ");
		rdao.deleteReview(id);
	}

	public void changePassword(Admin a) {
		String oldPassword = KeyboardUtil.getString("Enter old password: ");
		if (oldPassword.equals(a.getPassword())) {
			String newPassword = KeyboardUtil.getString("Enter new password: ");
			String newPassword2 = KeyboardUtil.getString("Confirm new password: ");
			if (newPassword.equals(newPassword2)) {
				a.setPassword(newPassword);
				System.out.println("Password changed successfully");
			} else {
				System.out.println("Password does not match");
			}
		} else {
			System.out.println("Wrong password!! Enter right password to reset ");
		}
	}

	void printReview(Review r) {
		System.out.printf("%10d %10d %-20s %-20s %-20s\n",
				r.getReviewId(),
				r.getMovieId(),
				r.getMovieName(),
				r.getCustomerName(),
				r.getReview());
	}

}
