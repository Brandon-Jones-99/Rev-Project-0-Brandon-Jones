package com.revature.driver;

import java.util.Scanner;

import com.revature.beans.Account;
import com.revature.beans.Account.AccountType;
import com.revature.beans.User;
import com.revature.beans.User.UserType;
import com.revature.dao.AccountDao;
import com.revature.dao.AccountDaoDB;
import com.revature.dao.TransactionDao;
import com.revature.dao.TransactionDaoDB;
import com.revature.dao.UserDao;
import com.revature.dao.UserDaoDB;
import com.revature.exceptions.InvalidCredentialsException;
import com.revature.exceptions.OverdraftException;
import com.revature.exceptions.UnauthorizedException;
import com.revature.exceptions.UsernameAlreadyExistsException;
import com.revature.services.AccountService;
import com.revature.services.UserService;
import com.revature.utils.SessionCache;

/**
 * This is the entry point to the application
 */
public class BankApplicationDriver {
	
	static boolean welcome = false;
	static boolean logged = false;
	static boolean employeeLogged = false;
	public UserDao userDao = new UserDaoDB();
	public AccountDao accountDao = new AccountDaoDB();
	public UserService userService = new UserService(userDao, accountDao);
	public AccountService accountService = new AccountService(accountDao);
	public TransactionDao transactionDao = new TransactionDaoDB();

	public static void main(String[] args) {
		
	  BankApplicationDriver newDriver = new BankApplicationDriver();
		
		newDriver.Welcome();

	}
		public void Welcome() {
			
		
		welcome = true;
		int choice = 0;
		
		String username = null;
		String password = null;
		String firstName = null;
		String lastName = null;
		Scanner welcomeScanner = new Scanner(System.in);

		while (choice < 4) {
			while (logged == false) {
		System.out.println(",,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,\\");
		System.out.println("||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||!");
		System.out.println("''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''/\n");
		System.out.println("WELCOME TO THE COUNTRY FRIED BANK \n");
		System.out.println("What do y'all need today? \n");
		System.out.println("1. Setup A New Account");
		System.out.println(" 2. Login as Customer");
		System.out.println("  3. Login as Employee");
		System.out.println("   4. No Business to Transact");
		System.out.println("\n............................................................\\");
		System.out.println("||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||!");
		System.out.println("''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''/\n");
		
		choice = welcomeScanner.nextInt();
		
		switch (choice) {
		// New Account Setup
		case 1: 
		System.out.println("\nDarn Tootin'! Let's get your account setup...\n");
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
		System.out.println("Your password is "+ password+" , (keep it secret, y'all hear?)");
		
		 User newUser = new User(username, password, firstName, lastName, UserType.CUSTOMER);
		 try { userService.register(newUser);
		} catch (UsernameAlreadyExistsException e) {
			e.printStackTrace();
		}
		
		System.out.println("\nYour account has been successfully created.\nYou may now login using your new credentials! Yeehaw! \\(^o^)/\n");
			break;
		
		case 2: 
			
			System.out.println("\nTo login, first put in your 'Username'");
		username = welcomeScanner.next();
		System.out.println("\nPlease enter your 'password'");
		password = welcomeScanner.next();
		try { SessionCache.setCurrentUser(userService.login(username, password));
		System.out.println("Login is Successful. Jubilation! \\(^o^)/\n");
		loggedIn();
		} catch (InvalidCredentialsException e) {
			System.out.println("Sorry, your login has failed. Please try again `\\_('o')_/`");
		}
			break;
		
		case 3: 
			
			System.out.println("\nTo login, first put in your 'Employee Username'");
		username = welcomeScanner.next();
		System.out.println("\nPlease enter your 'Employee password");
		password = welcomeScanner.next();
		try { SessionCache.setCurrentUser(userService.login(username, password));
		System.out.println("Login is Successful. Jubilation! \\(^o^)/\n");
		employeeLoggedIn();
		} catch (InvalidCredentialsException e) {
			System.out.println("Sorry, your login has failed. Please try again `\\_('o')_/`");
		}
		
			break;	
			
		case 4:
			System.out.println("Thanks for using Country Fried Bank! Have a rip-snortin' good day, and y'all come back real soon now! \n");
			System.out.println("---APPLICATION CLOSED---\n\n\n");
			welcome = false;
			break;

		default:
			System.out.println("INVALID!: Please enter a number between [1-4]\t[-_-]");
			break;
				}
			
			}
		}
		welcomeScanner.close();
	
		}
			
		
	public void loggedIn() {
		
		Scanner loggedInScanner = new Scanner(System.in);
		
		int loggedInChoice = 0;
		welcome = false;
		logged = true;
		while (loggedInChoice < 6) {
			
		System.out.println(",,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,\\");
		System.out.println("||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||!");
		System.out.println("''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''/\n");
		System.out.println("WELCOME TO YOUR ACCOUNT DASHBOARD\n");
		System.out.println("What would y'all like to do?\n");
		System.out.println("1. Apply for a new Account");
		System.out.println(" 2. View an Account Balance");
		System.out.println("  3. Make a Deposit");
		System.out.println("   4. Make a Withdrawal");
		System.out.println("    5. Transfer Money");
		System.out.println("     6. Logout and Exit");
		System.out.println("\nPlease make you selection [1-6]");
		System.out.println("\n............................................................\\");
		System.out.println("||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||!");
		System.out.println("''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''/\n");
		
		loggedInChoice = loggedInScanner.nextInt();
		
		switch (loggedInChoice) {
		
		case 1:
			System.out.println("You've selected to Apply for a new Account\n");
			System.out.println("What kind of account would you like to apply for?\n");
			System.out.println(" Select 'C' for Checking or 'S' for Savings");
			String typeOfAccount = loggedInScanner.next();
			if (typeOfAccount.equals("C")) {
				System.out.println("you chose Checking Account\n");
				System.out.println("Your starting balance is going to be $25.00, is that OK?");
				String startingBalance = loggedInScanner.next();
				if (startingBalance.equals("YES")) {
					System.out.println("\nOK great, your starting balance is now $25.00");
			
				
				accountService.createNewAccount(SessionCache.getCurrentUser().get());
				
				System.out.println("\nYou've successfully created a Checking Account! \\(^o^)/\n");
				
				} else {
					System.out.println("INVALID! Sorry, you must have a $25.00 starting balance! `\\_('o')_/`");
				}
				
			} else if (typeOfAccount.equals("S")) {
				System.out.println("you chose Savings Account");
				// This functionality may be added later
		     
			} else System.out.println("INVALID! You have to choose 'C' or 'S'... Please try again `\\_('o')_/`");

			break;
			
		case 2:
			System.out.println("You've selected to View your Account Balance\n");
			System.out.println("Here are your accounts\n");
			System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------");
			System.out.println(accountDao.getAccountsByUser(SessionCache.getCurrentUser().get()));
			System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------\n");
			System.out.println("Which Account Balance would you like to view?\n");
			System.out.println("Select your System Account Number (the field labeled id='xxx')");
			int typeOfAccount2 = loggedInScanner.nextInt();
			
			if (accountDao.getAccount(typeOfAccount2).getId() != null) {
			
				System.out.println("OK, we got your account... your balance is $"+ accountDao.getAccount(typeOfAccount2).getBalance()+" \\(^o^)/\n");
				
				
				
			}  else  {System.out.println("INVALID! We couldn't locate your Account Number... Please try again `\\_('o')_/`"); 
			}
			System.out.println("------(RETURNING TO DASHBOARD)-------\n\n\n");
			break;
			
		case 3:
			System.out.println("You've selected to Make a Deposit\n");
			System.out.println("Here are your accounts\n");
			System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------");
			System.out.println(accountDao.getAccountsByUser(SessionCache.getCurrentUser().get()));
			System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------\n");
			System.out.println("Which account would you like to deposit into?\n");
			System.out.println("Select your System Account Number (the field labeled id='xxx')");
			int typeOfAccount3 = loggedInScanner.nextInt();
			System.out.println("How much would you like to deposit?");
			double depositAmount = loggedInScanner.nextDouble();
			try { accountService.deposit(accountDao.getAccount(typeOfAccount3), depositAmount);
				System.out.println("OK, you've deposited " + depositAmount); 
				System.out.println("\nYour new account balance is $" + accountDao.getAccount(typeOfAccount3).getBalance()+" \\(^o^)/\n");
			}
			catch (UnsupportedOperationException | UnauthorizedException e) { 
				System.out.println("INVALID! We couldn't make a Deposit... Please try again `\\_('o')_/`");
				e.printStackTrace(); 
				
			}
			System.out.println("------(RETURNING TO DASHBOARD)-------\n\n\n");
			break;
			
		case 4:
			System.out.println("You've selected to Make a Withdrawal\n");
			System.out.println("Here are your accounts\n");
			System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------");
			System.out.println(accountDao.getAccountsByUser(SessionCache.getCurrentUser().get()));
			System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------\n");
			System.out.println("Which account would you like to withdraw from?\n");
			System.out.println("Select your System Account Number (the field labeled id='xxx')");
			int typeOfAccount4 = loggedInScanner.nextInt();
			System.out.println("How much would you like to withdraw?");
			double depositAmount2 = loggedInScanner.nextDouble();
			try { accountService.withdraw(accountDao.getAccount(typeOfAccount4), depositAmount2);
				System.out.println("OK you've withdrawn " + depositAmount2);
				System.out.println("\nYour new account balance is $" + accountDao.getAccount(typeOfAccount4).getBalance()+" \\(^o^)/\n");
			} catch (OverdraftException | UnsupportedOperationException | UnauthorizedException e) {
				System.out.println("INVALID! Sorry, we couldn't make a Withdrawal... Please try again `\\_('o')_/`");
				e.printStackTrace();
			}
			System.out.println("------(RETURNING TO DASHBOARD)-------\n\n\n");	
			break;
			
		case 5:
			System.out.println("You've selected to Transfer Money\n\n");
			System.out.println("PLEASE NOTE: You are only allowed to transfer money between your own accounts at this time\n\n");
			System.out.println("Here are your accounts:");
			System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------");
			System.out.println(accountDao.getAccountsByUser(SessionCache.getCurrentUser().get()));
			System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------\n");
			System.out.println("Enter the account you would like to transfer from... (the field labeled id='xxx')");
			int fromAcc = loggedInScanner.nextInt();
			System.out.println("Enter the account you would like to transfer to... (the field labeled id='xxx')");
			int toAcc = loggedInScanner.nextInt();
			System.out.println("enter the amount you would like to transfer...");
			double depositAmount3 = loggedInScanner.nextDouble();
			try {accountService.transfer(accountDao.getAccount(fromAcc), accountDao.getAccount(toAcc), depositAmount3);
				System.out.println("OK, you've transferred " + depositAmount3);
				System.out.println("\nYour new account balance from the account you took money from is $" +accountDao.getAccount(fromAcc).getBalance());
				System.out.println("\nYour new account balance from the account you put money into is $" +accountDao.getAccount(toAcc).getBalance());
				System.out.println("\n               \\(^o^)/\n");
			} catch (UnsupportedOperationException | UnauthorizedException e) {
				System.out.println("INVALID! Something went wrong... Please try again `\\_('o')_/`");
				e.printStackTrace();
			}
			
			System.out.println("------(RETURNING TO DASHBOARD)-------\n\n\n");
			break;
			
		case 6:
			System.out.println("Thank y'all for choosing Country Fried Bank. Have a blessed day!\n");
			System.out.println("---APPLICATION CLOSED---\n\n\n");
			logged = false;
			Welcome();
			break;

		default:
			System.out.println("INVALID!: Please enter a number between [1-6]\t[-_-]");
			break;
		}
		}
		loggedInScanner.close();
	};
	
	public void employeeLoggedIn() {
		
		Scanner employeeScanner = new Scanner(System.in);
//		SessionCache.getCurrentUser().get();
		int employeeChoice = 0;
		employeeLogged = true;
		while (employeeChoice < 3) {
			System.out.println(",,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,\\");
			System.out.println("||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||!");
			System.out.println("''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''/\n");
			System.out.println("WELCOME TO YOUR EMPLOYEE DASHBOARD\n");
			System.out.println("What would you like to do?\n");
			System.out.println("1. Approve/Reject an Account");
			System.out.println(" 2. View Transaction Log");
			System.out.println("  3. Logout and Exit");
			System.out.println("\nPlease make you selection [1-3]");
			System.out.println("\n\n-----------(PLEASE NOTE: If you would like to make a transaction involving one of your personal accounts,");
			System.out.println("Please login using the customer login screen using your employee username and password.)----------------");
			System.out.println("\n............................................................\\");
			System.out.println("||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||!");
			System.out.println("''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''/\n");
			//EMPLOYEES CAN'T YET LOGIN TO THEIR PERSONAL ACCOUNTS
			
			employeeChoice = employeeScanner.nextInt();
			
			switch (employeeChoice) {
			
			case 1:
				System.out.println("You've chose to Approve/Reject an Account\n");
				System.out.println("Enter the account ID whose status you would like to change");
				int approveRejectId = employeeScanner.nextInt();
				System.out.println("Enter 'true' or 'false' to change the account status");
				boolean approveRejectBoolean = employeeScanner.nextBoolean();
				try {accountService.approveOrRejectAccount(accountDao.getAccount(approveRejectId), approveRejectBoolean); 
					System.out.println("OK, you've changed this user's account status to "+accountDao.getAccount(approveRejectId));
					System.out.println("\n               \\(^o^)/\n");
				
				} catch (UnauthorizedException e) {
					System.out.println("INVALID: Something went wrong... please try again `\\_('o')_/`");
				}
				break;
				
			case 2:
				System.out.println("Here is the full Transaction Log");
				System.out.println(transactionDao.getAllTransactions());
				System.out.println("\n               \\(^o^)/\n");
				//ADD SOME LOGIC
				break;
				
			case 3:
				System.out.println("Thank you for working for Country Fried Bank. We truly appreciate you!\n");
				System.out.println("---APPLICATION CLOSED---\n\n\n");
				employeeLogged = false;
				Welcome();
				break;

			default:
				System.out.println("INVALID!: Please enter a number between [1-3]\t[-_-]");
				break;
			}
			
		};
		
		employeeScanner.close();
		
	}
	
	
	
	
}
