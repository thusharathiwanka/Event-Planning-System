/* K.A.T. Thiwanka
IT19076362 */
package com.oop.service;

import java.sql.SQLException;

import com.oop.model.Supplier;

public interface ISupplierService {
	
	/* *
	 * Add supplier's personal details
	 * Accept supplier object as parameter
	 * Return boolean 
	 * */
	boolean addSupplierDetails(Supplier supplier) throws SQLException;
	
	/* *
	 * Add supplier's service
	 * Accept supplier object as parameter
	 * Return boolean 
	 * */
	boolean addSupplierService(Supplier supplier) throws SQLException;
	
	/* *
	 * Retrieve data of specific supplier
	 * Accept username as parameter
	 * Return supplier object 
	 * */
	Supplier showSupplierDetails(String username);

	/* *
	 * Update specific supplier
	 * Accept supplier object as parameter
	 * Return boolean
	 * */
	boolean updateSupplier(Supplier supplier) throws SQLException;
	
	/* *
	 * Delete specific supplier's service
	 * Accept username as parameter
	 * Return boolean 
	 * */
	boolean deleteSupplierService(String username) throws SQLException;
	
	/* *
	 * Delete specific supplier's personal details
	 * Accept username as parameter
	 * Return boolean 
	 * */
	boolean deleteSupplier(String username) throws SQLException;

	/* *
	 * Validate specific supplier's username and password
	 * Accept suuplier object as parameter
	 * Return supplier object 
	 * */
	Supplier validateDetails(Supplier supplier) throws SQLException;
	
}
