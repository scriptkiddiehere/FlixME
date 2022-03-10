package com.sapient.controllers;

import com.sapient.dao.MovieDao;
import com.sapient.entity.Movie;
import com.sapient.vob.UserVob;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/api/movies")
public class MovieController {

    @Autowired
    MovieDao dao;

    @PostMapping("/addMovie")
    public @ResponseBody String addNewMovie (@RequestBody Movie movie) {
        dao.save(movie);
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

    @GetMapping("/name/{name}")
    public ResponseEntity<Object> getName(
            @RequestAttribute(required = false, name = "user") UserVob userVob,
            @PathVariable String name){

        Map<String, Object> map = new HashMap<>();
        log.debug("userVob in ProductController.getOne() is {}", userVob);
        if(userVob==null){
            map.put("message", "Please login to access this resource");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(map);
        }

        map.put("status", 200);
        map.put("content", dao.findByName(name));

        return ResponseEntity.ok(map);
    }

    @GetMapping("/genre/{genre}")
    public ResponseEntity<Object> getGenre(
            @RequestAttribute(required = false, name = "user") UserVob userVob,
            @PathVariable String genre){

        Map<String, Object> map = new HashMap<>();
        log.debug("userVob in ProductController.getOne() is {}", userVob);
        if(userVob==null){
            map.put("message", "Please login to access this resource");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(map);
        }

        map.put("status", 200);
        map.put("content", dao.findByGenre(genre));

        return ResponseEntity.ok(map);
    }

    @GetMapping("/year/{releaseYear}")
    public ResponseEntity<Object> getYear(
            @RequestAttribute(required = false, name = "user") UserVob userVob,
            @PathVariable String releaseYear){

        Map<String, Object> map = new HashMap<>();
        log.debug("userVob in ProductController.getOne() is {}", userVob);
        if(userVob==null){
            map.put("message", "Please login to access this resource");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(map);
        }

        map.put("status", 200);
        map.put("content", dao.findByReleaseYear(releaseYear));

        return ResponseEntity.ok(map);
    }

    @GetMapping("/duration/{duration}")
    public ResponseEntity<Object> getDuration(
            @RequestAttribute(required = false, name = "user") UserVob userVob,
            @PathVariable String duration){

        Map<String, Object> map = new HashMap<>();
        log.debug("userVob in ProductController.getOne() is {}", userVob);
        if(userVob==null){
            map.put("message", "Please login to access this resource");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(map);
        }

        map.put("status", 200);
        map.put("content", dao.findByDuration(duration));

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
}
