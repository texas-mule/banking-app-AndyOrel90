package com.revaure.mybankingapp.dao;

import com.revature.mybankingapp.Account;

public interface AccountDAO {
	public String withdraw(Account account, long amount);
	public String transfer(long amount, Account fromaccount, long toaccountnumber);
	public String deposit(Account account, long amount);
	public String cancel(Account account);
}
