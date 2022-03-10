package com.sapient;

import com.sapient.dao.UserDao;
import com.sapient.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserDao dao;

    public User login(String email, String password) {
        Optional<User> result = dao.findByEmail(email);
        if(result.isPresent()){
            User user= result.get();
            if(user.getPassword().equals(password)){
                return user;
            }
        }
        throw new RuntimeException("Invalid username/password");

    }
}
