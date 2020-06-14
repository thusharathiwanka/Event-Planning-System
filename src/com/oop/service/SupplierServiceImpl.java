/* K.A.T. Thiwanka
IT19076362 */
package com.oop.service;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Connection;

import com.oop.model.Supplier;
import com.oop.util.DBConnection;

//Implementing moethods which are on ISupplierService interface
public class SupplierServiceImpl implements ISupplierService {

	//Database connection variable
	private static Connection conn;
	
	//Default constructor
	public SupplierServiceImpl() {
		
		//Database connection
		conn = DBConnection.getConnection();
	}
	
	/* *
	 * Adding supplier's personal details to the user table
	 * Accepting supplier object as parameter
	 * Returning boolean 
	 * Throws SQL Exception 
	 * 	 - When database access error occurs
	 * */
	@Override
	public boolean addSupplierDetails(Supplier supplier) throws SQLException {
		
		//SQL statement for insert values for user table
		String sql = "INSERT INTO user VALUES(?, ?, ?, ?, ?, ?, ?)";
		PreparedStatement state = conn.prepareStatement(sql);
		
		//Setting values to columns
		state.setObject(1, 0);
		state.setObject(2, supplier.getUserName());
		state.setObject(3, supplier.getPassword());
		state.setObject(4, supplier.getEmail());
		state.setObject(5, supplier.getGender());
		state.setObject(6, supplier.getMobileNo());
		state.setObject(7, supplier.getProvince());
		
		//Executing statement
		int ret = state.executeUpdate(); 
		
		//Returning true or false (status of execution)
		return ret > 0;
	}

	/* *
	 * Adding supplier's services to the supplier table
	 * Accepting supplier object as parameter
	 * Returning boolean 
	 * Throws SQL Exception 
	 * 	 - When database access error occurs
	 * */
	@Override
	public boolean addSupplierService(Supplier supplier) throws SQLException {
		
		//SQL statement for insert values for supplier table
		String sql = "INSERT INTO supplier VALUES(?, ?, ?)";
		PreparedStatement state = conn.prepareStatement(sql);
		
		//Setting values to columns
		state.setObject(1, 0);
		state.setObject(2, supplier.getUserName());
		state.setObject(3, supplier.getService());
		
		//Executing statement
		int ret = state.executeUpdate(); 
		
		//Returning true or false (status of execution)
		return ret > 0;
	}

	/* *
	 * Retrieving data from user and supplier tables
	 * Accepting username as parameter
	 * Returning supplier object
	 * SQL Exception is handled in the method 
	 * */
	@Override
	public Supplier showSupplierDetails(String username) {
		
		//Creating supplier object
		Supplier supplier = new Supplier();
		
		//SQL statement for selecting data from user table
		String sql = "SELECT * FROM user WHERE username = ?";
		
		//Handling SQL Exception
		try {
			
			PreparedStatement state = conn.prepareStatement(sql);
			
			//Setting value for username column
			state.setObject(1, username);
			
			//Executing statement
			ResultSet res = state.executeQuery();

			//Setting retrieved values to supplier object 
			res.next();
			supplier.setEmail(res.getString("email"));
			supplier.setGender(res.getString("gender")); 
			supplier.setMobileNo(res.getString("mobileNo"));
			supplier.setProvince(res.getString("province"));
				
		} 
		catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		//SQL statement for selecting data from supplier table
		String sql1 = "SELECT * FROM supplier WHERE username = ?";
		
		try {
			
			PreparedStatement state1 = conn.prepareStatement(sql1);
			
			//Setting value for username column
			state1.setObject(1, username);
			
			//Executing statement
			ResultSet res = state1.executeQuery();

			//Setting retrieved values to customer object 
			res.next();
			supplier.setService(res.getString("services"));
				
		} 
		catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		//Returning supplier object
		return supplier;
	}

	/* *
	 * Updating supplier from user and supplier table
	 * Accepting supplier object as parameter
	 * Returning boolean
	 * Throws SQL Exception 
	 * 	 - When database access error occurs 
	 * */
	@Override
	public boolean updateSupplier(Supplier supplier) throws SQLException {
		
		//SQL statement for update a record for user table
		String sql = "UPDATE user SET password = ?, email = ?, gender = ?, mobileNo = ?, province = ? WHERE username = ?";
		PreparedStatement state = conn.prepareStatement(sql);
		
		//Setting values for columns which needs to be updated (for user table)
		state.setObject(1, supplier.getPassword());
		state.setObject(2, supplier.getEmail());
		state.setObject(3, supplier.getGender());
		state.setObject(4, supplier.getMobileNo());
		state.setObject(5, supplier.getProvince());
		state.setObject(6, supplier.getUserName());
		
		//Executing statement
		state.executeUpdate();
		
		//SQL statement for update a record for customer table
		String sql1 = "UPDATE supplier SET services = ? WHERE username = ?";
		PreparedStatement state1 = conn.prepareStatement(sql1);
		
		//Setting values for columns which needs to be updated (for customer table)
		state1.setObject(1, supplier.getService());
		state1.setObject(2, supplier.getUserName());
		
		//Executing statement
		int ret = state1.executeUpdate();
		
		//Returning true or false (status of execution)
		return ret > 0;
		
	}
	
	/* *
	 * Deleting supplier's service from supplier table
	 * Accepting username as parameter
	 * Returning boolean 
	 * Throws SQL Exception 
	 * 	 - When database access error occurs
	 * */
	@Override
	public boolean deleteSupplierService(String username) throws SQLException {
		
		//SQL statement for delete a record for supplier table
		String sql = "DELETE FROM supplier WHERE username = ?";
		PreparedStatement state = conn.prepareStatement(sql);
		
		//Setting value for username column
		state.setObject(1, username);
		
		//Executing statement
		int ret = state.executeUpdate();
		
		//Returning true or false (status of execution)
		return ret > 0;
	}
	
	/* *
	 * Deleting supplier's personal details from supplier table
	 * Accepting username as parameter
	 * Returning boolean 
	 * Throws SQL Exception 
	 * 	 - When database access error occurs
	 * */
	@Override
	public boolean deleteSupplier(String username) throws SQLException {
		
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

	/* *
	 * Validating supplier's username and password from user table
	 * Accepting supplier object as parameter
	 * Returning supplier object
	 * Throws SQL Exception 
	 * 	 - When database access error occurs
	 * */
	@Override
	public Supplier validateDetails(Supplier supplier) throws SQLException {
		
		//SQL statement for selecting data from user table
		String sql = "SELECT * FROM user WHERE username = ? AND password = ?";
		PreparedStatement state = conn.prepareStatement(sql);
		
		//Setting values for username and password columns
		state.setObject(1, supplier.getUserName());
		state.setObject(2, supplier.getPassword());
		
		//Executing statement 
		ResultSet res = state.executeQuery();
		
		//Setting retrieved values to supplier object 
		res.next();
		supplier.setEmail(res.getString("email"));
		supplier.setGender(res.getString("gender")); 
		supplier.setMobileNo(res.getString("mobileNo"));
		supplier.setProvince(res.getString("province"));
		
		//Returning supplier object
		return supplier;
	}

}
