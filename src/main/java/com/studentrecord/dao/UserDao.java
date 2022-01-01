package com.studentrecord.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.apache.catalina.User;

import com.studentrecord.entities.Users;

public class UserDao {
	
	private Connection con;

	public UserDao(Connection con) {
		super();
		this.con = con;
	}
	
	public void saveUser (Users user) {
		
		try {
			
			String query = "insert into memberlist(memberName, memberPhone, memberEmail, memberPass) values(?, ?, ?, ?)";
			PreparedStatement pstm = con.prepareStatement(query);
			pstm.setString(1, user.getUserName());
			pstm.setString(2, user.getUserPhone());
			pstm.setString(3, user.getUserEmail());
			pstm.setString(4, user.getUserPass());
			
			pstm.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public Users getUserDetails (String email, String password) {
		
		Users u = null;
		
		try {
			
			String query = "select * from memberlist where memberEmail=? and memberPass=?";
			PreparedStatement pstm = con.prepareStatement(query);
			pstm.setString(1, email);
			pstm.setString(2, password);
			
			ResultSet rs = pstm.executeQuery();
			
			if(rs.next()) {
				u = new Users();
				
				u.setUserName(rs.getString("memberName"));
				u.setUserPhone(rs.getString("memberPhone"));
				u.setUserEmail(rs.getString("memberEmail"));
				u.setUserPass(rs.getString("memberPass"));
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return u;
	}
	
	public void deleteUser (int userID) {
		try {
			String query = "delete from memberlist where memberID=?";
			PreparedStatement pstm = con.prepareStatement(query);
			pstm.setInt(1, userID);
			pstm.executeUpdate();
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
public Users getUserDetailsByID (int userID) {
		
		Users u = null;
		
		try {
			
			String query = "select * from memberlist where memberID=?";
			PreparedStatement pstm = con.prepareStatement(query);
			pstm.setInt(1, userID);
			
			ResultSet rs = pstm.executeQuery();
			
			if(rs.next()) {
				u = new Users();
				u.setUserId(userID);
				u.setUserName(rs.getString("memberName"));
				u.setUserPhone(rs.getString("memberPhone"));
				u.setUserEmail(rs.getString("memberEmail"));
				u.setUserPass(rs.getString("memberPass"));
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return u;
	}

	public void editUser(Users u) {
		try {
			String query = "update memberlist set memberName=?, memberPhone=?, memberEmail=?, memberPass=? where memberID=?;";
			PreparedStatement pstm = con.prepareStatement(query);
			pstm.setString(1, u.getUserName());
			pstm.setString(2, u.getUserPhone());
			pstm.setString(3, u.getUserEmail());
			pstm.setString(4, u.getUserPass());
			pstm.setInt(5, u.getUserId());
			
			pstm.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
}
