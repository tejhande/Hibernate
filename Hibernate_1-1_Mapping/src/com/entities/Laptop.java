package com.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class Laptop {
	@Id
	private int lap_id;
	private String lapName;

	// One-to-one mapping with Student
	@OneToOne(mappedBy = "laptop")
	private Student student;

	public int getLap_id() {
		return lap_id;
	}

	public void setLap_id(int lap_id) {
		this.lap_id = lap_id;
	}

	public String getLapName() {
		return lapName;
	}

	public void setLapName(String lapName) {
		this.lapName = lapName;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	@Override
	public String toString() {
		return "Laptop [lap_id=" + lap_id + ", lapName=" + lapName + "]";
	}

	public Laptop() {
	}

	public Laptop(int lap_id, String lapName) {
		this.lap_id = lap_id;
		this.lapName = lapName;
	}
}
