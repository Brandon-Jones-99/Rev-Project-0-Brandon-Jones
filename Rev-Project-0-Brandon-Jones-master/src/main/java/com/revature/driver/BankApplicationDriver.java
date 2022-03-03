package com.revature.driver;

import java.util.Scanner;


import com.revature.beans.User;
import com.revature.beans.User.UserType;
import com.revature.dao.AccountDao;
import com.revature.dao.AccountDaoFile;
import com.revature.dao.UserDao;
import com.revature.dao.UserDaoFile;
import com.revature.services.UserService;

/**
 * This is the entry point to the application
 */
public class BankApplicationDriver {
	
	public static void register(User user) {
		
	}

	public static void main(String[] args) {
		//Welcome Screen options
		
		UserDao userDao = new UserDaoFile();
		AccountDao accountDao = new AccountDaoFile();
		UserService userService = new UserService(userDao, accountDao);
		int choice = 0;
		while (choice < 4) {
			
		
		System.out.println("Welcome to the Bank \n");
		System.out.println("What do you need today? \n");
		System.out.println("1. Setup A New Account");
		System.out.println(" 2. Login as Customer");
		System.out.println("  3. Login as Employee");
		System.out.println("   4. No Business to Transact");
		Scanner welcomeScanner = new Scanner(System.in);

		choice = welcomeScanner.nextInt();
		
		switch (choice) {
		// New Account Setup
		case 1: System.out.println("\nGreat! Let's get your account setup...\n");
		System.out.println("What is your 'first' name?");
		welcomeScanner.nextLine();
		String firstName = welcomeScanner.nextLine();
		System.out.println("Your first name is "+ firstName);
		System.out.println("\nWhat is your 'last' name?");
		String lastName = welcomeScanner.nextLine();
		System.out.println("Your last name is "+ lastName);
		System.out.println("\nPlease choose a 'Username'");
		String username = welcomeScanner.nextLine();
		System.out.println("Your Username is "+ username);
		System.out.println("\nWhat is your 'password'?");
		String password = welcomeScanner.nextLine();
		System.out.println("Your password is "+ password+" , keep it secret");
		
		User newUser = new User(username, password, firstName, lastName, UserType.CUSTOMER);
		userService.register(newUser);
		
		System.out.println("\nYour account has been successfully created.\nYou may start up the program again to login... Goodbye!");
		
		
			break;
		// Customer Login	username2 temporary
		case 2: System.out.println("\nTo login, first put in your 'Username'");
		welcomeScanner.nextLine();
		String username2 = welcomeScanner.nextLine();
		
		/*CHECK ALL USERS FOR EXISTING USERNAME*/
		
		System.out.println("\nWelcome back "+username2+"! Please enter your 'password");
		welcomeScanner.nextLine();
		
		/*CHECK USER PASSWORD */
		
		/*LOGIN SUCCESSFUL, LET THEM HAVE MORE CHOICES */
		
			break;
		/*Employee Login  employee temporary*/
		case 3: System.out.println("\nTo login, first put in your 'Employee Username'");
		welcomeScanner.nextLine();
		String employee = welcomeScanner.nextLine();
		
		/*CHECK ALL USERS FOR EXISTING USERNAME*/
		
		System.out.println("\nWelcome back "+employee+"! Please enter your 'Employee password");
		welcomeScanner.nextLine();
		
		/*CHECK EMPLOYEE PASSWORD */
		
		/*LOGIN SUCCESSFUL, LET THEM HAVE MORE CHOICES */
		
			break;	

		default:
			break;
		}
			
				
			
			welcomeScanner.close();
			
			System.out.println("Thank you, and have a great day!");
			System.out.println("---Application closed---");
			
			System.exit(0);
		
		}
	}
}
