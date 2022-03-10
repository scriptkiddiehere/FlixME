package com.sapient;

import com.sapient.flixme.entity.Admin;
import com.sapient.flixme.entity.Customer;
import com.sapient.flixme.service.AdminService;
import com.sapient.flixme.service.CustomerService;
import com.sapient.flixme.service.MovieService;
import com.sapient.flixme.service.ServiceException;
import com.sapient.flixme.util.KeyboardUtil;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class App {

	CustomerService customerService = new CustomerService();
	AdminService adminService = new AdminService();
	MovieService movieService = new MovieService();
	Customer loggedInCustomer = null;
	Admin loggedInAdmin = null;

	public void start() {
		System.out.println("Welcome to Flixme review/rating system\n");
		int choice;
		while ((choice = mainMenu()) != 0) {
			switch (choice) {
				case 1:
					customerLogin();
					break;
				case 2:
					try {
						customerService.selfRegistration();
					} catch (ServiceException e) {
						log.warn("Exception while calling selfRegistration", e);
					} catch (NumberFormatException e){
						System.out.println("Please enter valid pincode(In numbers)!");
					}
					break;
				case 3:
					adminLogin();
					break;
				default:
					System.out.println("Invalid choice. Please retry.");

			}

		}
	}

	void adminLogin() {
		try {
			String email = KeyboardUtil.getString("Enter email: ");
			String password = KeyboardUtil.getPassword("Enter password: ");

			loggedInAdmin = adminService.login(email, password);
			System.out.println("Login succeeded");

			int choice;

			while ((choice = adminMenu()) != 0) {
				switch (choice) {
					case 1:
						adminService.viewProfile(loggedInAdmin);
						break;
					case 2:
						adminService.updateProfile(loggedInAdmin);
						break;
					case 3:
						movieService.addMovie();
						break;
					case 4:
						movieService.updateMovie();
						break;
					case 5:
						movieService.allMovie();
						break;
					case 6:
						customerService.allCustomer();
						break;
					case 7:
						adminService.viewReviewAll();
						break;
					case 8:
						adminService.deleteReview();
						break;
					case 9:
						adminService.changePassword(loggedInAdmin);
						break;
					default:
						System.out.println("Invalid choice. Please retry.");

				}
			}

		} catch (Exception ex) {
			log.warn("Exception while calling customerLogin", ex);
			System.out.println("Couldn't login");
			System.out.println(ex.getMessage());
		}
	}

	void customerLogin() {
		try {
			String email = KeyboardUtil.getString("Enter email: ");
			String password = KeyboardUtil.getPassword("Enter password: ");

			loggedInCustomer = customerService.login(email, password);
			System.out.println("Logged In Successfully!");
			int choice;

			while ((choice = customerMenu()) != 0) {
				switch (choice) {
					case 1:
						customerService.viewProfile(loggedInCustomer);
						break;
					case 2:
						customerService.updateProfile(loggedInCustomer);
						break;
					case 3:
						customerService.changePassword(loggedInCustomer);
						break;
					case 4:
						customerService.viewBalance(loggedInCustomer);
						break;
					case 5:
						customerService.updateBalance(loggedInCustomer);
						break;
					case 6:
						movieService.searchByTitle();
						break;
					case 7:
						movieService.searchByOther();
						break;
					case 8:
						movieService.enterReview(loggedInCustomer);
						break;
					case 9:
						movieService.viewMyReview(loggedInCustomer);
						break;
					// case 10:
					// 	movieService.editReview(loggedInCustomer);
					// 	break;
					default:
						System.out.println("Invalid choice. Please retry.");
				}
			}

		} catch (Exception ex) {
			log.warn("Exception while calling customerLogin", ex);
			System.out.println("Couldn't login");
			System.out.println(ex.getMessage());
		}

	}

	int mainMenu() {
		try {
			System.out.println("1. Customer login");
			System.out.println("2. Customer self registration");
			System.out.println("3. Admin login");
			System.out.println("0. Exit");

			return KeyboardUtil.getInt("Enter your choice: ");

		} catch (Exception e) {
			log.warn("Error while accepting choice for mainMenu", e);
			return -1;
		}

	}

	int adminMenu() {
		System.out.println("Welcome " + loggedInAdmin.getName());
		try {
			System.out.println("1. View profile");
			System.out.println("2. Edit profile");
			System.out.println("3. Add New Movie");
			System.out.println("4. Update Movie");
			System.out.println("5. Show All Movies");
			System.out.println("6. Show All Customers");
			System.out.println("7. View Reviews");
			System.out.println("8. Delete Reviews");
			System.out.println("9. Change Password");
			System.out.println("0. Exit");

			return KeyboardUtil.getInt("Enter your choice: ");

		} catch (Exception e) {
			log.warn("There was an error while accepting choice for admin menu", e);
			return -1;
		}
	}

	int customerMenu() {
		System.out.println("Welcome " + loggedInCustomer.getName());
		try {
			System.out.println("1. View profile");
			System.out.println("2. Edit profile");
			System.out.println("3. Change Password");
			System.out.println("4. View balance");
			System.out.println("5. Update Balance");
			System.out.println("6. Search movies by title");
			System.out.println("7. Search movies by other parameters");
			System.out.println("8. Write a review");
			System.out.println("9. View my reviews");
			// System.out.println("10. Edit a review");
			System.out.println("0. Exit");

			return KeyboardUtil.getInt("Enter your choice: ");
		} catch (Exception e) {
			log.warn("There was an error while accepting choice for main menu", e);
			return -1;
		}
	}

	public static void main(String[] args) {

		new App().start();

	}

}
