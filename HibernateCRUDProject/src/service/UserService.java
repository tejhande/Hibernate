package service;

import java.util.List;

import dao.UserDAO;
import model.User;

public class UserService {

	// Create an instance of UserDAO to interact with the database for User-related
	// operations
	private UserDAO userDAO = new UserDAO();

	// Method to save a new user by calling the saveUser method in UserDAO
	public void saveUser(User user) {
		userDAO.saveUser(user); // Delegate the save operation to the DAO layer
	}

	// Method to retrieve a user by their ID by calling the getUserById method in
	// UserDAO
	public User getUserById(int id) {
		return userDAO.getUserById(id); // Delegate the fetch operation to the DAO layer
	}

	// Method to retrieve all users from the database by calling getAllUsers in
	// UserDAO
	public List<User> getAllUsers() {
		return userDAO.getAllUsers(); // Delegate the operation to the DAO layer
	}

	// Method to update an existing user by calling the updateUser method in UserDAO
	public void updateUser(User user) {
		userDAO.updateUser(user); // Delegate the update operation to the DAO layer
	}

	// Method to delete a user by their ID by calling deleteUser in UserDAO
	public void deleteUser(int id) {
		userDAO.deleteUser(id); // Delegate the delete operation to the DAO layer
	}
}
