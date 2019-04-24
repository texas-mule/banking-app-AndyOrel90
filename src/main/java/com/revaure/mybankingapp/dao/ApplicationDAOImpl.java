package com.revaure.mybankingapp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.revature.mybankingapp.Application;

public class ApplicationDAOImpl implements ApplicationDAO {

	private long insertUserWhenApproved(Application application) {
		Connection connection = null;
		PreparedStatement stmt = null;
		long userid = 0;
		int success;
		long result = 0;

		try {
			connection = DAOUtilities.getConnection();
			String sql = "INSERT INTO \"Users\" (firstname, lastname, username, password, usertype) VALUES (?,?,?,?,?);SELECT currval('\"Users_userid_seq\"'::regclass);";

			// Setup PreparedStatement
			stmt = connection.prepareStatement(sql);

			// Add parameters for prepared statement
			stmt.setString(1, application.getFirstname());
			stmt.setString(2, application.getLastname());
			stmt.setString(3, application.getUsername());
			stmt.setString(4, application.getPassword());
			stmt.setString(5, application.getUsertype());

			stmt.execute();

			int nInserted = stmt.getUpdateCount();
			if (nInserted == 1 && stmt.getMoreResults()) {
				ResultSet rs = stmt.getResultSet();
				if (rs.next()) {
					userid = rs.getLong(1);
				}

			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (stmt != null)
					stmt.close();
				if (connection != null)
					connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return userid;
		/*
		 * if (success == 0) { // then update didn't occur, throw an exception //throw
		 * new Exception("Insert User failed: " + application); }
		 */
	}

	private long insertSecondUserWhenApproved(Application application) {
		Connection connection = null;
		PreparedStatement stmt = null;
		long userid = 0;
		int success;
		long result = 0;

		try {
			connection = DAOUtilities.getConnection();
			String sql = "INSERT INTO \"Users\" (firstname, lastname, username, password, usertype) VALUES (?,?,?,?,?);SELECT currval('\"Users_userid_seq\"'::regclass);";

			// Setup PreparedStatement
			stmt = connection.prepareStatement(sql);

			// Add parameters for prepared statement
			stmt.setString(1, application.getFirstname2());
			stmt.setString(2, application.getLastname2());
			stmt.setString(3, application.getUsername2());
			stmt.setString(4, application.getPassword2());
			stmt.setString(5, application.getUsertype());

			stmt.execute();

			int nInserted = stmt.getUpdateCount();
			if (nInserted == 1 && stmt.getMoreResults()) {
				ResultSet rs = stmt.getResultSet();
				if (rs.next()) {
					userid = rs.getLong(1);
				}

			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (stmt != null)
					stmt.close();
				if (connection != null)
					connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return userid;
		/*
		 * if (success == 0) { // then update didn't occur, throw an exception //throw
		 * new Exception("Insert User failed: " + application); }
		 */
	}

	private long insertSecondUserWhenJointApprovedFromCustomer(Application application) {
		Connection connection = null;
		PreparedStatement stmt = null;
		long userid = 0;
		int success;
		long result = 0;

		try {
			connection = DAOUtilities.getConnection();
			String sql = "INSERT INTO \"Users\" (firstname, lastname, username, password, usertype) VALUES (?,?,?,?,?);SELECT currval('\"Users_userid_seq\"'::regclass);";

			// Setup PreparedStatement
			stmt = connection.prepareStatement(sql);

			// Add parameters for prepared statement
			stmt.setString(1, application.getFirstname2());
			stmt.setString(2, application.getLastname2());
			stmt.setString(3, application.getUsername2());
			stmt.setString(4, application.getPassword2());
			stmt.setString(5, "customer");

			stmt.execute();

			int nInserted = stmt.getUpdateCount();
			if (nInserted == 1 && stmt.getMoreResults()) {
				ResultSet rs = stmt.getResultSet();
				if (rs.next()) {
					userid = rs.getLong(1);
				}

			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (stmt != null)
					stmt.close();
				if (connection != null)
					connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return userid;
		/*
		 * if (success == 0) { // then update didn't occur, throw an exception //throw
		 * new Exception("Insert User failed: " + application); }
		 */
	}

	public void insertAccountWhenApproved(Application application, long userid) {
		Connection connection = null;
		PreparedStatement stmt = null;
		int success;

		try {
			connection = DAOUtilities.getConnection();
			String sql = "INSERT INTO \"Accounts\" (ownerid1, ownerid2, routingnumber, accountbalance, accounttype, accountstatus) VALUES (?,?,?,?,?,?)";

			// Setup PreparedStatement
			stmt = connection.prepareStatement(sql);

			// Add parameters for prepared statement
			stmt.setLong(1, userid);
			stmt.setLong(2, 0);
			stmt.setLong(3, 121042882);
			stmt.setLong(4, application.getDepositamount());
			stmt.setString(5, application.getAccounttype());
			stmt.setString(6, "active");

			success = stmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (stmt != null)
					stmt.close();
				if (connection != null)
					connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		/*
		 * if (success == 0) { // then update didn't occur, throw an exception //throw
		 * new Exception("Insert User failed: " + application); }
		 */
	}

	public void insertBothUsersToAccountWhenApproved(Application application, long userid, long userid2) {
		Connection connection = null;
		PreparedStatement stmt = null;
		int success;

		try {
			connection = DAOUtilities.getConnection();
			String sql = "INSERT INTO \"Accounts\" (ownerid1, ownerid2, routingnumber, accountbalance, accounttype, accountstatus) VALUES (?,?,?,?,?,?)";

			// Setup PreparedStatement
			stmt = connection.prepareStatement(sql);

			// Add parameters for prepared statement
			stmt.setLong(1, userid);
			stmt.setLong(2, userid2);
			stmt.setLong(3, 121042882);
			stmt.setLong(4, application.getDepositamount());
			stmt.setString(5, application.getAccounttype());
			stmt.setString(6, "active");

			success = stmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (stmt != null)
					stmt.close();
				if (connection != null)
					connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		/*
		 * if (success == 0) { // then update didn't occur, throw an exception //throw
		 * new Exception("Insert User failed: " + application); }
		 */
	}

	public void saveNewApplication(Application application) {

		Connection connection = null;
		PreparedStatement stmt = null;
		int success = 0;

		try {
			connection = DAOUtilities.getConnection();
			String sql = "INSERT INTO \"Applications\" (firstname, lastname, username, password, usertype, accounttype, depositamount, status) VALUES (?,?,?,?,?,?,?,?)";

			// Setup PreparedStatement
			stmt = connection.prepareStatement(sql);

			// Add parameters for prepared statement

			stmt.setString(1, application.getFirstname());
			stmt.setString(2, application.getLastname());
			stmt.setString(3, application.getUsername());
			stmt.setString(4, application.getPassword());
			stmt.setString(5, application.getUsertype());
			stmt.setString(6, application.getAccounttype());
			stmt.setLong(7, application.getDepositamount());
			stmt.setString(8, application.getStatus());

			success = stmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (stmt != null)
					stmt.close();
				if (connection != null)
					connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		/*
		 * if (success == 0) { // then update didn't occur, throw an exception //throw
		 * new Exception("Insert Application failed: " + application); }
		 */

	}

	public void saveNewJointApplication(Application application) {

		Connection connection = null;
		PreparedStatement stmt = null;
		int success = 0;

		try {
			connection = DAOUtilities.getConnection();
			String sql = "INSERT INTO \"Applications\" (firstname, lastname, username, password, usertype, accounttype, depositamount, status, firstname2, lastname2, username2, password2) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";

			// Setup PreparedStatement
			stmt = connection.prepareStatement(sql);

			// Add parameters for prepared statement

			stmt.setString(1, application.getFirstname());
			stmt.setString(2, application.getLastname());
			stmt.setString(3, application.getUsername());
			stmt.setString(4, application.getPassword());
			stmt.setString(5, application.getUsertype());
			stmt.setString(6, application.getAccounttype());
			stmt.setLong(7, application.getDepositamount());
			stmt.setString(8, application.getStatus());
			stmt.setString(9, application.getFirstname2());
			stmt.setString(10, application.getLastname2());
			stmt.setString(11, application.getUsername2());
			stmt.setString(12, application.getPassword2());

			success = stmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (stmt != null)
					stmt.close();
				if (connection != null)
					connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		/*
		 * if (success == 0) { // then update didn't occur, throw an exception //throw
		 * new Exception("Insert Application failed: " + application); }
		 */

	}

	public void saveNewJointApplicationFromUser(Application application) {

		Connection connection = null;
		PreparedStatement stmt = null;
		int success = 0;

		try {
			connection = DAOUtilities.getConnection();
			String sql = "INSERT INTO \"Applications\" (firstname, lastname, username, password, usertype, accounttype, depositamount, status, firstname2, lastname2, username2, password2) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";

			// Setup PreparedStatement
			stmt = connection.prepareStatement(sql);

			// Add parameters for prepared statement

			stmt.setString(1, application.getFirstname());
			stmt.setString(2, application.getLastname());
			stmt.setString(3, application.getUsername());
			stmt.setString(4, application.getPassword());
			stmt.setString(5, application.getUsertype());
			stmt.setString(6, application.getAccounttype());
			stmt.setLong(7, application.getDepositamount());
			stmt.setString(8, application.getStatus());
			stmt.setString(9, application.getFirstname2());
			stmt.setString(10, application.getLastname2());
			stmt.setString(11, application.getUsername2());
			stmt.setString(12, application.getPassword2());

			success = stmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (stmt != null)
					stmt.close();
				if (connection != null)
					connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		/*
		 * if (success == 0) { // then update didn't occur, throw an exception //throw
		 * new Exception("Insert Application failed: " + application); }
		 */

	}

	public void saveNewApplicationFromUser(Application application) {

		Connection connection = null;
		PreparedStatement stmt = null;
		int success = 0;

		try {
			connection = DAOUtilities.getConnection();
			String sql = "INSERT INTO \"Applications\" (firstname, lastname, username, password, usertype, accounttype, depositamount, status, currentuser) VALUES (?,?,?,?,?,?,?,?,?)";

			// Setup PreparedStatement
			stmt = connection.prepareStatement(sql);

			// Add parameters for prepared statement

			stmt.setString(1, application.getFirstname());
			stmt.setString(2, application.getLastname());
			stmt.setString(3, application.getUsername());
			stmt.setString(4, application.getPassword());
			stmt.setString(5, application.getUsertype());
			stmt.setString(6, application.getAccounttype());
			stmt.setLong(7, application.getDepositamount());
			stmt.setString(8, application.getStatus());
			stmt.setLong(9, application.getCurrentuser());

			success = stmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (stmt != null)
					stmt.close();
				if (connection != null)
					connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		/*
		 * if (success == 0) { // then update didn't occur, throw an exception //throw
		 * new Exception("Insert Application failed: " + application); }
		 */

	}

	public void approveApplication(Application application) {

		Connection connection = null;
		PreparedStatement stmt = null;
		int success = 0;
		long userid;
		long userid2;

		try {
			connection = DAOUtilities.getConnection();

			String sql = "UPDATE \"Applications\" SET status = ? WHERE applicationid = ?;";

			// Setup PreparedStatement
			stmt = connection.prepareStatement(sql);

			// Add parameters for prepared statement
			stmt.setString(1, "approved");

			stmt.setLong(2, application.getApplicationid());

			success = stmt.executeUpdate();

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

		
		if (application.getIsjointaccount()) {
			
			switch (application.getStatus()) {
			case "jointapplied":
				userid = this.insertUserWhenApproved(application);
				userid2 = this.insertSecondUserWhenApproved(application);
				this.insertBothUsersToAccountWhenApproved(application, userid, userid2);
				break;
			case "jointappliedfromcustomer":
				userid = application.getCurrentuser();
				userid2 = this.insertSecondUserWhenApproved(application);
				this.insertBothUsersToAccountWhenApproved(application, userid, userid2);
				break;
			default:
				userid = this.insertUserWhenApproved(application);
				this.insertAccountWhenApproved(application, userid);
			}

		} else {
			userid = this.insertUserWhenApproved(application);
			this.insertAccountWhenApproved(application, userid);
		}

	}

	public void approveCustomerApplication(Application application) {

		Connection connection = null;
		PreparedStatement stmt = null;
		int success = 0;
		long userid;

		try {
			connection = DAOUtilities.getConnection();

			String sql = "UPDATE \"Applications\" SET status = ? WHERE applicationid = ?;";

			// Setup PreparedStatement
			stmt = connection.prepareStatement(sql);

			// Add parameters for prepared statement
			stmt.setString(1, "approved");

			stmt.setLong(2, application.getApplicationid());

			success = stmt.executeUpdate();

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

		this.insertAccountWhenApproved(application, application.getCurrentuser());
	}

	public void denyApplication(Application application) {

		Connection connection = null;
		PreparedStatement stmt = null;

		try {
			connection = DAOUtilities.getConnection();

			String sql = "UPDATE \"Applications\" SET status = ? WHERE applicationid = ?;";

			// Setup PreparedStatement
			stmt = connection.prepareStatement(sql);

			// Add parameters for prepared statement
			stmt.setString(1, "denied");

			stmt.setLong(2, application.getApplicationid());

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

	}

	public ArrayList<Application> getApplications() {

		ArrayList<Application> apps = new ArrayList<>();
		Connection connection = null;
		Statement stmt = null;

		try {
			connection = DAOUtilities.getConnection();

			stmt = connection.createStatement();

			String sql = "SELECT * FROM \"Applications\"";

			ResultSet rs = stmt.executeQuery(sql);

			while (rs.next()) {
				Application a = new Application();

				a.setApplicationid(rs.getLong("applicationid"));
				a.setFirstname(rs.getString("firstname"));
				a.setLastname(rs.getString("lastname"));
				a.setUsername(rs.getString("username"));
				a.setPassword(rs.getString("password"));
				a.setUsertype(rs.getString("usertype"));
				a.setAccounttype(rs.getString("accounttype"));
				a.setDepositamount(rs.getLong("depositamount"));
				a.setStatus(rs.getString("status"));
				a.setCurrentuser(rs.getLong("currentuser"));

				if (a.getStatus().equals(new String("jointapplied"))
						|| a.getStatus().equals(new String("jointappliedfromcustomer"))) {
					a.setFirstname2(rs.getString("firstname2"));
					a.setLastname2(rs.getString("lastname2"));
					a.setUsername2(rs.getString("username2"));
					a.setPassword2(rs.getString("password2"));
					a.setIsjointaccount(true);
				}

				apps.add(a);
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

		return apps;
	}

}
