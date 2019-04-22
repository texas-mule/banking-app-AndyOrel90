package com.revature.mybankingapp;

import java.util.ArrayList;

import com.revaure.mybankingapp.dao.AccountDAOImpl;
import com.revaure.mybankingapp.dao.CustomerDAOImpl;

public class Customer extends User {
	
	CustomerDAOImpl dao = new CustomerDAOImpl();

	@Override
	public String toString() {
		return "Customer [userid=" + userid + ", firstname=" + firstname + ", lastname=" + lastname + ", username="
				+ username + ", password=" + password + ", usertype=" + usertype + ", accountlist=" + accountlist + "]";
	}

	public void withdraw(Account account, long amount) {
		
		System.out.println("");
		System.out.println(this.dao.withdraw(account, amount));
		System.out.println("");
		
	}

	public void transfer(long amount, Account fromaccount, long toaccountnumber) {
		
		System.out.println("");
		System.out.println(this.dao.transfer(amount, fromaccount, toaccountnumber));
		System.out.println("");
		
	}

	public void deposit(Account account, long amount) {
		
		System.out.println("");
		System.out.println(this.dao.deposit(account, amount));
		System.out.println("");
		
	}
	
	public void setAccountList() {
		this.accountlist = dao.getThisCustomerAccounts(this.userid);
	}
	
	public ArrayList<Account> getAccountList(){
		return this.accountlist;
	}

}
