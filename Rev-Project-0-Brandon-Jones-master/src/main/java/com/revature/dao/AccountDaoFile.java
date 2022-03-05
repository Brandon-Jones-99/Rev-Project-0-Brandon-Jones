package com.revature.dao;

import java.io.File;
import java.io.IOException;
import java.util.List;

import com.revature.beans.Account;
import com.revature.beans.User;

/**
 * Implementation of AccountDAO which reads/writes to files
 */
public class AccountDaoFile implements AccountDao {
	// use this file location to persist the data to
	
	
public static String fileLocation = "src\\output\\accounts.txt";
	
	
	public AccountDaoFile() {
		 File userFile = new File(fileLocation);
	     if(!userFile.exists()) {
	    	 try {
				userFile.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	     }
		};

	public Account addAccount(Account a) {
		// TODO Auto-generated method stub
		return null;
	}

	public Account getAccount(Integer actId) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Account> getAccounts() {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Account> getAccountsByUser(User u) {
		// TODO Auto-generated method stub
		return null;
	}

	public Account updateAccount(Account a) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean removeAccount(Account a) {
		// TODO Auto-generated method stub
		return false;
	}

}
