package com.revaure.mybankingapp.dao;

import java.util.ArrayList;

import com.revature.mybankingapp.Account;
import com.revature.mybankingapp.Customer;

public interface CustomerDAO {
	
	public Customer login(String username, String password);
	public ArrayList<Customer> getCustomers();
	public String withdraw(Account account, long amount);
	public String transfer(long amount, Account fromaccount, long toaccountnumber);
	public String deposit(Account account, long amount);
	
}
