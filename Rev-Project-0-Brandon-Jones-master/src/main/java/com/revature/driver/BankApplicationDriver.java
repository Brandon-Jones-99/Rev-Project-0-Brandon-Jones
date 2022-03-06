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
	
	static boolean logged = false;
	static boolean employeeLogged = false;

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
			while (logged == false) {
		
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
		System.out.println("\nPlease enter your 'password'");
		password = welcomeScanner.next();
		if (userService.login(username, password) != null) {
			System.out.println("Login is Successful");
			loggedIn();
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
		if (userService.login(username, password) != null) {
			System.out.println("Login is Successful");
		    employeeLoggedIn();
		} else {
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
		}
		welcomeScanner.close();
	}
	public static void loggedIn() {
		
		Scanner loggedInScanner = new Scanner(System.in);
		int loggedInChoice = 0;
		logged = true;
		while (loggedInChoice < 6) {
			
		
		System.out.println("Welcome to your Account Dashboard\n");
		System.out.println("What would you like to do?\n");
		System.out.println("1. Apply for a new Account");
		System.out.println(" 2. View an Account Balance");
		System.out.println("  3. Make a Deposit");
		System.out.println("   4. Make a Withdrawal");
		System.out.println("    5. Transfer Money");
		System.out.println("     6. Logout and Exit");
		System.out.println("\nPlease make you selection [1-6]");
		
		loggedInChoice = loggedInScanner.nextInt();
		
		switch (loggedInChoice) {
		
		case 1:
			System.out.println("You've selected to Apply for a new Account\n");
			System.out.println("What kind of account would you like to apply for?\n");
			System.out.println(" Select 'C' for Checking or 'S' for Savings");
			String typeOfAccount = loggedInScanner.next();
			if (typeOfAccount.equals("C")) {
				System.out.println("you chose Checking Account");
				
				// ADD SOME LOGIC
			} else if (typeOfAccount.equals("S")) {
				System.out.println("you chose Savings Account");
				// ADD SOME LOGIC
		     
			} else System.out.println("INVALID! You have to choose 'C' or 'S'... Please try again");
				
			
			break;
			
		case 2:
			System.out.println("You've selected to View your Account Balance\n");
			System.out.println("Which Account Balance would you like to view?\n");
			System.out.println(" Select 'C' for Checking or 'S' for Savings");
			String typeOfAccount2 = loggedInScanner.next();
			if (typeOfAccount2.equals("C")) {
				System.out.println("you chose Checking Account");
				
				// ADD SOME LOGIC
			} else if (typeOfAccount2.equals("S")) {
				System.out.println("you chose Savings Account");
				// ADD SOME LOGIC
		     
			} else System.out.println("INVALID! You have to choose 'C' or 'S'... Please try again");
			
			break;
			
		case 3:
			System.out.println("You've selected to Make a Deposit\n");
			System.out.println("Which account would you like to deposit into?\n");
			System.out.println(" Select 'C' for Checking or 'S' for Savings");
			String typeOfAccount3 = loggedInScanner.next();
			if (typeOfAccount3.equals("C")) {
				System.out.println("you chose Checking Account");
				
				// ADD SOME LOGIC
			} else if (typeOfAccount3.equals("S")) {
				System.out.println("you chose Savings Account");
				// ADD SOME LOGIC
		     
			} else System.out.println("INVALID! You have to choose 'C' or 'S'... Please try again");
			
			break;
			
		case 4:
			System.out.println("You've selected to Make a Withdrawal\n");
			System.out.println("Which account would you like to withdraw from?\n");
			System.out.println(" Select 'C' for Checking or 'S' for Savings");
			String typeOfAccount4 = loggedInScanner.next();
			if (typeOfAccount4.equals("C")) {
				System.out.println("you chose Checking Account");
				
				// ADD SOME LOGIC
			} else if (typeOfAccount4.equals("S")) {
				System.out.println("you chose Savings Account");
				// ADD SOME LOGIC
		     
			} else System.out.println("INVALID! You have to choose 'C' or 'S'... Please try again");
			
			break;
			
		case 5:
			System.out.println("You've selected to Transfer Money\n");
			System.out.println("What kind of transfer would you like to do?\n");
			System.out.println(" Select 'C' to Transfer from Checking to Savings");
			System.out.println(" Select 'S' to Transfer from Savings to Checking");
			String typeOfAccount5 = loggedInScanner.next();
			if (typeOfAccount5.equals("C")) {
				System.out.println("you chose to Transfer from Checking to Savings");
				
				// ADD SOME LOGIC
			} else if (typeOfAccount5.equals("S")) {
				System.out.println("you chose to Transfer from Savings to Checking");
				// ADD SOME LOGIC
		     
			} else System.out.println("INVALID! You have to choose 'C' or 'S'... Please try again");
			
			break;
			
		case 6:
			System.out.println("Thank you for choosing our Bank. Have a blessed day!");
			System.out.println("---Application closed---");
			System.exit(0);
			
			break;

		default:
			System.out.println("INVALID!: Please enter a number between [1-6]");
			break;
		}
		}
		loggedInScanner.close();
	};
	
	public static void employeeLoggedIn() {
		
		Scanner employeeScanner = new Scanner(System.in);
		int employeeChoice = 0;
		employeeLogged = true;
		while (employeeChoice < 3) {
			
			System.out.println("Welcome to your Employee Dashboard\n");
			System.out.println("What would you like to do?\n");
			System.out.println("1. Approve/Reject an Account");
			System.out.println(" 2. View Transaction Log");
			System.out.println("  3. Logout and Exit");
			System.out.println("\nPlease make you selection [1-3]");
			
			employeeChoice = employeeScanner.nextInt();
			
			switch (employeeChoice) {
			
			case 1:
				System.out.println("You've chose to Approve/Reject an Account\n");
				System.out.println("Enter the account ID to change the account status");
				//ADD SOME LOGIC
				break;
				
			case 2:
				System.out.println("Here is the full Transaction Log");
				//ADD SOME LOGIC
				break;
				
			case 3:
				System.out.println("Thank you for working for our Bank. We truly appreciate you!");
				System.out.println("---Application closed---");
				System.exit(0);
				break;

			default:
				
				break;
			}
			
		};
		
		employeeScanner.close();
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
