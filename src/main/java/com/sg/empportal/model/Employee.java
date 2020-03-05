package com.sg.empportal.model;

import javax.persistence.GeneratedValue;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@SuppressWarnings("deprecation")
@Entity
public class Employee {

	@Id
	@GeneratedValue
	private long id;
	private String fname;
	private String lname;
	private String gender;
	private String dob;
	private String department;

	public Employee() {
	}

	public Employee(String fname, String lname, String gender, String dob, String department) {
		super();
		this.fname = fname;
		this.lname = lname;
		this.gender = gender;
		this.dob = dob;
		this.department = department;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

}
