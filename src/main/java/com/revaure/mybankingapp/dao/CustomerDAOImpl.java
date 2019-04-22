package com.revaure.mybankingapp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.revature.mybankingapp.Account;
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

	public String withdraw(Account account, long amount) {

		long newaccountbalance = account.getAccountbalance() - amount;

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

			return "The amount of: " + amount + " has been withdraw from Account Number: " + account.getAccountnumber()
					+ "\nYour new account balance is: " + newaccountbalance;
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

				String sql = "UPDATE \"Accounts\" SET accountbalance = ? WHERE accountnumber = ?;";

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

				String sql = "UPDATE \"Accounts\" SET accountbalance = accountbalance + ? WHERE accountnumber = ?;";

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

			return "The amount of: " + amount + " has been successfully transfered.\nYour new account balance is: "
					+ newfromaccountbalance;
		}
	}

	public String deposit(Account account, long amount) {
		long newaccountbalance = account.getAccountbalance() + amount;

		Connection connection = null;
		PreparedStatement stmt = null;

		try {
			connection = DAOUtilities.getConnection();

			String sql = "UPDATE \"Accounts\" SET accountbalance = ? WHERE accountnumber = ?;";

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

		return "The amount of: " + amount + " has been deposited to Account Number: " + account.getAccountnumber()
				+ "\nYour new account balance is: " + newaccountbalance;

	}

	public ArrayList<Account> getThisCustomerAccounts(long customerid) {
		ArrayList<Account> accounts = new ArrayList<>();
		Connection connection = null;
		PreparedStatement stmt = null;

		try {
			connection = DAOUtilities.getConnection();

			String sql = "SELECT * FROM \"Accounts\" WHERE ownerid1 = ? AND accountstatus = 'active'";

			stmt = connection.prepareStatement(sql);

			// Add parameters for prepared statement
			stmt.setLong(1, customerid);

			//ResultSet rs = stmt.executeQuery(sql);
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				Account a = new Account();

				a.setAccountnumber(rs.getLong("accountnumber"));
				a.setOwnerid1(rs.getLong("ownerid1"));
				a.setOwnerid2(rs.getLong("ownerid2"));
				a.setRoutingnumber(rs.getLong("routingnumber"));
				a.setAccountbalance(rs.getLong("accountbalance"));
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
