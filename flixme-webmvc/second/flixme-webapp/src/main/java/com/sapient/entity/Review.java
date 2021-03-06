package com.sapient.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;
import lombok.ToString;

@Data
@Entity
@Table(name="reviews")
@ToString(exclude = {"movie","customer"})
public class Review {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String description;
	private Double rating;
	
	@JoinColumn(name="movie_id")
	@ManyToOne
	private Movie movie;
	
	@JoinColumn(name="customer_id")
	@ManyToOne
	private Customer customer;
	
}
