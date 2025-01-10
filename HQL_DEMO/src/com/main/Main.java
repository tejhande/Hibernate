package com.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.entity.Employee;

public class Main {

	public static void main(String[] args) {
		Configuration cfg = new Configuration();
		cfg.configure();
		cfg.addAnnotatedClass(Employee.class);

		SessionFactory factory = cfg.buildSessionFactory();
		Session session = factory.openSession();

		// Create a new employee and save it to the database

		Transaction tx = session.beginTransaction();

		Employee emp = new Employee();
		emp.setName("John");
		emp.setSalary(50000);
		emp.setDomain("Java Developer");
		session.persist(emp);
		tx.commit();
	}
}
