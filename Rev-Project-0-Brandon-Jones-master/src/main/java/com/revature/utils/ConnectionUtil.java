package com.revature.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * Singleton utility for creating and retrieving database connection
 */
public class ConnectionUtil {
	private static ConnectionUtil cu = null;
	private static Properties prop;
	private static Connection conn = null;
	//private static String url;//= "jdbc:mysql://localhost:3306/p0";
//	private static String username=null ;
//	private static String password=null ;
	/**
	 * This method should read in the "database.properties" file and load
	 * the values into the Properties variable
	 */
	private ConnectionUtil() {
		
		prop = new Properties();
		
		try {
			File file = new File("/src/main/resources/database.properties");
			FileReader fileReader = new FileReader(file);
//			FileInputStream fileStream = new FileInputStream("/src/main/resources/database.properties"); 
			prop.load(fileReader);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		String url = prop.getProperty("url");	
//		password = prop.getProperty("pswd"); 
//		username = prop.getProperty("usr"); 
		
		
	}
	
	public static synchronized ConnectionUtil getConnectionUtil() {
		if(cu == null)
			cu = new ConnectionUtil();
		return cu;
	}
	
	/**
	 * This method should create and return a Connection object
	 * @return a Connection to the database
	 */
	public static Connection getConnection() {
		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/p0","root" , "aMAZing124");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}
}
