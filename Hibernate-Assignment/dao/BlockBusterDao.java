package com.citiustech.dao;

import java.util.List;

import com.citiustech.entity.Staff;

public class BlockBusterDao extends GenericDao{
	
	public List<Staff> fetchStaffDetail(int staff_id) {
		return entityManagerFactory
				.createEntityManager()
				.createQuery("select s from Staff s where s.staff_id =:staff_id ", Staff.class)
				.setParameter("staff_id", staff_id)
				.getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<String> fetchMovies() {
		return entityManagerFactory
				.createEntityManager()
				.createQuery("select distinct name from Movie")
				.getResultList();
	}
}
