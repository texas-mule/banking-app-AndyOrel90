package com.revaure.mybankingapp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.revature.mybankingapp.Customer;


public class CustomerDAOImpl implements CustomerDAO {

	@Override
	public Customer login(String username, String password) {
		
		Customer a = new Customer();
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
	public ArrayList<Customer> getCustomers() {
		ArrayList<Customer> customer = new ArrayList<>();
		Connection connection = null;
		Statement stmt = null;

		try {
			connection = DAOUtilities.getConnection();

			stmt = connection.createStatement();

			String sql = "SELECT * FROM \"Users\"";

			ResultSet rs = stmt.executeQuery(sql);

			while (rs.next()) {
				Customer a = new Customer();
				
				a.setUserid(rs.getLong("userid"));
				a.setFirstname(rs.getString("firstname"));
				a.setLastname(rs.getString("lastname"));
				a.setUsername(rs.getString("username"));
				a.setUsertype(rs.getString("usertype"));
				
				customer.add(a);
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

		return customer;
	}


	@Override
	public void addCustomer(Customer customer) {
		// TODO Auto-generated method stub
		
	}

}
