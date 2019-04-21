package com.revature.mybankingapp;

import com.revaure.mybankingapp.dao.AccountDAOImpl;
import com.revaure.mybankingapp.dao.ApplicationDAOImpl;

public class Account {
	long accountnumber;
	long ownerid1;
	long ownerid2;
	long routingnumber;
	long accountbalance;
	String accounttype;
	AccountDAOImpl dao = new AccountDAOImpl();

	public long getAccountnumber() {
		return accountnumber;
	}

	public void setAccountnumber(long accountnumber) {
		this.accountnumber = accountnumber;
	}

	public long getOwnerid1() {
		return ownerid1;
	}

	public void setOwnerid1(long ownerid1) {
		this.ownerid1 = ownerid1;
	}

	public long getOwnerid2() {
		return ownerid2;
	}

	public void setOwnerid2(long ownerid2) {
		this.ownerid2 = ownerid2;
	}

	public long getRoutingnumber() {
		return routingnumber;
	}

	public void setRoutingnumber(long routingnumber) {
		this.routingnumber = routingnumber;
	}

	public long getAccountbalance() {
		return accountbalance;
	}

	public void setAccountbalance(long accountbalance) {
		this.accountbalance = accountbalance;
	}

	public String getAccounttype() {
		return accounttype;
	}

	public void setAccounttype(String accounttype) {
		this.accounttype = accounttype;
	}

	public String withdraw(Account account, long amount) {

		return this.dao.withdraw(account, amount);
		
	}

	public String transfer(long amount, Account fromaccount, long toaccountnumber) {

		return this.dao.transfer(amount, fromaccount, toaccountnumber);
		
	}

	public String deposit(Account account, long amount) {
		
		return this.dao.deposit(account, amount);
		
	}


}
