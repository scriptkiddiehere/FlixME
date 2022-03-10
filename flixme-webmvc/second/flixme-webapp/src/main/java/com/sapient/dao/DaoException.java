package com.sapient.dao;

public class DaoException extends Exception {

	private static final long serialVersionUID = 8610158096515794750L;

	public DaoException() {
	}

	public DaoException(String message) {
		super(message);
	}

	public DaoException(Throwable cause) {
		super(cause);
	}

}
