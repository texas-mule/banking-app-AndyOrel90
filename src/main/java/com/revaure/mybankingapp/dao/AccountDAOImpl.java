package com.revaure.mybankingapp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.revature.mybankingapp.Account;

public class AccountDAOImpl implements AccountDAO {

	public String withdraw(Account account, long amount) {

		long newaccountbalance = account.getAccountbalance() - amount;

		if (newaccountbalance < 0) {
			return "Cannot withdraw an amount larger than your account balance";
		} else {
			Connection connection = null;
			PreparedStatement stmt = null;

			try {
				connection = DAOUtilities.getConnection();

				String sql = "UPDATE \"Account\" SET accountbalance = ? WHERE accountnumber = ?;";

				// Setup PreparedStatement
				stmt = connection.prepareStatement(sql);

				// Add parameters for prepared statement
				stmt.setLong(1, newaccountbalance);

				stmt.setLong(2, account.getAccountnumber());

				stmt.executeUpdate();

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

			account.setAccountbalance(newaccountbalance);
			return "Your new account balance is: " + newaccountbalance;
		}

	}

	public String transfer(long amount, Account fromaccount, long toaccountnumber) {
		
		long newfromaccountbalance = fromaccount.getAccountbalance() - amount;

		if (newfromaccountbalance < 0) {
			return "Cannot withdraw an amount larger than your account balance";
		} else {
			Connection connection = null;
			PreparedStatement stmt = null;

			try {
				connection = DAOUtilities.getConnection();

				String sql = "UPDATE \"Account\" SET accountbalance = ? WHERE accountnumber = ?;";

				// Setup PreparedStatement
				stmt = connection.prepareStatement(sql);

				// Add parameters for prepared statement
				stmt.setLong(1, newfromaccountbalance);

				stmt.setLong(2, fromaccount.getAccountnumber());

				stmt.executeUpdate();

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
			
			try {
				connection = DAOUtilities.getConnection();

				String sql = "UPDATE \"Account\" SET accountbalance = accountbalance + ? WHERE accountnumber = ?;";

				// Setup PreparedStatement
				stmt = connection.prepareStatement(sql);

				// Add parameters for prepared statement
				stmt.setLong(1, amount);

				stmt.setLong(2, toaccountnumber);

				stmt.executeUpdate();

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

			fromaccount.setAccountbalance(newfromaccountbalance);

			return "The amount of: " + amount + "has been successfully transfered.\nYour new account balance is: " + newfromaccountbalance;
		}
	}

	public String deposit(Account account, long amount) {
		long newaccountbalance = account.getAccountbalance() + amount;

		Connection connection = null;
		PreparedStatement stmt = null;

		try {
			connection = DAOUtilities.getConnection();

			String sql = "UPDATE \"Account\" SET accountbalance = ? WHERE accountnumber = ?;";

			// Setup PreparedStatement
			stmt = connection.prepareStatement(sql);

			// Add parameters for prepared statement
			stmt.setLong(1, newaccountbalance);

			stmt.setLong(2, account.getAccountnumber());

			stmt.executeUpdate();

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

		return "Your new account balance is: " + newaccountbalance;

	}
}
