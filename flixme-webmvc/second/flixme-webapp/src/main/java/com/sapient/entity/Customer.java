package com.sapient.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="customers")
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String name;
	@Column(unique = true)
	private Integer is_Admin;
	private String email;
	private String password;
	private String street;
	private String city;
	private String state;
	private String pincode;
	private String country;
	private Double balance;
	
	 @OneToMany(mappedBy="customer")
	   private List<Review> reviews;
	 
}
