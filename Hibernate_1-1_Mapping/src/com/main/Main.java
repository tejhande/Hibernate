package com.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.entities.Laptop;
import com.entities.Student;

public class Main {

	public static void main(String[] args) {
		// Load configuration
		Configuration cfg = new Configuration();
		cfg.configure();
		cfg.addAnnotatedClass(Student.class);
		cfg.addAnnotatedClass(Laptop.class);

		// Build session factory and open session
		SessionFactory factory = cfg.buildSessionFactory();
		Session session = factory.openSession();

		Transaction tx = session.beginTransaction();

		// Create a new Laptop
		Laptop laptop1 = new Laptop(1, "Dell XPS 13");

		// Create a new Student
		Student student1 = new Student(101, "Tejas Hande", laptop1);

		// Set the student's laptop
		laptop1.setStudent(student1);

		// Save the entities
		session.save(student1);
		session.save(laptop1);

		// Commit the transaction
		tx.commit();

		// Close session
		session.close();
		factory.close();
	}
}
