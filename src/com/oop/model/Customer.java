/* K.A.T. Thiwanka
IT19076362 */
package com.oop.model;

//Creating child class which extending User class
public class Customer extends User {
	
	//Creating attributes
	private String interest;
	
	//Default constructor
	public Customer() {
		
	}

	/*Getter Setters*/
	
	//Returning interest
	public String getInterest() {
		return interest;
	}
	
	//Setting interest accepting interest as parameter
	public void setInterest(String interest) {
		this.interest = interest;
	}
	
}
