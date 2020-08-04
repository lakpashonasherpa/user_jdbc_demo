package com.vastika.user_demo_jdbc_1;

import java.util.List;
import java.util.Scanner;

import com.vastika.user_demo_jdbc_1.model.User;
import com.vastika.user_demo_jdbc_1.service.UserService;
import com.vastika.user_demo_jdbc_1.service.UserServiceImpl;

public class UserController {
	public static void main(String[] args) {

		UserService userService = new UserServiceImpl();
		String decision = " ";
		Scanner reader = new Scanner(System.in);
		do {
			System.out.println("Enter the choice would you like to perform save|update|get|delete|list");
			String choice = reader.next();
			switch (choice) {
			case "save":
				User saveUserData = getUserData(choice, reader);
				int saved = userService.saveUserInfo(saveUserData);
				if (saved >= 1) {
					System.out.println("data enter is successful");
				} else {
					System.out.println("error in db.");
				}
				break;
			case "update":

				User updateUserData = getUserData(choice, reader);
				int update = userService.updateUserInfo(updateUserData);
				if (update >= 1) {
					System.out.println("data updated is successful");
				} else {
					System.out.println("error in db.");
				}

				break;
			case "delete":
				System.out.println("Enter the id: ");
				int deleteId = reader.nextInt();
				userService.deleteuserInfo(deleteId);
				System.out.println("User info is deleted.!!!!");

				break;
			case "get":
				System.out.println("Enter the id: ");
				int getId = reader.nextInt();
				User user = userService.getUserById(getId);
				System.out.println("User id is: " + user.getId());
				System.out.println("User name is: " + user.getUsername());
				System.out.println("User password is: " + user.getPassword());
				System.out.println("User address is: " + user.getAddress());
				System.out.println("User mobile number is: " + user.getMobilenumber());

				break;
			case "list":
				List<User> listUser = userService.getAllUserInfo();
				for (User u : listUser) {
					System.out.println("User id is: " + u.getId());
					System.out.println("User name is: " + u.getUsername());
					System.out.println("User password is: " + u.getPassword());
					System.out.println("User address is: " + u.getAddress());
					System.out.println("User mobile number is: " + u.getMobilenumber());
					System.out.println("=======================");
				}
				break;
			default:
				System.out.println("you have enter a wron choice!!");
			}

			System.out.println("Do you like to permorm next activitie enter y|Y for yes ");
			decision = reader.next();
		} while (decision.equalsIgnoreCase("y"));

	}

	public static User getUserData(String type, Scanner reader) {
		User user = new User();
		if (type.equals("update")) {
			System.out.println("Enter id: ");
			int id = reader.nextInt();
			user.setId(id);
		}
		System.out.println("Enter user name: ");
		String username = reader.next();
		System.out.println("Enter password: ");
		String password = reader.next();
		System.out.println("Enter the address: ");
		String address = reader.next();
		System.out.println("Enter mobile number: ");
		long mobilenumber = reader.nextLong();

		user.setUsername(username);
		user.setPassword(password);
		user.setMobilenumber(mobilenumber);
		user.setAddress(address);

		return user;

	}
}
