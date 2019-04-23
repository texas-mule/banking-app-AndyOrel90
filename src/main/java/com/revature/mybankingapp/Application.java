package com.revature.mybankingapp;

import com.revaure.mybankingapp.dao.ApplicationDAOImpl;

public class Application {
	private long applicationid;
	private String firstname;
	private String lastname;
	private String username;
	private String password;
	private String usertype;
	private String accounttype;
	private long depositamount;
	private String status;
	private long currentuser;
	private String firstname2;
	private String lastname2;
	private String username2;
	private String password2;
	private long currentuser2; 
	private boolean isjointaccount = false;
	private ApplicationDAOImpl dao = new ApplicationDAOImpl();
	
	public String getFirstname2() {
		return firstname2;
	}

	public void setFirstname2(String firstname2) {
		this.firstname2 = firstname2;
	}

	public String getLastname2() {
		return lastname2;
	}

	public void setLastname2(String lastname2) {
		this.lastname2 = lastname2;
	}

	public String getUsername2() {
		return username2;
	}

	public void setUsername2(String username2) {
		this.username2 = username2;
	}

	public String getPassword2() {
		return password2;
	}

	public void setPassword2(String password2) {
		this.password2 = password2;
	}

	public long getCurrentuser2() {
		return currentuser2;
	}

	public void setCurrentuser2(long currentuser2) {
		this.currentuser2 = currentuser2;
	}

	public long getCurrentuser() {
		return currentuser;
	}

	public void setCurrentuser(long currentuser) {
		this.currentuser = currentuser;
	}

	@Override
	public String toString() {
		if(this.isjointaccount)
		{
			return "Application [applicationid=" + applicationid + ", firstname=" + firstname + ", lastname=" + lastname
					+ ", username=" + username + ", password=" + password + ", usertype=" + usertype + ", accounttype="
					+ accounttype + ", depositamount=" + depositamount + ", status=" + status + ", Second Firstname=" + firstname2 + ", Second Lastname=" + lastname2 + ", Second Username=" + username2 + ", Second Password=" + password2 + "]";
		}
		else
		{
			return "Application [applicationid=" + applicationid + ", firstname=" + firstname + ", lastname=" + lastname
					+ ", username=" + username + ", password=" + password + ", usertype=" + usertype + ", accounttype="
					+ accounttype + ", depositamount=" + depositamount + ", status=" + status + "]";
		}
		
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

		this.dao.saveNewApplication(this);

	}
	
	public void saveNewJointApplication() {

		this.dao.saveNewJointApplication(this);

	}

	public void saveNewApplicationFromUser() {

		this.dao.saveNewApplicationFromUser(this);

	}
	
	public void saveNewJointApplicationFromUser(){
		this.dao.saveNewJointApplicationFromUser(this);
	}

	public boolean getIsjointaccount() {
		return isjointaccount;
	}

	public void setIsjointaccount(boolean isjointaccount) {
		this.isjointaccount = isjointaccount;
	}

}
