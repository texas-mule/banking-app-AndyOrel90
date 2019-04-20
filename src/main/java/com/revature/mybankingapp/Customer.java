package com.revature.mybankingapp;

public class Customer extends User {

	@Override
	public String toString() {
		return "Customer [userid=" + userid + ", firstname=" + firstname + ", lastname=" + lastname + ", username="
				+ username + ", password=" + password + ", usertype=" + usertype + ", accountlist=" + accountlist + "]";
	}



}
