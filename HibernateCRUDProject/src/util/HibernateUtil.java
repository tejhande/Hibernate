package util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

	// A static variable to hold the SessionFactory instance
	private static SessionFactory sessionFactory;

	// Static block to initialize the SessionFactory
	static {
		try {
			// The Configuration object is used to read the hibernate.cfg.xml file
			// It contains all the database connection properties and Hibernate settings
			sessionFactory = new Configuration().configure().buildSessionFactory();
		} catch (Throwable ex) {
			// In case of an exception, an ExceptionInInitializerError is thrown.
			// This will stop the application from starting as the SessionFactory is
			// essential
			throw new ExceptionInInitializerError(ex);
		}
	}

	// Getter method to retrieve the SessionFactory instance
	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	// Method to close the SessionFactory when the application is shutting down
	public static void shutdown() {
		// This ensures the SessionFactory is properly closed, releasing database
		// connections and resources.
		getSessionFactory().close();
	}
}
