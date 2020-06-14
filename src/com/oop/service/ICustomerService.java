/* K.A.T. Thiwanka
IT19076362 */
package com.oop.service;

import java.sql.SQLException;

import com.oop.model.Customer;

public interface ICustomerService {

	/* *
	 * Add customer's personal details
	 * Accept customer object as parameter
	 * Return boolean 
	 * */
	boolean addCustomerDetails(Customer customer) throws SQLException;
	
	/* *
	 * Add customer's interest
	 * Accept customer object as parameter
	 * Return boolean 
	 * */
	boolean addCustomerInterest(Customer customer) throws SQLException;
	
	/* *
	 * Retrieve data of specific customer
	 * Accept username as parameter
	 * Return customer object 
	 * */
	Customer showCustomerDetails(String username);
	
	/* *
	 * Update specific customer
	 * Accept customer object as parameter
	 * Return boolean
	 * */
	boolean updateCustomer(Customer customer) throws SQLException;
	
	/* *
	 * Delete specific customer's interest
	 * Accept username as parameter
	 * Return boolean 
	 * */
	boolean deleteCustomerInterest(String username) throws SQLException;

	/* *
	 * Delete specific customer's personal details
	 * Accept username as parameter
	 * Return boolean 
	 * */
	boolean deleteCustomer(String username) throws SQLException;

}
