package com.sapient.controllers;

import com.sapient.dao.ReviewDao;
import com.sapient.entity.Review;
import com.sapient.vob.UserVob;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Slf4j
@RestController
@RequestMapping("/api/reviews")
public class ReviewController {

    @Autowired
    ReviewDao dao;

    @PostMapping("/addReview")
    public @ResponseBody String addNewMovie (@RequestBody Review review) {
        dao.save(review);
        return "Added Successfully";
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getOne(
            @RequestAttribute(required = false, name = "user") UserVob userVob,
            @PathVariable Integer id){

        Map<String, Object> map = new HashMap<>();
        log.debug("userVob in ProductController.getOne() is {}", userVob);
        if(userVob==null){
            map.put("message", "Please login to access this resource");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(map);
        }

        map.put("status", 200);
        map.put("content", dao.findById(id));

        return ResponseEntity.ok(map);
    }

    @GetMapping("/delete/{id}")
    public ResponseEntity<Object> deleteOne(
            @RequestAttribute(required = false, name = "user") UserVob userVob,
            @PathVariable Integer id){

        Map<String, Object> map = new HashMap<>();
        log.debug("userVob in ProductController.getOne() is {}", userVob);
        if(userVob==null){
            map.put("message", "Please login to access this resource");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(map);
        }

        map.put("status", 200);
        dao.deleteById(id);

        return ResponseEntity.ok(map);
    }

    @GetMapping
    public ResponseEntity<Object> getAll(@RequestAttribute(required = false, name = "user") UserVob userVob) {

        Map<String, Object> map = new HashMap<>();

        if(userVob==null){
            map.put("message", "Please login to access this resource");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(map);
        }
        map.put("status", 200);
        map.put("content", dao.findAll());

        return ResponseEntity.ok(map);
    }

    @GetMapping("/userId/{userId}")
    public ResponseEntity<Object> getUserId(
            @RequestAttribute(required = false, name = "user") UserVob userVob,
            @PathVariable Integer userId){

        Map<String, Object> map = new HashMap<>();
        log.debug("userVob in ProductController.getOne() is {}", userVob);
        if(userVob==null){
            map.put("message", "Please login to access this resource");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(map);
        }

        map.put("status", 200);
        map.put("content", dao.findByUserId(userId));

        return ResponseEntity.ok(map);
    }

    @GetMapping("movieId/{movieId}")
    public ResponseEntity<Object> getMovieId(
            @RequestAttribute(required = false, name = "user") UserVob userVob,
            @PathVariable Integer movieId){

        Map<String, Object> map = new HashMap<>();
        log.debug("userVob in ProductController.getOne() is {}", userVob);
        if(userVob==null){
            map.put("message", "Please login to access this resource");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(map);
        }

        map.put("status", 200);
        map.put("content", dao.findByMovieId(movieId));

        return ResponseEntity.ok(map);
    }

    @GetMapping("movieName/{movieName}")
    public ResponseEntity<Object> getMovieName(
            @RequestAttribute(required = false, name = "user") UserVob userVob,
            @PathVariable String movieName){

        Map<String, Object> map = new HashMap<>();
        log.debug("userVob in ProductController.getOne() is {}", userVob);
        if(userVob==null){
            map.put("message", "Please login to access this resource");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(map);
        }

        map.put("status", 200);
        map.put("content", dao.findByMovieName(movieName));

        return ResponseEntity.ok(map);
    }
}
