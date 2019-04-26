package com.revaure.mybankingapp.dao;

import com.revature.mybankingapp.Account;

public interface AccountDAO {
	public String withdraw(Account account, double amount);
	public String transfer(double amount, Account fromaccount, long toaccountnumber);
	public String deposit(Account account, double amount);
	public String cancel(Account account);
}
