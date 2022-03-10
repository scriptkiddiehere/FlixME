package com.sapient.flixme.dao;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import com.sapient.flixme.entity.Admin;

public class AdminDaoHashMapImpl implements AdminDao{

    private Map<Integer, Admin> aData = new HashMap<>();

    public AdminDaoHashMapImpl() {
        Admin a = new Admin();
        a.setId(1);
        a.setName("admin");
        a.setEmail("admin");
        a.setPassword("password");
        a.setPhone("9878765763");
        aData.put(1, a);

    }

    @Override
    public Admin findByEmail(String email) throws DaoException {
        Collection<Admin> admin = aData.values();
		Iterator<Admin> it = admin.iterator();
		while(it.hasNext()) {
			Admin a=it.next();
			if(a.getEmail().equals(email)) {
				return a;
			}
		}
		return null;
    }

    @Override
    public Admin getProfile(int id) throws DaoException {
        if (aData.containsKey(id)) {
			return aData.get(id);
		}
		throw new DaoException("No matching record found for id " + id);
    }

    @Override
    public void updateProfile(Admin admin) throws DaoException {
        int id = admin.getId();
		if (aData.containsKey(id)) {
			aData.put(id, admin);
		} else {
            throw new DaoException("No matching record found for id " + id);
        }
    }
    
}
