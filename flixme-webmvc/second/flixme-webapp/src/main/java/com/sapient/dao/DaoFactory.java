package com.sapient.dao;

public final class DaoFactory {

	private DaoFactory() {
	}
	
	public static CustomerDao getCustomerDao() {
		return new CustomerDaoHibernateTemplateImpl();
	}

}
