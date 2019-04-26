package com.revaure.mybankingapp.dao;

import java.util.ArrayList;

import com.revature.mybankingapp.Account;
import com.revature.mybankingapp.Customer;

public interface CustomerDAO {
	
	public Customer login(String username, String password);
	public ArrayList<Customer> getCustomers();
	public String withdraw(Account account, double amount);
	public String transfer(double amount, Account fromaccount, long toaccountnumber);
	public String deposit(Account account, double amount);
	
}
