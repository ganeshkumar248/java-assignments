package com.citiustech.service;

import java.time.LocalDate;
import java.util.List;

import com.citiustech.dao.BlockBusterDao;
import com.citiustech.dao.GenericDao;
import com.citiustech.entity.Movie;
import com.citiustech.entity.MovieOrderDetail;
import com.citiustech.entity.MovieShopLink;
import com.citiustech.entity.Staff;

public class BlockBusterService {

	public void withdraw(int customer_id, int movie_id) {
		GenericDao dao = new GenericDao();
		Movie movie = dao.findById(Movie.class, movie_id);
		MovieShopLink link = dao.findById(MovieShopLink.class, movie.getMovie_id());
		link.setNoOfCopies(link.getNoOfCopies() - 1);
		dao.save(link);
		MovieOrderDetail details = new MovieOrderDetail();
		details.setType("issued");
		details.setOrderDate(LocalDate.of(2019, 6, 2));
		details.setOrderReturnDate(LocalDate.of(2019, 6, 4));
		details.setCost(200);
		dao.save(details);
	}

	public void returned(int customer_id, int movie_id) {
		GenericDao dao = new GenericDao();
		Movie movie = dao.findById(Movie.class, movie_id);
		MovieShopLink link = dao.findById(MovieShopLink.class, movie.getMovie_id());
		link.setNoOfCopies(link.getNoOfCopies() + 1);
		dao.save(link);
		MovieOrderDetail details = new MovieOrderDetail();
		details.setType("return");
		details.setOrderDate(LocalDate.of(2019, 2, 9));
		details.setOrderReturnDate(LocalDate.of(2019, 4, 11));
		details.setCost(400);
		dao.save(details);
	}

	public List<Staff> fetchStaffDetails(int staff_id) {
		BlockBusterDao dao = new BlockBusterDao();
		return dao.fetchStaffDetail(staff_id);

	}

	public List<String> fetchAllMovies() {
		BlockBusterDao dao = new BlockBusterDao();
		return dao.fetchMovies();
	}
}
