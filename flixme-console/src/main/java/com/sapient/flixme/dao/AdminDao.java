package com.sapient.flixme.dao;

import com.sapient.flixme.entity.Admin;

public interface AdminDao {

    public Admin getProfile(int id) throws DaoException;

    public void updateProfile(Admin admin) throws DaoException;

    public Admin findByEmail(String email) throws DaoException;
}
