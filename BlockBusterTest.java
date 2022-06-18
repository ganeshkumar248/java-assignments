package com.citiustech.test;

import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.citiustech.dao.GenericDao;
import com.citiustech.entity.Address;
import com.citiustech.entity.Customer;
import com.citiustech.entity.Manager;
import com.citiustech.entity.Movie;
import com.citiustech.entity.MovieShopLink;
import com.citiustech.entity.MovieSubscription;
import com.citiustech.entity.Shop;
import com.citiustech.entity.Staff;
import com.citiustech.service.BlockBusterService;

public class BlockBusterTest {
	
	@Test
	public void addAddress() {
		Address a = new Address();
		a.setCity("Mumbai");
		a.setPincode(56789);
		a.setState("Maharashrta");
		
		GenericDao dao = new GenericDao();
		dao.save(a);
	}
	
	@Test
	public void addManager() {
		Manager m = new Manager();
		m.setName("Kaka");
		
		GenericDao dao = new GenericDao();
		dao.save(m);
	}

	@Test
	public void addShop() {
		Shop s = new Shop();
		s.setLocation("Mumbai");
		s.setFirstAhiftStaffMember("Finch");
		s.setSecondShiftStaffMember("David");
		
		GenericDao dao =  new GenericDao();
		dao.save(s);
	}
	
	@Test
	public void addStaff() {
		GenericDao dao =  new GenericDao();
		Staff s = new Staff();
		s.setName("Smith");
		s.setShift("1st shift");
		dao.save(s);
	}
	
	@Test
	public void addManagerAndStaffToShop() {
		GenericDao dao = new GenericDao();
		Shop s = dao.findById(Shop.class, 1);
		Manager m = dao.findById(Manager.class, 1);
		Staff st = dao.findById(Staff.class, 1);
		s.setManager(m);
		s.setStaff(st);
		dao.save(s);
	}
	
	
	@Test
	public void addMovie() {
		GenericDao dao =  new GenericDao();
		Movie movie = new Movie();
		movie.setName("RRR");
		movie.setGenre("Action");
		dao.save(movie);
	}
	
	@Test
	public void assignsMovieToShop() {
		GenericDao dao =  new GenericDao();
		Shop shop = dao.findById(Shop.class, 1);
		Movie movie = dao.findById(Movie.class, 1);
		MovieShopLink link = new MovieShopLink();
		link.setMovie(movie);
		link.setShop(shop);
		link.setNoOfCopies(5);
		link.setDate(LocalDate.of(2019, 2, 4));
		dao.save(link);
	}
	
	@Test
	public void registerCustomer() {
		GenericDao dao =  new GenericDao();
		Address a = dao.findById(Address.class, 1);
		Customer c = new Customer();
		c.setName("Munna Bhai");
		c.setDob(LocalDate.of(1998, 6, 15));
		c.setMembershipNumber(12345678987L);
		c.setAddress(a);
		dao.save(c);
	}
	
	@Test
	public void movieIssue() {
		GenericDao dao =  new GenericDao();
		Movie movie = dao.findById(Movie.class, 3);
		Customer customer = dao.findById(Customer.class, 3);
		MovieSubscription subs = new MovieSubscription();
		subs.setCustomer(customer);
		subs.setMovie(movie);
		subs.setSubscriptionDate(LocalDate.of(2019, 2, 6));
		subs.setReturnDate(LocalDate.of(2019, 2, 7));
		subs.setSubscriptionValidityInDays(1);
		subs.setCost(399);
		dao.save(subs);
	}
	
	@Test
	public void withdraw() {
		BlockBusterService service = new BlockBusterService();
		service.withdraw(2, 2);
	}
	
	@Test
	public void returned() {
		BlockBusterService service = new BlockBusterService();
		service.returned(2, 2);
	}
	
	@Test
	public void fetchStaffDetail() {
		BlockBusterService service = new BlockBusterService();
		List<Staff> list = service.fetchStaffDetails(1);
		list.forEach(System.out::println);
	}
	
	@Test
	public void fetchAllMovies() {
		BlockBusterService service = new BlockBusterService();
		List<String> list = service.fetchAllMovies();
		list.forEach(System.out::println);
	}
	
	
}
