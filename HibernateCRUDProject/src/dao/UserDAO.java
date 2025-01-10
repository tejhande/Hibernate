package dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import model.User;
import util.HibernateUtil;

public class UserDAO {

	// Method to save a new user to the database
	public void saveUser(User user) {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// Start a new transaction
			transaction = session.beginTransaction();

			// Save the user object to the database (insert operation)
			session.save(user);

			// Commit the transaction to apply changes to the database
			transaction.commit();
		} catch (Exception e) {
			// In case of an error, rollback the transaction to avoid partial data changes
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace(); // Print the error for debugging
		}
	}

	// Method to get a user by their ID
	public User getUserById(int id) {
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// Retrieve the user using the provided ID (fetch operation)
			return session.get(User.class, id);
		}
	}

	// Method to get all users from the database
	public List<User> getAllUsers() {
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// Query all users in the User table
			return session.createQuery("from User", User.class).list(); // JPQL query
		}
	}

	// Method to update an existing user in the database
	public void updateUser(User user) {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// Start a new transaction
			transaction = session.beginTransaction();

			// Update the user object in the database (update operation)
			session.update(user);

			// Commit the transaction to apply changes to the database
			transaction.commit();
		} catch (Exception e) {
			// In case of an error, rollback the transaction to avoid partial data changes
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace(); // Print the error for debugging
		}
	}

	// Method to delete a user by their ID
	public void deleteUser(int id) {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// Start a new transaction
			transaction = session.beginTransaction();

			// Retrieve the user by ID
			User user = session.get(User.class, id);
			if (user != null) {
				// Delete the user if they exist in the database
				session.delete(user);
			}

			// Commit the transaction to apply changes to the database
			transaction.commit();
		} catch (Exception e) {
			// In case of an error, rollback the transaction to avoid partial data changes
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace(); // Print the error for debugging
		}
	}
}
