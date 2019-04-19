package com.revature.mybankingapp;

import java.util.ArrayList;

public class User {
	long userid;
	private String firstname;
	private String lastname;
	private String username;
	private String password;
	private String usertype;
	private ArrayList<Account> accountlist;
	
	public long getUserid() {
		return userid;
	}
	public void setUserid(long userid) {
		this.userid = userid;
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
	public ArrayList<Account> getAccountlist() {
		return accountlist;
	}
	public void setAccountlist(ArrayList<Account> accountlist) {
		this.accountlist = accountlist;
	}
	
	
}
