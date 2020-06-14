/* K.A.T. Thiwanka
IT19076362 */
package com.oop.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.oop.model.Customer;
import com.oop.util.DBConnection;

//Implementing methods which are on ICustomerService interface
public class CustomerServiceImpl implements ICustomerService {

	//Database connection variable
	private static Connection conn;
	
	//Default constructor
	public CustomerServiceImpl() {
		
		//Database connection
		conn = DBConnection.getConnection();	
	}
	
	/* *
	 * Adding customer's personal details to the user table
	 * Accepting customer object as parameter
	 * Returning boolean 
	 * Throws SQL Exception 
	 * 	 - When database access error occurs
	 * */
	@Override
	public boolean addCustomerDetails(Customer customer) throws SQLException {
		
		//SQL statement for insert values for user table
		String sql = "INSERT INTO user VALUES(?, ?, ?, ?, ?, ?, ?)";
		PreparedStatement state = conn.prepareStatement(sql);
		
		//Setting values to columns
		state.setObject(1, 0);
		state.setObject(2, customer.getUserName());
		state.setObject(3, customer.getPassword());
		state.setObject(4, customer.getEmail());
		state.setObject(5, customer.getGender());
		state.setObject(6, customer.getMobileNo());
		state.setObject(7, customer.getProvince());
		
		//Executing statement
		int ret = state.executeUpdate(); 
		
		//Returning true or false (status of execution)
		return ret > 0;
	}

	/* *
	 * Adding customer's interests to the customer table
	 * Accepting customer object as parameter
	 * Returning boolean 
	 * Throws SQL Exception 
	 * 	 - When database access error occurs
	 * */
	@Override
	public boolean addCustomerInterest(Customer customer) throws SQLException {
		
		//SQL statement for insert values for customer table
		String sql = "INSERT INTO customer VALUES(?, ?, ?)";
		PreparedStatement state = conn.prepareStatement(sql);
		
		//Setting values to columns
		state.setObject(1, 0);
		state.setObject(2, customer.getUserName());
		state.setObject(3, customer.getInterest());
		
		//Executing statement
		int ret = state.executeUpdate(); 
		
		//Returning true or false (status of execution)
		return ret > 0;
	}
	
	/* *
	 * Retrieving data from user and customer tables
	 * Accepting username as parameter
	 * Returning customer object
	 * SQL Exception is handled in the method 
	 * */
	@Override
	public Customer showCustomerDetails(String username) {
		
		//Creating customer object
		Customer customer = new Customer();
		
		//SQL statement for selecting data from user table
		String sql = "SELECT * FROM user WHERE username = ?";
		
		//Handling SQL Exception
		try {
			
			PreparedStatement state = conn.prepareStatement(sql);
			
			//Setting value for username column
			state.setObject(1, username);
			
			//Executing statement 
			ResultSet res = state.executeQuery();

			//Setting retrieved values to customer object 
			res.next();
			customer.setEmail(res.getString("email"));
			customer.setGender(res.getString("gender")); 
			customer.setMobileNo(res.getString("mobileNo"));
			customer.setProvince(res.getString("province"));
				
		} 
		catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		//SQL statement for selecting data from customer table
		String sql1 = "SELECT * FROM customer WHERE username = ?";
		
		try {
			
			PreparedStatement state1 = conn.prepareStatement(sql1);
			
			//Setting value for username column
			state1.setObject(1, username);
			
			//Executing statement 
			ResultSet res = state1.executeQuery();

			//Setting retrieved values to customer object 
			res.next();
			customer.setInterest(res.getString("interest"));
				
		} 
		catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		//Returning customer object
		return customer;
	}

	/* *
	 * Updating customer from user and customer table
	 * Accepting customer object as parameter
	 * Returning boolean
	 * Throws SQL Exception 
	 * 	 - When database access error occurs 
	 * */
	@Override
	public boolean updateCustomer(Customer customer) throws SQLException {
		
		//SQL statement for update a record for user table
		String sql = "UPDATE user SET password = ?, email = ?, gender = ?, mobileNo = ?, province = ? WHERE username = ?";
		PreparedStatement state = conn.prepareStatement(sql);
		
		//Setting values for columns which needs to be updated (for user table)
		state.setObject(1, customer.getPassword());
		state.setObject(2, customer.getEmail());
		state.setObject(3, customer.getGender());
		state.setObject(4, customer.getMobileNo());
		state.setObject(5, customer.getProvince());
		state.setObject(6, customer.getUserName());
		
		//Executing statement
		state.executeUpdate();
		
		//SQL statement for update a record for customer table
		String sql1 = "UPDATE customer SET interest = ? WHERE username = ?";
		PreparedStatement state1 = conn.prepareStatement(sql1);
		
		//Setting values for columns which needs to be updated (for customer table)
		state1.setObject(1, customer.getInterest());
		state1.setObject(2, customer.getUserName());
		
		//Executing statement
		int ret = state1.executeUpdate();
		
		//Returning true or false (status of execution)
		return ret > 0;
	}
	
	/* *
	 * Deleting customer's interest from customer table
	 * Accepting username as parameter
	 * Returning boolean 
	 * Throws SQL Exception 
	 * 	 - When database access error occurs
	 * */
	@Override
	public boolean deleteCustomerInterest(String username) throws SQLException {
		
		//SQL statement for delete a record for customer table
		String sql = "DELETE FROM customer WHERE username = ?";
		PreparedStatement state = conn.prepareStatement(sql);
		
		//Setting value for username column
		state.setObject(1, username);
		
		//Executing statement
		int ret = state.executeUpdate();
		
		//Returning true or false (status of execution)
		return ret > 0;
	}

	/* *
	 * Deleting customer's personal details from customer table
	 * Accepting username as parameter
	 * Returning boolean 
	 * Throws SQL Exception 
	 * 	 - When database access error occurs
	 * */
	@Override
	public boolean deleteCustomer(String username) throws SQLException {
		
		//SQL statement for delete a record for user table
		String sql = "DELETE FROM user WHERE username = ?";
		PreparedStatement state = conn.prepareStatement(sql);
		
		//Setting value for username column
		state.setObject(1, username);
		
		//Executing statement
		int ret = state.executeUpdate();
		
		//Returning true or false (status of execution)
		return ret > 0;
	}

}
