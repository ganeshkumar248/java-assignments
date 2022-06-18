package com.citiustech.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_movie_order_detail")
public class MovieOrderDetail {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String type;
	private double cost;
	private LocalDate orderDate;
	private LocalDate orderReturnDate;
	
	@ManyToOne
	@JoinColumn(name = "assigned_id")
	private MovieShopLink movieShopLink;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	public LocalDate getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(LocalDate orderDate) {
		this.orderDate = orderDate;
	}

	public LocalDate getOrderReturnDate() {
		return orderReturnDate;
	}

	public void setOrderReturnDate(LocalDate orderReturnDate) {
		this.orderReturnDate = orderReturnDate;
	}

	public MovieShopLink getMovieShopLink() {
		return movieShopLink;
	}

	public void setMovieShopLink(MovieShopLink movieShopLink) {
		this.movieShopLink = movieShopLink;
	}
	
}
