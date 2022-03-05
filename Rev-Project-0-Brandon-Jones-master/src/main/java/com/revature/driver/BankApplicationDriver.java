package com.revature.driver;

import java.util.Scanner;

import com.revature.beans.User;
import com.revature.beans.User.UserType;
import com.revature.dao.AccountDao;
import com.revature.dao.AccountDaoDB;
import com.revature.dao.UserDao;
import com.revature.dao.UserDaoDB;
import com.revature.services.UserService;

/**
 * This is the entry point to the application
 */
public class BankApplicationDriver {
	
	public static void register(User user) {
		
	}

	public static void main(String[] args) {
		//Welcome Screen options
		
		UserDao userDao = new UserDaoDB();
		AccountDao accountDao = new AccountDaoDB();
		UserService userService = new UserService(userDao, accountDao);
		int choice = 0;
		
		String username = null;
		String password = null;
		String firstName = null;
		String lastName = null;
		Scanner welcomeScanner = new Scanner(System.in);
		
		while (choice < 4) {
			
		
		System.out.println("Welcome to the Bank \n");
		System.out.println("What do you need today? \n");
		System.out.println("1. Setup A New Account");
		System.out.println(" 2. Login as Customer");
		System.out.println("  3. Login as Employee");
		System.out.println("   4. No Business to Transact");
		

		choice = welcomeScanner.nextInt();
		
		switch (choice) {
		// New Account Setup
		case 1: System.out.println("\nGreat! Let's get your account setup...\n");
		System.out.println("What is your 'first' name?");
		firstName = welcomeScanner.next();
		System.out.println("Your first name is "+ firstName);
		System.out.println("\nWhat is your 'last' name?");
		lastName = welcomeScanner.next();
		System.out.println("Your last name is "+ lastName);
		System.out.println("\nPlease choose a 'Username'");
		username = welcomeScanner.next();
//		if (username.equals()) **CHECK IF USERNAME EXISTS, THROW USERNAMEALREADYEXISTSEXCEPTION
		System.out.println("Your Username is "+ username);
		System.out.println("\nWhat is your 'password'?");
		password = welcomeScanner.next();
		System.out.println("Your password is "+ password+" , keep it secret");
		
		User newUser = new User(username, password, firstName, lastName, UserType.CUSTOMER);
		userService.register(newUser);
		
		System.out.println("\nYour account has been successfully created.\nYou may start up the program again to login... Goodbye!");
			break;
		
		case 2: 
			
			System.out.println("\nTo login, first put in your 'Username'");
		username = welcomeScanner.next();
		System.out.println("\nPlease enter your 'password");
		password = welcomeScanner.next();
		if (userService.login(username, password) != null) {
			System.out.println("Login is Successful");
		} else {
			System.out.println("Sorry, your login has failed. Please try again");
		}
		
		/*LOGIN SUCCESSFUL, LET THEM HAVE MORE CHOICES */
		
			break;
		
		case 3: 
			
			System.out.println("\nTo login, first put in your 'Employee Username'");
		username = welcomeScanner.next();
		System.out.println("\nPlease enter your 'Employee password");
		password = welcomeScanner.next();
		if (userService.login(username, password) != null)
			System.out.println("Login is Successful");
		else {
			System.out.println("Sorry, your login has failed. Please try again");
		}
		
		/*LOGIN SUCCESSFUL, LET THEM HAVE MORE CHOICES */
		
			break;	
			
		case 4:
			System.out.println("Thanks for using the bank, have a nice day");
			System.out.println("---Application closed---");
			System.exit(0);
			break;

		default:
			System.out.println("INVALID!: Please enter a number between [1-4]");
			break;
		}
			
				
			
			
			
		
		}
		welcomeScanner.close();
	}
}
