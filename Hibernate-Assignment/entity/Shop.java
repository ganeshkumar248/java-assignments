package com.citiustech.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_shop")
public class Shop {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String location;
	
	@OneToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "manager_id")
	private Manager manager;
	private String firstAhiftStaffMember;
	private String secondShiftStaffMember;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "staff_id")
	private Staff staff;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Manager getManager() {
		return manager;
	}

	public void setManager(Manager manager) {
		this.manager = manager;
	}

	public String getFirstAhiftStaffMember() {
		return firstAhiftStaffMember;
	}

	public void setFirstAhiftStaffMember(String firstAhiftStaffMember) {
		this.firstAhiftStaffMember = firstAhiftStaffMember;
	}

	public String getSecondShiftStaffMember() {
		return secondShiftStaffMember;
	}

	public void setSecondShiftStaffMember(String secondShiftStaffMember) {
		this.secondShiftStaffMember = secondShiftStaffMember;
	}

	public Staff getStaff() {
		return staff;
	}

	public void setStaff(Staff staff) {
		this.staff = staff;
	}
	
}
