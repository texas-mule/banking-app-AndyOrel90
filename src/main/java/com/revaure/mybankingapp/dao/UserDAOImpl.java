package com.revaure.mybankingapp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.revature.mybankingapp.User;


public class UserDAOImpl implements UserDAO {

	@Override
	public User login(String username, String password) {
		
		User a = new User();
		Connection connection = null;
		PreparedStatement stmt = null;

		try {
			connection = DAOUtilities.getConnection();

			String sql = "SELECT * FROM \"Users\" WHERE username = ? AND password = ?";
			
			stmt = connection.prepareStatement(sql);
			
			stmt.setString(1, username);
			stmt.setString(2, password);
			
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {

				a.setUserid(rs.getLong("userid"));
				a.setFirstname(rs.getString("firstname"));
				a.setLastname(rs.getString("lastname"));
				a.setUsername(rs.getString("username"));
				a.setUsertype(rs.getString("usertype"));
				
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (stmt != null) {
					stmt.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return a;
	}


	@Override
	public ArrayList<User> getUsers() {
		ArrayList<User> users = new ArrayList<>();
		Connection connection = null;
		Statement stmt = null;

		try {
			connection = DAOUtilities.getConnection();

			stmt = connection.createStatement();

			String sql = "SELECT * FROM \"Users\"";

			ResultSet rs = stmt.executeQuery(sql);

			while (rs.next()) {
				User a = new User();
				
				a.setUserid(rs.getLong("userid"));
				a.setFirstname(rs.getString("firstname"));
				a.setLastname(rs.getString("lastname"));
				a.setUsername(rs.getString("username"));
				a.setUsertype(rs.getString("usertype"));
				
				users.add(a);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (stmt != null) {
					stmt.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return users;
	}
	
	public void addUser(User user) {
		
	}

}
