package com.studentrecord.entities;

public class Users {
	private int userId;
	private String userName;
	private String userPhone;
	private String userEmail;
	private String userPass;
	
	public Users() {
		super();
	}

	public Users(int userId, String userName, String userPhone, String userEmail, String userPass) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.userPhone = userPhone;
		this.userEmail = userEmail;
		this.userPass = userPass;
	}

	public Users(String userName, String userPhone, String userEmail, String userPass) {
		super();
		this.userName = userName;
		this.userPhone = userPhone;
		this.userEmail = userEmail;
		this.userPass = userPass;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPhone() {
		return userPhone;
	}

	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getUserPass() {
		return userPass;
	}

	public void setUserPass(String userPass) {
		this.userPass = userPass;
	}
	
	
}
