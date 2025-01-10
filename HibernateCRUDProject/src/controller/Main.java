package controller;

import java.util.List;
import java.util.Scanner;

import model.User;
import service.UserService;

public class Main {
	public static void main(String[] args) {
		// Create an instance of UserService to interact with the user-related business
		// logic
		UserService userService = new UserService();

		// Create a scanner object for reading user input from the console
		Scanner scanner = new Scanner(System.in);

		// Infinite loop for displaying the CRUD menu until the user decides to exit
		while (true) {
			// Display the CRUD operations menu
			System.out.println("\n=== CRUD Operations Menu ===");
			System.out.println("1. Create User");
			System.out.println("2. Read User by ID");
			System.out.println("3. Read User by Name");
			System.out.println("4. Update User");
			System.out.println("5. Delete User");
			System.out.println("6. See All Users");
			System.out.println("7. Exit");
			System.out.print("Enter your choice: ");

			// Read the user's choice for which operation to perform
			int choice = scanner.nextInt();
			scanner.nextLine(); // Consume newline character left by nextInt()

			// Perform the corresponding operation based on the user's choice
			switch (choice) {
			case 1: // Create User
				// Prompt the user to enter details for the new user
				System.out.print("Enter name: ");
				String name = scanner.nextLine();
				System.out.print("Enter mobile: ");
				String mobile = scanner.nextLine();
				System.out.print("Enter email: ");
				String email = scanner.nextLine();
				System.out.print("Enter age: ");
				int age = scanner.nextInt();
				scanner.nextLine(); // Consume newline

				// Create a new User object and set the values from user input
				User newUser = new User();
				newUser.setName(name);
				newUser.setMobile(mobile);
				newUser.setEmail(email);
				newUser.setAge(age);

				// Call the UserService to save the new user
				userService.saveUser(newUser);
				System.out.println("User created successfully!");
				break;

			case 2: // Read User by ID
				// Prompt the user to enter the ID of the user they want to retrieve
				System.out.print("Enter user ID: ");
				int id = scanner.nextInt();
				scanner.nextLine(); // Consume newline

				// Call the UserService to fetch the user by ID
				User userById = userService.getUserById(id);
				if (userById != null) {
					// If the user exists, display their details
					System.out.println("User Details: ID=" + userById.getId() + ", Name=" + userById.getName()
							+ ", Mobile=" + userById.getMobile() + ", Email=" + userById.getEmail() + ", Age="
							+ userById.getAge());
				} else {
					// If the user doesn't exist, display a message
					System.out.println("User not found.");
				}
				break;

			case 3: // Read User by Name
				// Prompt the user to enter the name of the user they want to search for
				System.out.print("Enter user name: ");
				String searchName = scanner.nextLine();
				boolean found = false;

				// Loop through all users to search for a match by name
				for (User user : userService.getAllUsers()) {
					if (user.getName().equalsIgnoreCase(searchName)) {
						// If a match is found, display the user's details
						System.out.println("User Details: ID=" + user.getId() + ", Name=" + user.getName() + ", Mobile="
								+ user.getMobile() + ", Email=" + user.getEmail() + ", Age=" + user.getAge());
						found = true;
					}
				}
				if (!found) {
					// If no match is found, display a message
					System.out.println("User not found.");
				}
				break;

			case 4: // Update User
				// Prompt the user to enter the ID of the user they want to update
				System.out.print("Enter user ID to update: ");
				int updateId = scanner.nextInt();
				scanner.nextLine(); // Consume newline

				// Call the UserService to fetch the user by ID
				User updateUser = userService.getUserById(updateId);
				if (updateUser != null) {
					// If the user exists, prompt for new details (leave blank to keep existing
					// value)
					System.out.print("Enter new name (leave blank to keep current): ");
					String newName = scanner.nextLine();
					System.out.print("Enter new mobile (leave blank to keep current): ");
					String newMobile = scanner.nextLine();
					System.out.print("Enter new email (leave blank to keep current): ");
					String newEmail = scanner.nextLine();
					System.out.print("Enter new age (-1 to keep current): ");
					int newAge = scanner.nextInt();
					scanner.nextLine(); // Consume newline

					// Update the user attributes if new values are provided
					if (!newName.isBlank()) {
						updateUser.setName(newName);
					}
					if (!newMobile.isBlank()) {
						updateUser.setMobile(newMobile);
					}
					if (!newEmail.isBlank()) {
						updateUser.setEmail(newEmail);
					}
					if (newAge != -1) {
						updateUser.setAge(newAge);
					}

					// Call the UserService to update the user in the database
					userService.updateUser(updateUser);
					System.out.println("User updated successfully!");
				} else {
					// If the user doesn't exist, display a message
					System.out.println("User not found.");
				}
				break;

			case 5: // Delete User
				// Prompt the user to enter the ID of the user they want to delete
				System.out.print("Enter user ID to delete: ");
				int deleteId = scanner.nextInt();
				scanner.nextLine(); // Consume newline

				// Call the UserService to delete the user from the database
				userService.deleteUser(deleteId);
				System.out.println("User deleted successfully!");
				break;

			case 6: // See All Users
				// Display all users
				System.out.println("=== All Users ===");
				List<User> users = userService.getAllUsers();

				// Check if there are any users, and display them in a formatted table
				if (users.isEmpty()) {
					System.out.println("No users found.");
				} else {
					int srNo = 1;
					// Print table headers
					System.out.printf("%-5s %-10s %-15s %-20s %-5s%n", "SrNo", "ID", "Name", "Mobile", "Age");
					for (User user : users) {
						// Set the serial number for each user
						user.setSrNo(srNo++);
						// Print each user's details in a formatted manner
						System.out.printf("%-5d %-10d %-15s %-20s %-5d%n", user.getSrNo(), user.getId(), user.getName(),
								user.getMobile(), user.getAge());
					}
				}
				break;

			case 7: // Exit
				// Exit the program gracefully
				System.out.println("Exiting program. Goodbye!");
				scanner.close(); // Close the scanner to prevent resource leak
				System.exit(0); // Terminate the program
				break;

			default:
				// Handle invalid menu choices
				System.out.println("Invalid choice. Please try again.");
			}
		}
	}
}
