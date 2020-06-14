/* K.A.T. Thiwanka
IT19076362 */
package com.oop.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

	//Database connection variable
	private static Connection conn;
	
	//Database connection method implementaion
	public static Connection getConnection() {
		
		//Checking variable is null or not
		if(conn == null) {
			
			//Handling SQL Exception and ClassNotFound Exception
			try {
				
				//Creating database connection using url, username and password
				Class.forName("com.mysql.jdbc.Driver");
				conn = DriverManager.getConnection("jdbc:mysql://localhost:3307/eventdb", "root", "root");
			
			} 
			catch (SQLException | ClassNotFoundException e) {
				
				e.printStackTrace();
			}
			
			System.out.println("Database Connected");
			System.out.println();
		}
		
		return conn;
		
	}
	
}
