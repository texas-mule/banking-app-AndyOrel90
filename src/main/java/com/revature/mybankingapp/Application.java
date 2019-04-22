package com.revature.mybankingapp;

import com.revaure.mybankingapp.dao.ApplicationDAOImpl;

public class Application {
	long applicationid;
	String firstname;
	String lastname;
	String username;
	String password;
	String usertype;
	String accounttype;
	long depositamount;
	String status;
	long currentuser;

	public long getCurrentuser() {
		return currentuser;
	}

	public void setCurrentuser(long currentuser) {
		this.currentuser = currentuser;
	}

	@Override
	public String toString() {
		return "Application [applicationid=" + applicationid + ", firstname=" + firstname + ", lastname=" + lastname
				+ ", username=" + username + ", password=" + password + ", usertype=" + usertype + ", accounttype="
				+ accounttype + ", depositamount=" + depositamount + ", status=" + status + "]";
	}

	public Application(long applicationid, String firstname, String lastname, String username, String password,
			String usertype, String accounttype, long depositamount, String status) {
		super();
		this.applicationid = applicationid;
		this.firstname = firstname;
		this.lastname = lastname;
		this.username = username;
		this.password = password;
		this.usertype = usertype;
		this.accounttype = accounttype;
		this.depositamount = depositamount;
		this.status = status;
	}

	public Application() {
		// TODO Auto-generated constructor stub
	}

	public long getApplicationid() {
		return applicationid;
	}

	public void setApplicationid(long applicationid) {
		this.applicationid = applicationid;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsertype() {
		return usertype;
	}

	public void setUsertype(String usertype) {
		this.usertype = usertype;
	}

	public String getAccounttype() {
		return accounttype;
	}

	public void setAccounttype(String accounttype) {
		this.accounttype = accounttype;
	}

	public long getDepositamount() {
		return depositamount;
	}

	public void setDepositamount(long depositamount) {
		this.depositamount = depositamount;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public void saveNewApplication() {

		ApplicationDAOImpl dao = new ApplicationDAOImpl();
		dao.saveNewApplication(this);

	}

	public void saveNewApplicationFromUser() {

		ApplicationDAOImpl dao = new ApplicationDAOImpl();
		dao.saveNewApplicationFromUser(this);

	}

}
