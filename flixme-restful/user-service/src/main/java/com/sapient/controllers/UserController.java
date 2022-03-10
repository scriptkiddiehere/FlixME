package com.sapient.controllers;

import com.sapient.UserService;
import com.sapient.dao.UserDao;
import com.sapient.entity.User;
import com.sapient.utils.JwtUtil;
import com.sapient.vob.UserVob;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    UserService service;

    @Autowired
    UserDao dao;

    @Autowired
    JwtUtil jwtUtil;

    @GetMapping("/all")
    public Iterable<User> getAllUser() {
        return dao.findAll();
    }

    @PostMapping("/addNew")
    public @ResponseBody String addNewUser(@RequestBody User user) {
        dao.save(user);
        return "User Created Successfully";
    }

    @GetMapping("/verify")
    public ResponseEntity<Object> handleVerifyGet(@RequestParam String token) {
        Map<String, Object> map = new HashMap<>();
        try {
            Map<String, Object> payload = jwtUtil.verify(token);
            map.put("status", 200);
            map.put("payload", payload);
            return ResponseEntity.ok(map);
        }
        catch(Exception ex){
            map.put("status", 401);
            map.put("message", ex.getMessage());
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(map);
        }
    }

    @PostMapping("/login")
    public ResponseEntity<Object> handleLoginPost(@RequestBody UserVob userVob) {
        Map<String, Object> map = new HashMap<>();
        try {
            User user = service.login(userVob.getEmail(), userVob.getPassword());
            map.put("status", 200);
            map.put("id", user.getId());
            map.put("name", user.getName());
            map.put("token", jwtUtil.createToken(user.getId(), user.getName(), user.getEmail()));

            return ResponseEntity.ok(map);

        }
        catch(Exception ex){
            map.put("status", 401);
            map.put("message", ex.getMessage());
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(map);
        }
    }
}
