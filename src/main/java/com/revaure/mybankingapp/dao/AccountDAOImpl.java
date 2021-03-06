package com.revaure.mybankingapp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.revature.mybankingapp.Account;


public class AccountDAOImpl implements AccountDAO {
	
	private static final Logger log = Logger.getLogger(AccountDAOImpl.class.getName());

	public String withdraw(Account account, double amount) {
		log.info("Hello this is an info message");
		double newaccountbalance = account.getAccountbalance() - amount;
		
		if (newaccountbalance < 0) {
			return "Cannot withdraw an amount larger than your account balance";
		} else {
			Connection connection = null;
			PreparedStatement stmt = null;

			try {
				connection = DAOUtilities.getConnection();

				String sql = "UPDATE \"Accounts\" SET accountbalance = ? WHERE accountnumber = ?;";

				// Setup PreparedStatement
				stmt = connection.prepareStatement(sql);

				// Add parameters for prepared statement
				stmt.setDouble(1, newaccountbalance);

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
			
			log.info("Account: " + account.getAccountnumber() + " was withdrawn the amount of " + amount + " New Balance is: " + newaccountbalance);
			
			return "The amount of: " + amount + " has been withdraw from Account Number: " + account.getAccountnumber() + "\nYour new account balance is: " + newaccountbalance;
		}

	}

	public String transfer(double amount, Account fromaccount, long toaccountnumber) {
		
		double newfromaccountbalance = fromaccount.getAccountbalance() - amount;

		if (newfromaccountbalance < 0) {
			return "Cannot withdraw an amount larger than your account balance";
		} else {
			Connection connection = null;
			PreparedStatement stmt = null;

			try {
				connection = DAOUtilities.getConnection();

				String sql = "UPDATE \"Accounts\" SET accountbalance = ? WHERE accountnumber = ?;";

				// Setup PreparedStatement
				stmt = connection.prepareStatement(sql);

				// Add parameters for prepared statement
				stmt.setDouble(1, newfromaccountbalance);

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

				String sql = "UPDATE \"Accounts\" SET accountbalance = accountbalance + ? WHERE accountnumber = ?;";

				// Setup PreparedStatement
				stmt = connection.prepareStatement(sql);

				// Add parameters for prepared statement
				stmt.setDouble(1, amount);

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
			
			log.info("Account: " + fromaccount.getAccountnumber() + " transfered the amount of " + amount + " to Account: " + toaccountnumber);

			return "The amount of: " + amount + " has been successfully transfered.\nYour new account balance is: " + newfromaccountbalance;
		}
	}

	public String deposit(Account account, double amount) {
		double newaccountbalance = account.getAccountbalance() + amount;

		Connection connection = null;
		PreparedStatement stmt = null;

		try {
			connection = DAOUtilities.getConnection();

			String sql = "UPDATE \"Accounts\" SET accountbalance = ? WHERE accountnumber = ?;";

			// Setup PreparedStatement
			stmt = connection.prepareStatement(sql);

			// Add parameters for prepared statement
			stmt.setDouble(1, newaccountbalance);

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
		
		log.info("Account: " + account.getAccountnumber() + " was deposited the amount of " + amount + " New Balance is: " + newaccountbalance);
		
		return "The amount of: " + amount + " has been deposited to Account Number: " + account.getAccountnumber() + "\nYour new account balance is: " + newaccountbalance;

	}
	
	public String cancel(Account account) {
		Connection connection = null;
		PreparedStatement stmt = null;

		try {
			connection = DAOUtilities.getConnection();

			String sql = "UPDATE \"Accounts\" SET accountstatus = 'canceled' WHERE accountnumber = ?;";

			// Setup PreparedStatement
			stmt = connection.prepareStatement(sql);

			// Add parameters for prepared statement
			stmt.setLong(1, account.getAccountnumber());

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
		
		return "Account Number: " + account.getAccountnumber() + " has been canceled";

	}
	
	public ArrayList<Account> getAccounts(){
			
			ArrayList<Account> accounts = new ArrayList<>();
			Connection connection = null;
			Statement stmt = null;

			try {
				connection = DAOUtilities.getConnection();

				stmt = connection.createStatement();

				String sql = "SELECT * FROM \"Accounts\"";

				ResultSet rs = stmt.executeQuery(sql);

				while (rs.next()) {
					Account a = new Account();
					
					a.setAccountnumber(rs.getLong("accountnumber"));
					a.setOwnerid1(rs.getLong("ownerid1"));
					a.setOwnerid2(rs.getLong("ownerid2"));
					a.setRoutingnumber(rs.getLong("routingnumber"));
					a.setAccountbalance(rs.getDouble("accountbalance"));
					a.setAccounttype(rs.getString("accounttype"));
					
					accounts.add(a);
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

			return accounts;
	
	}

}
