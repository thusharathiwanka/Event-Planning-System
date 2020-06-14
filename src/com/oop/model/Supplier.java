/* K.A.T. Thiwanka
IT19076362 */
package com.oop.model;

//Creating child class which extending User class
public class Supplier extends User {

	//Creating attributes
	private String service;
	
	//Default constructor
	public Supplier() {
		
	}
	
	/*Getter Setters*/
	
	//Returning service
	public String getService() {
		return service;
	}

	//Setting service accepting service as parameter
	public void setService(String service) {
		this.service = service;
	}
	
}
