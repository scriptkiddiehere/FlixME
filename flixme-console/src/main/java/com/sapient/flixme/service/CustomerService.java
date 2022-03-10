package com.sapient.flixme.service;

import java.util.List;

import com.sapient.flixme.dao.CustomerDao;
import com.sapient.flixme.dao.CustomerDaoHashMapImpl;
import com.sapient.flixme.dao.DaoException;
import com.sapient.flixme.entity.Customer;
import com.sapient.flixme.util.KeyboardUtil;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CustomerService {

	private CustomerDao dao = new CustomerDaoHashMapImpl();

	public Customer login(String email, String password) throws ServiceException {
		try {
			Customer c = dao.findByEmail(email);
			if (c == null) {
				throw new ServiceException("Invalid email/password");
			}
			if (c.getPassword().equals(password)) {
				return c;
			} else {
				throw new ServiceException("Invalid email/password");
			}

		} catch (DaoException e) {
			log.warn("Exception while calling login", e);
			throw new ServiceException(e);
		}
	}

	public void selfRegistration() throws ServiceException {
		try {
			Customer c = new Customer();
			String name = KeyboardUtil.getString("Enter full name: ");
			if (!(name.isEmpty())) {
				c.setName(name);
			}
			String email = KeyboardUtil.getString("Enter email: ");
			if (!(email.isEmpty())) {
				c.setEmail(email);
			}
			String password = KeyboardUtil.getPassword("Enter password: ");
			if (!(password.isEmpty())) {
				c.setPassword(password);
			}
			String phone = KeyboardUtil.getPassword("Enter phone number: ");
			if (!(phone.isEmpty())) {
				c.setPhone(phone);
			}
			String street = KeyboardUtil.getString("Enter street: ");
			if (!(street.isEmpty())) {
				c.setStreet(street);
			}
			String city = KeyboardUtil.getString("Enter city: ");
			if (!(city.isEmpty())) {
				c.setCity(city);
			}
			String state = KeyboardUtil.getString("Enter state: ");
			if (!(state.isEmpty())) {
				c.setState(state);
			}
			String pincode = KeyboardUtil.getString("Enter pincode: ");
			if (!(pincode.isEmpty())) {
				c.setPincode(Integer.parseInt(pincode));
			}
			String country = KeyboardUtil.getString("Enter country: ");
			if (!country.isEmpty()) {
				c.setCountry(country);
			}
			double balance = KeyboardUtil.getDouble("Enter balance: ");
			c.setBalance(balance);

			dao.addNewCustomer(c);
			System.out.println("Registered Successfully!");
		} catch (DaoException e) {
			log.warn("Exception while creating customer", e);
			throw new ServiceException();
		}

	}

	public void viewProfile(Customer c) {
		System.out.println("\n\n----------CUSTOMER DETAILS----------");
		System.out.println("ID: " + c.getId());
		System.out.println("Name: " + c.getName());
		System.out.println("Email: " + c.getEmail());
		System.out.println("Phone: " + c.getPhone());
		System.out.println("Balance: " + c.getBalance());
		System.out.println("Street: " + c.getStreet());
		System.out.println("City: " + c.getCity());
		System.out.println("State: " + c.getState());
		System.out.println("Country: " + c.getCountry());
		System.out.println("Pincode: " + c.getPincode());
	}

	public void updateProfile(Customer c) throws ServiceException {
		viewProfile(c);
		try {
			String input;
			input = KeyboardUtil.getString(String.format("Enter Name: (%s)", c.getName()));
			if (input.trim().length() != 0) {
				c.setName(input);
			}

			input = KeyboardUtil.getString(String.format("Enter email: (%s)", c.getEmail()));
			if (input.trim().length() != 0) {
				c.setEmail(input);
			}

			input = KeyboardUtil.getString(String.format("Enter phone: (%s)", c.getPhone()));
			if (input.trim().length() != 0) {
				c.setPhone(input);
			}

			input = KeyboardUtil.getString(String.format("Enter street: (%s)", c.getStreet()));
			if (input.trim().length() != 0) {
				c.setStreet(input);
			}

			input = KeyboardUtil.getString(String.format("Enter city: (%s)", c.getCity()));
			if (input.trim().length() != 0) {
				c.setCity(input);
			}

			input = KeyboardUtil.getString(String.format("Enter state: (%s)", c.getState()));
			if (input.trim().length() != 0) {
				c.setState(input);
			}

			input = KeyboardUtil.getString(String.format("Enter pincode: (%s)", c.getPincode()));
			if (input.trim().length() != 0) {
				c.setPincode(Integer.parseInt(input));
			}

			input = KeyboardUtil.getString(String.format("Enter country: (%s)", c.getCountry()));
			if (input.trim().length() != 0) {
				c.setCountry(input);
			}
			dao.updateCustomer(c);
			System.out.println("Profile Updated Successfully!");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public void changePassword(Customer c) {
		String oldPassword = KeyboardUtil.getString("Enter old password: ");
		if (oldPassword.equals(c.getPassword())) {
			String newPassword = KeyboardUtil.getString("Enter new password: ");
			String newPassword2 = KeyboardUtil.getString("Confirm new password: ");
			if (newPassword.equals(newPassword2)) {
				c.setPassword(newPassword);
				System.out.println("Password changed successfully");
			} else {
				System.out.println("Password does not match");
			}
		} else {
			System.out.println("Wrong password !! Enter right password to reset ");
		}
	}

	public void viewBalance(Customer c) {
		System.out.println("Your current balance: " + c.getBalance());
	}

	public void updateBalance(Customer c) {
		System.out.println("Your current balance: " + c.getBalance());
		Double balance = KeyboardUtil.getDouble("Enter amount: ");
		if (balance == 0) {
			System.out.println("Enter a valid amount  ");
		} else {
			c.setBalance(c.getBalance() + balance);
			System.out.println("New balance: " + c.getBalance());
		}
	}

	public void allCustomer() {
		try {
			List<Customer> list = dao.findAll();
			System.out.printf("%4s %-20s %-20s %-20s\n",
					"ID", "Name", "Email", "Phone");
			System.out.println(
					"-------------------------------------------------------------------------------------------------");
			list.forEach(this::printCustomer);
			System.out.println(
					"-------------------------------------------------------------------------------------------------");
		} catch (DaoException e) {

		}
	}

	void printCustomer(Customer c) {
		System.out.printf("%4d %-20s %-20s %-20s\n",
				c.getId(),
				c.getName(),
				c.getEmail(),
				c.getPhone());
	}
}
