package com.sapient.flixme.entity;

import java.util.List;

import lombok.Data;

@Data
public class Customer {
    private Integer id;
    private String name;
    private String email;
    private String password;
    private String phone;
    private String street = " ";
    private String city = " ";
    private String state = " ";
    private int pincode = 000000;
    private String country = " ";
    private double balance = 0;
    private List<Review> reviews;
}
