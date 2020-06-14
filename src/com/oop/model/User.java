/* K.A.T. Thiwanka
IT19076362 */
package com.oop.model;

//Creating parent class
public class User {
	
	//Creating attributes
	private String userId;
	private String userName;
	private String password;
	private String email;
	private String gender;
	private String mobileNo;
	private String province;
	
	//Default constructor
	public User() {
		
	}
	
	//Parameterized constructor
	public User(String userId, String userName, String password, String email, String gender, String mobileNo,
			String province) {
		this.userId = userId;
		this.userName = userName;
		this.password = password;
		this.email = email;
		this.gender = gender;
		this.mobileNo = mobileNo;
		this.province = province;
	}
	
	/*Getters and setters*/
	
	//Returning userId
	public String getUserId() {
		return userId;
	}
	
	//Setting userId accepting userId as parameter
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	//Returning userName
	public String getUserName() {
		return userName;
	}
	
	//Setting userName accepting userName as parameter
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	//Returning password
	public String getPassword() {
		return password;
	}

	//Setting password accepting password as parameter
	public void setPassword(String password) {
		this.password = password;
	}

	//Returning email
	public String getEmail() {
		return email;
	}
	
	//Setting email accepting email as parameter
	public void setEmail(String email) {
		this.email = email;
	}
	
	//Returning gender
	public String getGender() {
		return gender;
	}

	//Setting gender accepting gender as parameter
	public void setGender(String gender) {
		this.gender = gender;
	}

	//Returning mobileNo
	public String getMobileNo() {
		return mobileNo;
	}
	
	//Setting mobileNo accepting mobileNo as parameter
	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	//Returning province
	public String getProvince() {
		return province;
	}

	//Setting province accepting province as parameter
	public void setProvince(String province) {
		this.province = province;
	}
	
}
