package com.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class Student {

	@Id
	private int stud_id;
	private String stud_name;

	// One-to-one mapping with Laptop
	@OneToOne
	private Laptop laptop;

	public int getStud_id() {
		return stud_id;
	}

	public void setStud_id(int stud_id) {
		this.stud_id = stud_id;
	}

	public String getStud_name() {
		return stud_name;
	}

	public void setStud_name(String stud_name) {
		this.stud_name = stud_name;
	}

	public Laptop getLaptop() {
		return laptop;
	}

	public void setLaptop(Laptop laptop) {
		this.laptop = laptop;
	}

	@Override
	public String toString() {
		return "Student [stud_id=" + stud_id + ", stud_name=" + stud_name + "]";
	}

	public Student() {
	}

	public Student(int stud_id, String stud_name, Laptop laptop) {
		this.stud_id = stud_id;
		this.stud_name = stud_name;
		this.laptop = laptop;
	}
}
