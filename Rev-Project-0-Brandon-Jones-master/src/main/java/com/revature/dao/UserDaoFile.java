package com.revature.dao;

import java.util.ArrayList;
import java.util.List;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.IOException;
import java.io.FileNotFoundException;


import com.revature.beans.User;

/**
 * Implementation of UserDAO that reads and writes to a file
 */
public class UserDaoFile implements UserDao {
	
	public static String fileLocation = "src\\output\\users.txt"; 
     //SIVA'S VERSION
	private static int id = 0;
    List<User> userList = new ArrayList<User>();
	

	
	public UserDaoFile() {
	  File userFile = new File(fileLocation);
     if(!userFile.exists()) {
    	 try {
			userFile.createNewFile();
			
			try{
				ObjectOutputStream userOutput = new ObjectOutputStream(new FileOutputStream(fileLocation));

			
				userOutput.writeObject(userList);
				userOutput.close();
				
			}catch(FileNotFoundException e) {
				System.out.println("Users file is missing/in wrong location");
			}catch(IOException e) {
				System.out.println("An exception was thrown: "+e.getMessage());
			}
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
     }
	};
			
	
	public User addUser(User user) {
		
        userList = getAllUsers();
        userList.add(user);
		
		try{
			ObjectOutputStream userOutput = new ObjectOutputStream(new FileOutputStream(fileLocation));
//			userOutFile = new FileOutputStream(fileLocation); //SIVA'S VERSION FileOutputStream(userFile,true)
//			userOutput = new ObjectOutputStream(userOutFile);
			
			userOutput.writeObject(userList);
			userOutput.close();
			
		}catch(FileNotFoundException e) {
			System.out.println("Users file is missing/in wrong location");
		}catch(IOException e) {
			System.out.println("An exception was thrown: "+e.getMessage());
		}
		
		
		
		return user;
	}

	public User getUser(Integer userId) {
		
		userList = getAllUsers();
		for(User u : userList) {
			if(u.getId().equals(userId)) 
				return u;
				
			}
			return null;
		
	}

	public User getUser(String username, String pass) {
		
		User requestedUser = null;
		
		for(User u : userList) {
			if(u.getUsername().equals(username) && u.getPassword().equals(pass)) 
				
				requestedUser = u;
				
				return requestedUser;
				
			
		}
		
		return null;
	}

	
	@SuppressWarnings("unchecked")
	public List<User> getAllUsers() {
		try 
			(ObjectInputStream userInput = new ObjectInputStream(new FileInputStream(fileLocation))){
			userList = (ArrayList<User>) userInput.readObject();
			userInput.close();
			
		}catch(FileNotFoundException e) {
			System.out.println("File Missing");
		}catch(IOException e) {
			System.out.println("exception thrown"+e.getMessage());
		}catch(ClassNotFoundException e) {
			System.out.println("exception thrown"+e.getMessage());
		}
		return userList;
	}

	public User updateUser(User u) {
//		if (userList.contains(u)) {
			
//		}
		return null;
	}

	public boolean removeUser(User u) {
		boolean status = false;
		for(User user : userList) {
			if (user.getId() == u.getId())
				status = userList.remove(u);
		}
		
		return status;
	}

}
