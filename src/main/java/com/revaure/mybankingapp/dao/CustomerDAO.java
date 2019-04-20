package com.revaure.mybankingapp.dao;

import java.util.ArrayList;

import com.revature.mybankingapp.Customer;

public interface CustomerDAO {
	
	public Customer login(String username, String password);
	public ArrayList<Customer> getCustomers();
	public void addCustomer(Customer customer);
	
}
